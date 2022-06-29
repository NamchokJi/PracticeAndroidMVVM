package com.namchok.practiceandroidmvvm.model.dao

import com.google.gson.annotations.SerializedName

abstract class BaseDao{
    @SerializedName("error")
    var error: ErrorDetail? = null

    class ErrorDetail{
        @SerializedName("message")
        var messageResponse: String? = null

        @SerializedName("status")
        var statusResponse: String? = null
    }

}