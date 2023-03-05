package com.gdschanyang.todayfeelingbackend2.Clinic;

import com.gdschanyang.todayfeelingbackend2.domain.hearts.ClinicHeart;
import com.gdschanyang.todayfeelingbackend2.domain.posts.ClinicPost;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import com.gdschanyang.todayfeelingbackend2.repository.ClinicPostRepository;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootApplication
public class ClinicPostRepositoryTest {

    @Autowired
    ClinicPostRepository clinicPostRepository;

    @After(value = "execution(* com.test.controller.TestController.*(..))")
    public void cleanup(){
        clinicPostRepository.deleteAll();
    }

    @Test
    public void POST_SAVE(User user, ClinicHeart clinicHeart){
        // given
        String title = "CLINIC";
        String content = "IT'S CLINIC";

        clinicPostRepository.save(ClinicPost.builder()
                        .title(title)
                        .content(content)
                        .user(null).clinicHearts(null)
                        .build());
        // when
        List<ClinicPost> clinicPostList = clinicPostRepository.findAll();

        // then
        ClinicPost clinicPost = clinicPostList.get(0);
        assertThat(clinicPost.getTitle()).isEqualTo(title);
        assertThat(clinicPost.getContent()).isEqualTo(content);
    }
}
