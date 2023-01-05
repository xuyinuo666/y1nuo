package com.oauth.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("u_user")
public class UUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String usercode;

    private String username;

    private String sex;

    private String password;

    private String address;

    private LocalDateTime birthDate;

    private String phone;

    private String iconUrl;

    private String description;

    private Boolean validInd;

    private LocalDateTime createTime;

    private String creatorCode;

    private LocalDateTime updateTime;

    private String updaterCode;

    private String groupId;


}
