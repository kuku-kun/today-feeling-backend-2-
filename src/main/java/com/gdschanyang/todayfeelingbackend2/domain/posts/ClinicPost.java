package com.gdschanyang.todayfeelingbackend2.domain.posts;

import com.gdschanyang.todayfeelingbackend2.domain.BaseTimeEntity;
import com.gdschanyang.todayfeelingbackend2.domain.hearts.ClinicHeart;
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
public class ClinicPost extends BaseTimeEntity {
    // Ŭ���� ��
    // ����, ��, ����

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLINIC_POST_ID")
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    // �� �ۼ��� �ʼ�
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // Ŭ���б� : ���� = n:1
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    // Ŭ���б� : ������ Ŭ���б� = 1 : n
    @OneToMany(mappedBy = "clinicPost")
    private List<ClinicHeart> clinicHearts = new ArrayList<ClinicHeart>();


    @Builder
    public ClinicPost(String title, String content,
                      User user, List<ClinicHeart> clinicHearts) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.clinicHearts = clinicHearts;
    }


}