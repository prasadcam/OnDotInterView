package com.example.ondottask.model

import com.squareup.moshi.Json

class Hit {

    @Json(name = "id")
    var id: Int? = null
    @Json(name = "pageURL")
    var pageURL: String? = null
    @Json(name = "type")
    var type: String? = null
    @Json(name = "tags")
    var tags: String? = null
    @Json(name = "previewURL")
    var previewURL: String? = null
    @Json(name = "previewWidth")
    var previewWidth: Int? = null
    @Json(name = "previewHeight")
    var previewHeight: Int? = null
    @Json(name = "webformatURL")
    var webformatURL: String? = null
    @Json(name = "webformatWidth")
    var webformatWidth: Int? = null
    @Json(name = "webformatHeight")
    var webformatHeight: Int? = null
    @Json(name = "largeImageURL")
    var largeImageURL: String? = null
    @Json(name = "fullHDURL")
    var fullHDURL: String? = null
    @Json(name = "imageURL")
    var imageURL: String? = null
    @Json(name = "imageWidth")
    var imageWidth: Int? = null
    @Json(name = "imageHeight")
    var imageHeight: Int? = null
    @Json(name = "imageSize")
    var imageSize: Int? = null
    @Json(name = "views")
    var views: Int? = null
    @Json(name = "downloads")
    var downloads: Int? = null
    @Json(name = "favorites")
    var favorites: Int? = null
    @Json(name = "likes")
    var likes: Int? = null
    @Json(name = "comments")
    var comments: Int? = null
    @Json(name = "user_id")
    var userId: Int? = null
    @Json(name = "user")
    var user: String? = null
    @Json(name = "userImageURL")
    var userImageURL: String? = null

}
