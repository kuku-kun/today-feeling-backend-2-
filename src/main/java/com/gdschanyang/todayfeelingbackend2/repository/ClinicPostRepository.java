package com.gdschanyang.todayfeelingbackend2.repository;

import com.gdschanyang.todayfeelingbackend2.domain.posts.ClinicPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicPostRepository extends JpaRepository<ClinicPost, Long> {
    // 클리닉 센터 글쓰기 기능 처리 CRUD

    // 글 저장

    // 글 수정

    // 글 삭제

}
