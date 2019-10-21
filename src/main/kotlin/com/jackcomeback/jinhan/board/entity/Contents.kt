package com.jackcomeback.jinhan.board.entity

import javax.persistence.*

@Entity
@Table(name="CONTENTS")
data class Contents(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?=null,
        @Column(name="BODY_CONTENTS")
        var bodyContents: String,
        @ManyToOne
        var writer : User
)
