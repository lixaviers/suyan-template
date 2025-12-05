package com.suyan.backend.modules.system.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Schema(description = "用户角色关联表详细出参")
public class SysUserRoleDetailVo implements Serializable {

    private static final long serialVersionUID = 1L;


    @Schema(description = "主键id")
    private Long id;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "角色id")
    private Long roleId;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "创建人id")
    private Long createUserId;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "更新人id")
    private Long updateUserId;


}
