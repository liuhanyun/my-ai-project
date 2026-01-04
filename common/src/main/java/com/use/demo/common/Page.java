package com.use.demo.common;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Page<T> {
    /*
     * 总记录数
     */
    private long total;
    /*
     * 当前页号
     */
    private int page;
    /*
     * 每页大小
     */
    private int size;
    /*
     * 当前页数据
     */
    private List<T> records;
}
