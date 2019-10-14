package com.jackcomeback.jinhan.controller

import com.jackcomeback.jinhan.board.entity.User
import com.jackcomeback.jinhan.board.repo.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping


@Controller
@RequestMapping("/Board")
class BoardController(@Autowired private val userRepository: UserRepository) {

    @GetMapping("/{name}")
    fun getUser(model: Model, @PathVariable("name") name: String) : String{
        model.addAttribute("user",userRepository.findByName(name))
        return "board"
    }
}