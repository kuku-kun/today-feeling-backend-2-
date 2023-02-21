package com.gdschanyang.todayfeelingbackend2.repository;

import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 유저 정보 처리

    // 기록하기 - C
    User save(User user);

    // 실제 이름 출력 - R
    Optional<User> findById(Long id);

    // 감정 표현 - R
    List<User> findAll();
}
