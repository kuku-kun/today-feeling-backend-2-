package com.gdschanyang.todayfeelingbackend2.repository;

import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // ���� ���� ó��

    // ����ϱ� - C
    User save(User user);

    // ���� �̸� ��� - R
    Optional<User> findById(Long id);

    // ���� ǥ�� - R
    List<User> findAll();
}
