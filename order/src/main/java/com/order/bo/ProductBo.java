package com.order.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单商品信息表。订单中包含的商品信息，一个订单中会有多个订单商品信息。
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductBo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品图片
     */
    private String productPic;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品品牌
     */
    private String productBrand;

    /**
     * 商品条码
     */
    private String productSn;

    /**
     * 销售价格
     */
    private BigDecimal productPrice;

    /**
     * 购买数量
     */
    private Integer productQuantity;

    /**
     * 商品sku编号
     */
    private Long productSkuId;

    /**
     * 商品sku条码
     */
    private String productSkuCode;

    /**
     * 商品分类id
     */
    private Long productCategoryId;

    /**
     * 商品的销售属性1
     */
    private String sp1;

    /**
     * 商品的销售属性2
     */
    private String sp2;

    /**
     * 商品的销售属性3
     */
    private String sp3;
    /**
     * 商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]
     */
    private String productAttr;

}
