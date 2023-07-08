package com.example.netflixzuuluser.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Table(name="msa_folder")
@Entity
public class FolderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mf_index", nullable = false)
    private Integer index;

    @Column(name = "mf_name", columnDefinition = "varchar(200) default ''", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mf_mug_index")
    private GroupEntity group;

    @CreatedDate
    @Column(name =  "mf_register_datetime", columnDefinition = "datetime default '0000-00-00 00:00:00'")
    private LocalDateTime registerDateTime;
}
