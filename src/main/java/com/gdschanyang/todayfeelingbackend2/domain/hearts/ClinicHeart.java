package com.gdschanyang.todayfeelingbackend2.domain.hearts;

import com.gdschanyang.todayfeelingbackend2.domain.posts.ClinicPost;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ClinicHeart{
    // 클리닉 공감
    // 공감 유저, 공감한 클리닉 글 -> 일대다 단방향 맵핑

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 공감받은 클리닉 글 : 유저 = n:1
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    // 공감받은 클리닉 글 : 클리닉 글 = n:1
    @ManyToOne
    @JoinColumn(name = "CLINIC_POST_ID")
    private ClinicPost clinicPost;

    @Builder
    public ClinicHeart(User user, ClinicPost clinicPost) {
        Assert.notNull(user, "user must not be null");
        Assert.notNull(clinicPost, "clinicPost must not be null");
        this.user = user;
        this.clinicPost = clinicPost;
    }


}