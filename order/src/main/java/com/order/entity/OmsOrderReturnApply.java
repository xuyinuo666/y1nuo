package com.order.entity;

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
 * 订单退货申请表。主要用于存储会员退货申请信息，需要注意的是订单退货申请表的四种状态：0->待处理；1->退货中；2->已完成；3->已拒绝。
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oms_order_return_apply")
public class OmsOrderReturnApply implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 收货地址表id
     */
    private Long companyAddressId;

    /**
     * 退货商品id
     */
    private Long productId;

    /**
     * 订单编号
     */
    private String orderSn;

    /**
     * 申请时间
     */
    private LocalDateTime applyTime;

    /**
     * 会员用户名
     */
    private String memberUsername;

    /**
     * 退款金额
     */
    private BigDecimal returnAmount;

    /**
     * 退货人姓名
     */
    private String returnName;

    /**
     * 退货人电话
     */
    private String returnPhone;

    /**
     * 申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝
     */
    private Integer status;

    /**
     * 处理时间
     */
    private LocalDateTime handleTime;

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
     * 商品销售属性：颜色：红色；尺码：xl;
     */
    private String productAttr;

    /**
     * 退货数量
     */
    private Integer productCount;

    /**
     * 商品单价
     */
    private BigDecimal productPrice;

    /**
     * 商品实际支付单价
     */
    private BigDecimal productRealPrice;

    /**
     * 原因
     */
    private String reason;

    /**
     * 描述
     */
    private String description;

    /**
     * 凭证图片，以逗号隔开
     */
    private String proofPics;

    /**
     * 处理备注
     */
    private String handleNote;

    /**
     * 处理人员
     */
    private String handleMan;

    /**
     * 收货人
     */
    private String receiveMan;

    /**
     * 收货时间
     */
    private LocalDateTime receiveTime;

    /**
     * 收货备注
     */
    private String receiveNote;

    private LocalDateTime createTime;

    private String creatorCode;

    private LocalDateTime updateTime;

    private String updaterCode;

    private Boolean validInd;


}
