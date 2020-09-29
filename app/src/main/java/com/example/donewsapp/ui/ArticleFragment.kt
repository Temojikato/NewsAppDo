package com.example.donewsapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.donewsapp.R
import kotlinx.android.synthetic.main.fragment_article.*

class ArticleFragment : Fragment(R.layout.fragment_article) {
    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel

        val article = args.article

        if (article.urlToImage !== null){
            Glide.with(this).load(article.urlToImage).into(article_image)
        }
        article_title.text = article.title
        article_url.text = article.url + " (opens in browser)"
        if (article.content !== null){
            article_content.text = article.content.toString()
        }

    }


}