package com.gdschanyang.todayfeelingbackend2.domain.posts;

import com.gdschanyang.todayfeelingbackend2.domain.hearts.FeelingHeart;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class FeelingPost {
    // 감정글
    // 감정, 글, 저자, 삭제여부
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEELING_POST_ID")
    private Long id;

    @Column(nullable = false)
    private Feeling feeling;

    // 글 작성은 선택적
    @Column(columnDefinition = "TEXT")
    private String content;

    // 삭제여부
    @Column(nullable = false)
    private boolean del;

    // 감정글과 유저로 n:1 맵핑
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    // 감정글과 공감글로 1:n 맵핑
    @OneToMany(mappedBy = "feelingPost")
    private List<FeelingHeart> feelingHearts = new ArrayList<FeelingHeart>();

    public void setUser(User user){
        this.user = user;
        if(!user.getFeelingPosts().contains(this)){
            user.getFeelingPosts().add(this);
        }
    }

    public void addFeelingPost(FeelingHeart feelingHeart){
        this.feelingHearts.add(feelingHeart);
        if(feelingHeart.getFeelingPost() != this){
            feelingHeart.setFeelingPost(this);
        }
    }
}