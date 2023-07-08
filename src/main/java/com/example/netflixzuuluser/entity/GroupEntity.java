package com.example.netflixzuuluser.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Table(name = "msa_users_group")
@Entity
public class GroupEntity implements Serializable {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mug_index", nullable = false)
    private Integer index;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="mug_mu_index", nullable = false)
    private UserEntity user;

    @CreatedDate
    @Column(name = "mug_register_datetime", columnDefinition = "datetime default '0000-00-00 00:00:00'")
    private LocalDateTime registerDateTime;
}
