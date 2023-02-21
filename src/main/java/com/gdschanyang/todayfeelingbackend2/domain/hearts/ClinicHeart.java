package com.gdschanyang.todayfeelingbackend2.domain.hearts;

import com.gdschanyang.todayfeelingbackend2.domain.posts.ClinicPost;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public void setUser(User user){
        this.user = user;
        if(!user.getClinicHearts().contains(this)){
            user.getClinicHearts().add(this);
        }
    }

    public void setClinicPost(ClinicPost clinicPost){
        this.clinicPost = clinicPost;
        if(!clinicPost.getClinicHearts().contains(this)){
            clinicPost.getClinicHearts().add(this);
        }
    }


}