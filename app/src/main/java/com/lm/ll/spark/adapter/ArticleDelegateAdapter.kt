package com.lm.ll.spark.adapter

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter
import com.lm.ll.spark.db.Article
import io.realm.RealmList


/**
 * 作者：Created by ll on 2018-07-06 17:35.
 * 邮箱：wenhelinlu@gmail.com
 */
class ArticleDelegateAdapter(activity: AppCompatActivity, items: RealmList<Article>) : ListDelegationAdapter<RealmList<Article>>() {

    //Recyclerview内部item的自定义单击事件，用于通过点击正文显示或隐藏状态栏和底部工具栏
    lateinit var mItemClickListener: ArticleDelegateAdapter.Companion.OnItemClickListener

    init {

        // DelegatesManager is a protected Field in ListDelegationAdapter
        delegatesManager.addDelegate(VIEW_TYPE_TEXT, ArticleTextAdapterDelegate(activity))
                .addDelegate(VIEW_TYPE_SPLITTER, ArticleSplitterAdapterDelegate(activity))
                .addDelegate(VIEW_TYPE_COMMENT, ArticleCommentAdapterDelegate(activity))

        // Set the items from super class.
        setItems(items)
    }

    companion object {
        const val VIEW_TYPE_TEXT = 0 //标识正文item
        const val VIEW_TYPE_SPLITTER = 1 //标识分割条item
        const val VIEW_TYPE_COMMENT = 2 //标识评论item

        interface OnItemClickListener {
            fun onItemClick(view: View)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val vh = super.onCreateViewHolder(parent, viewType)
        //点击正文时才控制状态栏和底部工具栏的可见性
        if (viewType == VIEW_TYPE_TEXT) {
            (vh.itemView as ViewGroup).getChildAt(0).setOnClickListener {
                mItemClickListener.onItemClick(it)
            }
        }
        return vh
    }
}