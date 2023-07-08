package com.example.netflixzuuluser.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Table(name="msa_booker_folder")
@Entity
public class BookerWithFolder implements Serializable {
    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mbf_index")
    private Integer index;

    @Column(name="mbf_folder_index", columnDefinition = "int default 0", nullable = false)
    private Integer folder;

    @Column(name="mbf_booker_index",columnDefinition = "int default 0", nullable = false)
    private Integer booker;

    @Column(name = "mbf_register_datetime", columnDefinition = "datetime default '0000-00-00 00:00:00'")
    @CreatedDate
    private LocalDateTime registerDatetime;
}
