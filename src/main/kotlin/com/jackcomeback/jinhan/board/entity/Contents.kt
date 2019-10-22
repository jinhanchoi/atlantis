package com.jackcomeback.jinhan.board.entity

import javax.persistence.*

@Entity
@Table(name="CONTENTS")
data class Contents(
        @Id
        @Column(name="CONTENTS_ID")
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?=null,
        @Column(name="BODY_CONTENTS")
        var bodyContents: String,
        @ManyToOne
        var writer : User
)
