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
 * spu表（Standard Product Unit, 标准产品单元）
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("pms_goods_spu")
public class PmsGoodsSpu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品编号，唯一
     */
    private String spuNo;

    /**
     * 品牌属性分类id
     */
    private Long productAttributeCategoryId;

    /**
     * 品牌分类id
     */
    private Long categoryId;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 副标题
     */
    private String subTitle;

    /**
     * 详情标题
     */
    private String detailTitle;

    /**
     * 图片
     */
    private String pic;

    /**
     * 上架状态：0->下架；1->上架
     */
    private Integer publishStatus;

    /**
     * 新品状态:0->不是新品；1->新品
     */
    private Integer newStatus;

    /**
     * 推荐状态；0->不推荐；1->推荐
     */
    private Integer recommandStatus;

    /**
     * 是否为预告商品：0->不是；1->是
     */
    private Integer previewStatus;

    /**
     * 以逗号分割的产品服务：1->无忧退货；2->快速退款；3->免费包邮
     */
    private String serviceIds;

    /**
     * 审核状态：0->未审核；1->审核通过
     */
    private Integer verifyStatus;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 最低售价
     */
    private Integer lowPrice;

    /**
     * 销量
     */
    private Integer sale;

    /**
     * 总库存量
     */
    private Long stock;

    /**
     * 库存预警值
     */
    private Integer lowStock;

    /**
     * 画册图片，连产品图片限制为5张，以逗号分割
     */
    private String albumPics;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 详情描述
     */
    private String detailDesc;

    /**
     * 产品详情网页内容
     */
    private String detailHtml;

    /**
     * 移动端网页详情
     */
    private String detailMobileHtml;

    /**
     * 运费模版id
     */
    private Long feightTemplateId;

    /**
     * 商品排序
     */
    private Long spuSort;

    /**
     * 备注
     */
    private String note;

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
