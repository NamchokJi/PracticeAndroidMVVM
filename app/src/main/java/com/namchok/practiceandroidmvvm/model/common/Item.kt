package com.namchok.practiceandroidmvvm.model.common

data class Item(
    val added_at: String,
    val added_by: AddedBy,
    val is_local: Boolean,
    val primary_color: Any,
    val track: Track,
    val video_thumbnail: VideoThumbnail
)