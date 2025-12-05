package com.suyan.backend.modules.system.domain.dto;

import com.suyan.base.domain.QueryDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "用户角色关联表查询入参")
public class SysUserRoleQueryDto extends QueryDto {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键id")
    private Long id;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "角色id")
    private Long roleId;

    @Schema(description = "创建时间起")
    private LocalDateTime createTimeFrom;

    @Schema(description = "创建时间止")
    private LocalDateTime createTimeTo;

    @Schema(description = "创建人id")
    private Long createUserId;

    @Schema(description = "更新时间起")
    private LocalDateTime updateTimeFrom;

    @Schema(description = "更新时间止")
    private LocalDateTime updateTimeTo;

    @Schema(description = "更新人id")
    private Long updateUserId;



}
