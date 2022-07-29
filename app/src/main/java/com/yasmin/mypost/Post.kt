package com.yasmin.mypost

import android.icu.text.CaseMap

data class Post(
    var userId: Int,
    var Id : Int,
    var title: String,
    var body: String,
)

data class Comment(
    var post: Int,
    var id: Int,
    var name: String,
    var email: String,
    var body: String,
)
