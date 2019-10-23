package com.jackcomeback.jinhan.board.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import kotlin.jvm.Transient

@Entity
@Table(name="CONTENTS")
data class Contents(
        @Id
        @Column(name="CONTENTS_ID")
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long?=null,
        @Column(name="BODY_CONTENTS")
        var bodyContents: String,
        @Transient
        private var _writer : User?
){
        @JsonIgnore
        @ManyToOne(fetch= FetchType.LAZY)
        @JoinColumn(name="WRITER_USER_ID")
        var writer : User? = _writer
                get() { return field}
                set(value) { field = value}
}
