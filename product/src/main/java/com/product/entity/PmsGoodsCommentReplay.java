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
 * 产品评价回复表
 * </p>
 *
 * @author y1nuo
 * @since 2023-01-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("pms_goods_comment_replay")
public class PmsGoodsCommentReplay implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 评论id
     */
    private Long commentId;

    /**
     * 会员昵称
     */
    private String memberNickName;

    /**
     * 会员头像
     */
    private String memberIcon;

    /**
     * 内容
     */
    private String content;

    /**
     * 评论人员类型；0->会员；1->管理员
     */
    private Integer type;

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
