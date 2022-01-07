package com.tae.hoon.speciallist.user.repository;

import com.tae.hoon.speciallist.Enum.gender.Gender;
import com.tae.hoon.speciallist.user.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        User user = User.builder()
                .userId(1L)
                .gender(Gender
                        .MAN)
                .build();
        userRepository.save(user);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("Seq 저장되는지 테스트")
    void saveSeqTest() {
        List<User> userList = userRepository.findAll();

        User savedUser = userList.get(0);
    }

}