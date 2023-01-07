package com.user.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PermissionPo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String permissionName;

    private String permissionCode;

    private String url;

    private String systemModule;

    private String description;

    private Boolean validInd;

    private LocalDateTime createTime;

    private String creatorCode;

    private LocalDateTime updateTime;

    private String updaterCode;

    private Boolean display;

    private String icon;

    private Long pid;


}
