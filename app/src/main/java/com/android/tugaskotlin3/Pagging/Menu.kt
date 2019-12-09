package com.android.tugaskotlin3.Pagging

import com.google.gson.annotations.SerializedName

data class Menu (
    @field:SerializedName("name_product")
    val name_product: String? = null,

    @field:SerializedName("price")
    val price: String? = null,

    @field:SerializedName("images")
    val images: String? = null,
    @field:SerializedName("updated_at")
    val update_at: String? = null,
    @field:SerializedName("created_at")
    val created_at: String? = null,
    @field:SerializedName("id")
    val id: Int? = null





)