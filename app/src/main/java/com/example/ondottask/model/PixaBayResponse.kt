package com.example.ondottask.model

import com.squareup.moshi.Json

class PixaBayResponse {

    @Json(name = "total")
    var total: Int? = null
    @Json(name = "totalHits")
    var totalHits: Int? = null
    @Json(name = "hits")
    var hits: List<Hit>? = null

}
