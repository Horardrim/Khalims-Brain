package com.horadrim.khalims.brain.dao.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.horadrim.khalims.brain.dao.entity.TestUser;

public interface TestUserRepository extends JpaRepository<TestUser, Integer> {
    Optional<TestUser> findByUsername(String username);
}
