package com.gdschanyang.todayfeelingbackend2.domain.hearts;

import com.gdschanyang.todayfeelingbackend2.domain.posts.FeelingPost;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class FeelingHeart {
    // 글 공감
    // 공감 유저, 공감한 글 -> 일대다 단방향 맵핑

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // 유저가 공감한 글 : 유저 = n : 1
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne // 유저가 공감한 글 : 작성한 감정글 = n : 1
    @JoinColumn(name = "FEELING_POST_ID")
    private FeelingPost feelingPost;

    public void setUser(User user){
        this.user  = user;
        if(!user.getFeelingHearts().contains(this)){
            user.getFeelingHearts().add(this);
        }
    }

    public void setFeelingPost(FeelingPost feelingPost){
        this.feelingPost = feelingPost;
        if(!feelingPost.getFeelingHearts().contains(this)){
            feelingPost.getFeelingHearts().add(this);
        }
    }
}