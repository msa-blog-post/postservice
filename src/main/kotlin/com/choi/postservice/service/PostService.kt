package com.choi.postservice.service

import com.choi.postservice.dto.Post
import com.choi.postservice.dto.PostStatus
import com.choi.postservice.exception.PostNotFoundException
import com.choi.postservice.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostService(private val postRepository: PostRepository) {

    fun createPost(post: Post): Post {
        return postRepository.save(post)
    }

    fun getPostById(id: Long): Post {
        return postRepository.findById(id).orElseThrow { PostNotFoundException("Post not found with id $id") }
    }

    fun updatePost(id: Long, updatedPost: Post): Post {
        val post = getPostById(id)
        val postToSave = post.copy(
            title = updatedPost.title,
            content = updatedPost.content,
            status = updatedPost.status
        )
        return postRepository.save(postToSave)
    }

    fun deletePost(id: Long) {
        val post = getPostById(id)
        postRepository.delete(post)
    }

    fun publishPost(id: Long): Post {
        val post = getPostById(id)
        post.status = PostStatus.PUBLISHED
        return postRepository.save(post)
    }
}