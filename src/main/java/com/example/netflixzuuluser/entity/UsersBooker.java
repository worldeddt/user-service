package com.example.netflixzuuluser.entity;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Table(name = "msa_users_booker")
@Entity
public class UsersBooker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mub_index")
    public Integer index;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mub_mu_index")
    public UserEntity user;

    @Column(name="mub_mb_index", columnDefinition = "int default 0", nullable = false)
    public Integer booker;
}
