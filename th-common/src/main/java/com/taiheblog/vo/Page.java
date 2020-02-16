package com.taiheblog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class Page<T> {
    private Integer totalsize;
    private Integer pageno;
    private List<T> list;

}
