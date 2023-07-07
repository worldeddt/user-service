package com.example.netflixzuuluser.vo;

import lombok.Data;
import org.w3c.dom.Text;

import java.util.Date;

@Data
public class ResponseBooker {
    private String bookerId;
    private String latitude;
    private String longitude;
    private String title;
    private Text memo;
    private Date createdAt;
}