package com.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * sku规格值
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("pms_goods_sku_spec_value")
public class PmsGoodsSkuSpecValue implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sku_id
     */
    private Long skuId;

    /**
     * spu_id
     */
    private Long spuId;

    /**
     * 规格id(冗余)
     */
    private Long specKeyId;

    /**
     * 规格值id
     */
    private Long specValueId;

    /**
     * 规格值排序
     */
    private Long skuSpecSort;

    /**
     * 是否有效
     */
    private Boolean validInd;

    /**
     * 最后更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 最后更新人
     */
    private String updaterCode;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String creatorCode;


}
