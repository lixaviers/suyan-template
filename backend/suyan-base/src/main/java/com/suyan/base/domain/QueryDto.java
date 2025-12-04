package com.suyan.base.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Schema(description = "分页输入参数基类")
@Data
public class QueryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "第几页")
    private int pageNo = 1;

    @Schema(description = "每页多少数据")
    private int pageSize = 10;

}
