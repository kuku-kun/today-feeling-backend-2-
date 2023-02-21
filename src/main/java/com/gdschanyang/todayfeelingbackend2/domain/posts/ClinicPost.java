package com.gdschanyang.todayfeelingbackend2.domain.posts;

import com.gdschanyang.todayfeelingbackend2.domain.hearts.ClinicHeart;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class ClinicPost {
    // 클리닉 글
    // 제목, 글, 저자

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLINIC_POST_ID")
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    // 글 작성은 필수
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // 클리닉글 : 유저 = n:1
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    // 클리닉글 : 공감한 클리닉글 = 1 : n
    @OneToMany(mappedBy = "clinicPost")
    private List<ClinicHeart> clinicHearts = new ArrayList<ClinicHeart>();

    public void setUser(User user){
        this.user = user;
        if(!user.getClinicPosts().contains(this)){
            user.getClinicPosts().add(this);
        }
    }

    public void addClinicPost(ClinicHeart clinicHeart){
        this.clinicHearts.add(clinicHeart);
        if(clinicHeart.getClinicPost() != this){
            clinicHeart.setClinicPost(this);
        }
    }

}