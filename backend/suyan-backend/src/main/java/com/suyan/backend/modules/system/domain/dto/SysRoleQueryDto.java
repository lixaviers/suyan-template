package com.suyan.backend.modules.system.domain.dto;

import com.suyan.base.domain.QueryDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "角色表查询入参")
public class SysRoleQueryDto extends QueryDto {

    private static final long serialVersionUID = 1L;

    @Schema(description = "角色id")
    private Long id;

    @Schema(description = "角色编码")
    private String roleCode;

    @Schema(description = "角色名称")
    private String roleName;

    @Schema(description = "角色描述")
    private String remarks;

    @Schema(description = "是否启用")
    private Byte isEnabled;

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
