package com.lm.ll.spark.util

import android.content.Context
import com.lm.ll.spark.db.*
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor


/**
 * BoxStore单例
 * 作者：Created by ll on 2018-07-24 16:59.
 * 邮箱：wenhelinlu@gmail.com
 */
object ObjectBox {
    //BoxStore实例
    lateinit var boxStore: BoxStore
        private set

    fun build(context: Context) {
        boxStore = MyObjectBox.builder().androidContext(context.applicationContext).build()
    }

    /**
     * @desc Article的Box实例，用于ObjectBox数据库中Article表的相关操作
     * @author ll
     * @time 2018-07-26 15:45
     */
    fun getArticleBox():Box<Article>{
        return boxStore.boxFor()
    }

    /**
     * @description Comment的Box实例，用于ObjectBox数据库中Comment表的相关操作
     * @date: 2019-11-01 14:06
     * @author: LuHui
     * @param
     * @return
     */
    fun getCommentBox(): Box<Comment> {
        return boxStore.boxFor()
    }

    /**
     * @desc QueryRecord的Box实例，用于ObjectBox数据库中QueryRecord表的相关操作
     * @author ll
     * @time 2018-08-14 15:46
     */
    fun getQueryRecordBox():Box<QueryRecord>{
        return boxStore.boxFor()
    }

    /**
     * @desc SiteMap的Box实例，用于ObjectBox数据库中SiteMap表的相关操作
     * @author lm
     * @time 2018-09-09 21:02
     */
    fun getSubForumBox(): Box<SubForum> {
        return boxStore.boxFor()
    }

}