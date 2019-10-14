package com.jackcomeback.jinhan.board.repo

import com.jackcomeback.jinhan.board.entity.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository : CrudRepository<User,Int> {
    fun save(user : User) : User?
    fun findByName(name: String) : User?
}