package com.lm.ll.spark.adapter

import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.hannesdorfmann.adapterdelegates3.AdapterDelegate
import com.lm.ll.spark.R
import com.lm.ll.spark.db.Article
import io.realm.RealmList
import kotlinx.android.synthetic.main.article_item_comment.view.*


/**
 * 作者：Created by ll on 2018-07-06 17:34.
 * 邮箱：wenhelinlu@gmail.com
 */
class ArticleCommentAdapterDelegate(activity: AppCompatActivity) : AdapterDelegate<RealmList<Article>>() {
    private var inflater: LayoutInflater = activity.layoutInflater

    override fun onCreateViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder {
        return ArticleCommentViewHolder(inflater.inflate(R.layout.article_item_comment, parent, false))
    }

    override fun isForViewType(items: RealmList<Article>, position: Int): Boolean {
        if (items[position] != null) {
            return items[position]!!.isArticle == 1
        }
        return false
    }

    override fun onBindViewHolder(items: RealmList<Article>, position: Int, holder: RecyclerView.ViewHolder, payloads: MutableList<Any>) {
        val vh = holder as ArticleCommentViewHolder
        with(vh) {
            items[position]?.let {
                commentTitle.text = it.title

                commentAuthor.text = it.author
                commentDate.text = it.date
                commentTextLength.text = it.textLength
                commentReadCount.text = it.readCount
            }
        }
    }

    inner class ArticleCommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val commentItem: ConstraintLayout = itemView.comment_item
        val commentTitle: TextView = itemView.comment_title
        val commentAuthor: TextView = itemView.comment_author
        val commentDate: TextView = itemView.comment_date
        val commentTextLength: TextView = itemView.comment_textLength
        val commentReadCount: TextView = itemView.comment_readCount
    }
}