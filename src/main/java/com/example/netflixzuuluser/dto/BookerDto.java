package com.example.netflixzuuluser.dto;

import lombok.Data;


@Data
public class BookerDto {
    public Integer index;
    public String name;
    public String memo;
    public String latitude;
    public String longitude;
    public String register_datetime;
}
