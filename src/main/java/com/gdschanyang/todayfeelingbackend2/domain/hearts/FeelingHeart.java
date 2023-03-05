package com.gdschanyang.todayfeelingbackend2.domain.hearts;

import com.gdschanyang.todayfeelingbackend2.domain.posts.FeelingPost;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

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

    @Builder
    public FeelingHeart(User user, FeelingPost feelingPost) {
        Assert.notNull(user, "user must not be null");
        Assert.notNull(feelingPost, "feelingPost must not be null");

        this.user = user;
        this.feelingPost = feelingPost;
    }
}