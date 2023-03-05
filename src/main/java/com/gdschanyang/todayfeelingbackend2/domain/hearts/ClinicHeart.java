package com.gdschanyang.todayfeelingbackend2.domain.hearts;

import com.gdschanyang.todayfeelingbackend2.domain.posts.ClinicPost;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ClinicHeart{
    // Ŭ���� ����
    // ���� ����, ������ Ŭ���� �� -> �ϴ�� �ܹ��� ����

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // �������� Ŭ���� �� : ���� = n:1
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    // �������� Ŭ���� �� : Ŭ���� �� = n:1
    @ManyToOne
    @JoinColumn(name = "CLINIC_POST_ID")
    private ClinicPost clinicPost;

    @Builder
    public ClinicHeart(User user, ClinicPost clinicPost) {
        Assert.notNull(user, "user must not be null");
        Assert.notNull(clinicPost, "clinicPost must not be null");
        this.user = user;
        this.clinicPost = clinicPost;
    }


}