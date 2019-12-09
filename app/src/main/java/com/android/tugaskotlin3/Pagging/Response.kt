package com.Pagging

import com.android.tugaskotlin3.Pagging.Menu
import com.google.gson.annotations.SerializedName

data class Response (
    @field:SerializedName("pesan")
    val pesan: String? = null,

    @field:SerializedName("menu")
    val menu: List<Menu>

)