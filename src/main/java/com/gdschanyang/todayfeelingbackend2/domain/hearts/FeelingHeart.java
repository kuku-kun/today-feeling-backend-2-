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
    // �� ����
    // ���� ����, ������ �� -> �ϴ�� �ܹ��� ����

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // ������ ������ �� : ���� = n : 1
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne // ������ ������ �� : �ۼ��� ������ = n : 1
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