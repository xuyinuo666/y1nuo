package com.product.entity;

import java.math.BigDecimal;
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
 * 商品操作记录表，用于记录商品操作记录
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("pms_goods_operate_log")
public class PmsGoodsOperateLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long spuId;

    /**
     * 改变前价格
     */
    private BigDecimal priceOld;

    /**
     * 改变后价格
     */
    private BigDecimal priceNew;

    /**
     * 操作人
     */
    private String operateMan;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 是否有效
     */
    private Boolean validInd;

    /**
     * 创建人
     */
    private String creatorCode;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新人
     */
    private String updaterCode;


}
