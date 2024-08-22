package com.choi.postservice.dto

import jakarta.persistence.*

@Entity
data class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val userId: Long,
    val title: String,
    val content: String,

    @Enumerated(EnumType.STRING)
    var status: PostStatus = PostStatus.DRAFT
)

enum class PostStatus {
    DRAFT, PUBLISHED
}