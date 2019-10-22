package com.jackcomeback.jinhan.board.entity

import org.springframework.data.annotation.Immutable
import javax.persistence.*

@Entity
@Table(name="CONTENTS")
@Immutable
data class ViewContents(
        @Id
        @Column(name="CONTENTS_ID")
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?=null,
        @Column(name="BODY_CONTENTS")
        var bodyContents: String
)
