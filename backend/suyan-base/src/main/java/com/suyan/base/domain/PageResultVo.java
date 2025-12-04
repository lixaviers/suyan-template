package com.suyan.base.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Schema(description = "分页输出结果基类")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class PageResultVo<E> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Schema(description = "第几页")
    private long pageNo;

    @Schema(description = "是否有下一页")
    private boolean hasNextPage = true;

    @Schema(description = "每页多少数据")
    private long pageSize;

    @Schema(description = "总页数")
    private long pages;

    @Schema(description = "总记录数")
    private long total;

    /**
     * @Fields records : 返回记录列表
     */
    @Schema(description = "返回记录列表")
    private List<E> records;


    public boolean getHasNextPage() {
        if (this.total > (this.pageNo * this.pageSize)) {
            this.setHasNextPage(true);
            return true;
        } else {
            this.setHasNextPage(false);
            return false;
        }
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public PageResultVo(long pageNo, long pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pages = 0;
        this.total = 0;
        this.hasNextPage = false;
    }
}
