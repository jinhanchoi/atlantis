package com.jackcomeback.jinhan.controller

import com.jackcomeback.jinhan.board.entity.User
import com.jackcomeback.jinhan.board.repo.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/User")
class UserController(val userRepo : UserRepository) {
    @GetMapping("/{id}")
    fun findSavedName(@PathVariable("id") id: Int) : User{
        return userRepo.findById(id).get()
    }
    @PostMapping
    fun saveMyName(@RequestBody user : User) : User{
        val saved = userRepo.save(User(name = user.name, password= "test"))
        val searchId : Int = saved!!.id!!
        val savedName = userRepo.findById(searchId)
        return savedName.get()
    }
}