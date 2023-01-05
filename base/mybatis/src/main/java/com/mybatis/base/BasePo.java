package com.mybatis.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class BasePo extends BasePage{
    // 主键id
    @TableId(type = IdType.AUTO)
    private Long id;
    // 创建人
    @TableField("creatorCode")
    private String creatorCode;
    // 更新人
    @TableField("updaterCode")
    private String updaterCode;
    // 创建时间
    @TableField("createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date createTime;
    // 更新时间
    @TableField("updateTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    private Date updateTime;
    // 有效标志
    @TableField("validInd")
    private Boolean validInd;
}
