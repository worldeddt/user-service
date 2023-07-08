package com.example.netflixzuuluser.entity;


import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;

@Data
@Entity
@Table(name = "msa_users")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mu_index")
    private Integer index;

    @OneToMany(mappedBy = "user")
    private List<GroupEntity> groupEntityList;

    @Column(name = "mu_email", nullable = false, length = 50, unique = true)
    private String email;
    @Column(name = "mu_name", length = 50)
    private String name;
    @Column(name = "mu_id", nullable = false, unique = true)
    private String userId;
    @Column(name = "mu_en_password", nullable = false, unique = true)
    private String encryptedPwd;

    @Column(name = "mu_register_datetime", columnDefinition = "datetime default '0000-00-00 00:00:00'")
    @CreatedDate
    private LocalDateTime registerDatetime;
}
