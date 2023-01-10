package com.product.entity;

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
 * 商品评价表
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("pms_goods_comment")
public class PmsGoodsComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long spuId;

    /**
     * 会员昵称
     */
    private String memberNickName;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 评价星数：0->5
     */
    private Integer star;

    /**
     * 评价的ip
     */
    private String memberIp;

    /**
     * 是否显示
     */
    private Integer showStatus;

    /**
     * 商品skuid
     */
    private Long skuId;

    /**
     * 收藏数
     */
    private Integer collectCouont;

    /**
     * 阅读数
     */
    private Integer readCount;

    /**
     * 内容
     */
    private String content;

    /**
     * 上传图片地址，以逗号隔开
     */
    private String pics;

    /**
     * 评论用户头像
     */
    private String memberIcon;

    /**
     * 回复数
     */
    private Integer replayCount;

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
