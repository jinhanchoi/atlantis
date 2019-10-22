package com.jackcomeback.jinhan.controller

import com.jackcomeback.jinhan.board.entity.Contents
import com.jackcomeback.jinhan.board.entity.User
import com.jackcomeback.jinhan.board.repo.BoardRepository
import com.jackcomeback.jinhan.board.repo.UserRepository
import com.jackcomeback.jinhan.board.value.Address
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/User")
class UserController(val userRepo : UserRepository, val boardRepo : BoardRepository) {
    @GetMapping("/{id}")
    fun findSavedName(@PathVariable("id") id: Long) : ResponseEntity<User> {
        return userRepo.findById(id).map { user -> ResponseEntity.ok(user)}.orElse(ResponseEntity.notFound().build())
    }
    @PostMapping
    fun saveMyName(@RequestBody user : User) : User{
        val saved = userRepo.save(User(loginId= "jinhanchoi1", name = user.name, password= "test", address=Address("서울특별시 구로구 새말로 93","신도림태영아파트")))
        val searchId : Long = saved!!.id!!
        val savedName = userRepo.findById(searchId)

        //boardRepo.save(Contents(bodyContents = "board body contents is ...", writer = saved))
        return savedName.get()
    }

    @PostMapping("/Contents/{id}")
    fun saveContents(@PathVariable("id") id: Long , @RequestBody contents: Contents) : Contents{
        val savedName = userRepo.findById(id)
        contents.writer.id = id
        println(contents.writer.id.toString())
       return boardRepo.save(contents)
    }
}
