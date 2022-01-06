package com.tae.hoon.speciallist.user.repository;

import com.tae.hoon.speciallist.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserQueryRepository {
}
