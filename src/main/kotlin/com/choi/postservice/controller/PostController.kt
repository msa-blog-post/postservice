package com.choi.postservice.controller

import com.choi.postservice.dto.Post
import com.choi.postservice.service.PostService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController(private val postService: PostService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createPost(@RequestBody post: Post): Post {
        return postService.createPost(post)
    }

    @GetMapping("/{id}")
    fun getPostById(@PathVariable id: Long): Post {
        return postService.getPostById(id)
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody updatedPost: Post): Post {
        return postService.updatePost(id, updatedPost)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePost(@PathVariable id: Long) {
        postService.deletePost(id)
    }

    @PostMapping("/{id}/publish")
    fun publishPost(@PathVariable id: Long): Post {
        return postService.publishPost(id)
    }
}
