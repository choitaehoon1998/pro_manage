package com.tae.hoon.speciallist.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserQueryRepository {
    private final JPAQueryFactory queryFactory;
}
