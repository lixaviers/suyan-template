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
@Schema(description = "角色表详细出参")
public class SysRoleDetailVo implements Serializable {

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

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "创建人id")
    private Long createUserId;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

    @Schema(description = "更新人id")
    private Long updateUserId;


}
