package com.alke.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alke.wallet.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}