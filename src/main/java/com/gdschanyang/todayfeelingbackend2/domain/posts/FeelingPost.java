package com.gdschanyang.todayfeelingbackend2.domain.posts;

import com.gdschanyang.todayfeelingbackend2.domain.BaseTimeEntity;
import com.gdschanyang.todayfeelingbackend2.domain.hearts.FeelingHeart;
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
public class FeelingPost extends BaseTimeEntity {
    // ������
    // ����, ��, ����, ��������
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEELING_POST_ID")
    private Long id;

    @Column(nullable = false)
    private Feeling feeling;

    // �� �ۼ��� ������
    @Column(columnDefinition = "TEXT")
    private String content;

    // ��������
    @Column(nullable = false)
    private boolean del;

    // �����۰� ������ n:1 ����
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    // �����۰� �����۷� 1:n ����
    @OneToMany(mappedBy = "feelingPost")
    private List<FeelingHeart> feelingHearts = new ArrayList<FeelingHeart>();

    @Builder
    public FeelingPost( Feeling feeling, String content, Boolean del,
                        User user, List<FeelingHeart> feelingHearts) {
        this.feeling = feeling;
        this.content = content;
        this.del = del;
        this.user = user;
        this.feelingHearts = feelingHearts;
    }

}