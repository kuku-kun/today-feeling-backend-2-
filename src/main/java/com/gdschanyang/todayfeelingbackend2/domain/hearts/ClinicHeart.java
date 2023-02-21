package com.gdschanyang.todayfeelingbackend2.domain.hearts;

import com.gdschanyang.todayfeelingbackend2.domain.posts.ClinicPost;
import com.gdschanyang.todayfeelingbackend2.domain.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public void setUser(User user){
        this.user = user;
        if(!user.getClinicHearts().contains(this)){
            user.getClinicHearts().add(this);
        }
    }

    public void setClinicPost(ClinicPost clinicPost){
        this.clinicPost = clinicPost;
        if(!clinicPost.getClinicHearts().contains(this)){
            clinicPost.getClinicHearts().add(this);
        }
    }


}