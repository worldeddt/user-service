package com.example.netflixzuuluser.vo;

import lombok.Data;
import java.util.List;


@Data
public class ResponseUser {
    public Integer userIndex;
    public List<ResponseBooker> bookerList;
}
