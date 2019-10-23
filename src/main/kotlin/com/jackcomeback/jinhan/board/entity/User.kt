package com.jackcomeback.jinhan.board.entity


import com.jackcomeback.jinhan.board.value.Address
import javax.persistence.*
import kotlin.jvm.Transient

@Entity
@Table(name="User")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="USER_ID")
        var id: Long? = null,
        @Column(name="LOGIN_ID")
        var loginId: String,
        @Column(name="NAME")
        var name: String,
        @Column(name="PASSWORD")
        var password: String?,
        @Embedded
        var address: Address?,
        @Transient
        private var _contents: MutableList<Contents> = mutableListOf()) {
    //기본생성자 무조건 있어야 함.
    constructor() : this(null, "","","",null)
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "writer")
    var contents : MutableList<Contents> = _contents
    get() {return field}
    set(value){
        field = value
    }
}