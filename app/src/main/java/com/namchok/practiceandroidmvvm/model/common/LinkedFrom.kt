package com.namchok.practiceandroidmvvm.model.common

import com.namchok.practiceandroidmvvm.model.common.ExternalUrls

data class LinkedFrom(
    val external_urls: ExternalUrls,
    val href: String,
    val id: String,
    val type: String,
    val uri: String
)