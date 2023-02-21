package com.gdschanyang.todayfeelingbackend2.domain.user;

import com.gdschanyang.todayfeelingbackend2.domain.hearts.ClinicHeart;
import com.gdschanyang.todayfeelingbackend2.domain.hearts.FeelingHeart;
import com.gdschanyang.todayfeelingbackend2.domain.posts.ClinicPost;
import com.gdschanyang.todayfeelingbackend2.domain.posts.FeelingPost;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_NAME", nullable = false)
    private String name;

    // 유저 : 유저가 쓴 감정글 = 1:n
    @OneToMany(mappedBy = "user")
    private List<FeelingPost> feelingPosts = new ArrayList<FeelingPost>();

    // 유저 : 유저가 누른 공감글 = 1:n
    @OneToMany(mappedBy = "user")
    private List<FeelingHeart> feelingHearts = new ArrayList<FeelingHeart>();

    // 유저 : 유저가 쓴 클리닉글 = 1:N
    @OneToMany(mappedBy = "user")
    private List<ClinicPost> clinicPosts = new ArrayList<ClinicPost>();

    // 유저 : 유저가 공감한 클리닉 글 = 1:N
    @OneToMany(mappedBy = "user")
    private List<ClinicHeart> clinicHearts = new ArrayList<ClinicHeart>();

    public void addFeelingPost(FeelingPost feelingPost){
        this.feelingPosts.add(feelingPost);
        if(feelingPost.getUser() != this){
            feelingPost.getUser();
        }
    }
    public void addFeelingHeart(FeelingHeart feelingHeart){
        this.feelingHearts.add(feelingHeart);
        if(feelingHeart.getUser() != this){
            feelingHeart.setUser(this);
        }
    }

    public void addClinicPost(ClinicPost clinicPost){
        this.clinicPosts.add((clinicPost));
        if(clinicPost.getUser() != this){
            clinicPost.setUser(this);
        }
    }

    public void addClinicHeart(ClinicHeart clinicHeart){
        this.clinicHearts.add((clinicHeart));
        if(clinicHeart.getClinicHeart() != this){
            clinicHeart.setUser(this);
        }
    }
}