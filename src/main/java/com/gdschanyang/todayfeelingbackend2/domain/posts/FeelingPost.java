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