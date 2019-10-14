package com.jackcomeback.jinhan.board.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Int? = null,
        var name: String,
        var password: String?) {
    //기본생성자 무조건 있어야 함.
    constructor() : this(null, "","")
}