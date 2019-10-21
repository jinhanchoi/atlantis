package com.jackcomeback.jinhan.board.value

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
data class Address(
        @Column(name="ADDR_1")
        val address1: String,
        @Column(name="ADDR_2")
        val address2: String
        ) {
  constructor() : this("","")
}