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

public class RolePo implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private LocalDateTime createTime;

    private String creatorCode;

    private LocalDateTime updateTime;

    private String updaterCode;

    private Boolean validInd;

    private String description;

    private String roleCode;

    private String roleName;


}
