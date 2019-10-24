package com.jackcomeback.jinhan

import com.jackcomeback.jinhan.board.entity.User
import com.jackcomeback.jinhan.board.repo.UserRepository
import com.jackcomeback.jinhan.board.value.Address
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
class RepoTest{

    @Autowired
    private lateinit var testEntityManager: TestEntityManager
    @Autowired
    private lateinit var userRepo : UserRepository
    @Test
    fun `When findByNameOrNull then return User`() {

        val jinhan = User(loginId= "jinhanchoi1", name = "111111", password= "test", address= Address("서울특별시 구로구 새말로 93","신도림태영아파트"))
        testEntityManager.persist(jinhan)
        testEntityManager.flush()
        val found = userRepo.findByName(jinhan.name)
        assertThat(found).isEqualTo(jinhan)
    }
}