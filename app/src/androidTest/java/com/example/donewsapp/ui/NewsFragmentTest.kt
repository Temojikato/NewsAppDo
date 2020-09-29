package com.example.donewsapp.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.donewsapp.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class NewsFragmentTest  {
    @get: Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val LIST_ITEM = 1

    @Test
    fun test_isRecyclerVisible_onAppLaunch(){
        onView(withId(R.id.rvNews)).check(matches(isDisplayed()))
    }

    @Test
    fun test_selectListItem_isDetailFragmentVisible(){
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        onView(withId(R.id.rvNews)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(LIST_ITEM,click())
        )
        onView(withId(R.id.article_title)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isRecyclerVisible_OnBack(){
        //unsafe?
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        onView(withId(R.id.rvNews)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(LIST_ITEM,click())
        )
        Espresso.pressBack()
        onView(withId(R.id.rvNews)).check(matches(isDisplayed()))

    }
}