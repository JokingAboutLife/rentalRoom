package com.gxust.edu.rental_room.query;

import lombok.Data;

@Data
public class BaseQuery {
    //当前页数
    private Integer currentPage = 1;
    //每页显示条数
    private Integer pageSize = 10;
    //排序方式
//    private Integer total;
    //是否分页
    private boolean paging = true;

}
