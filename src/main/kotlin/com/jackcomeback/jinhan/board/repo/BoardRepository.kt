package com.jackcomeback.jinhan.board.repo

import com.jackcomeback.jinhan.board.entity.Contents
import org.springframework.data.repository.CrudRepository

interface BoardRepository : CrudRepository<Contents,Long> {
    fun save(contents: Contents) : Contents
}