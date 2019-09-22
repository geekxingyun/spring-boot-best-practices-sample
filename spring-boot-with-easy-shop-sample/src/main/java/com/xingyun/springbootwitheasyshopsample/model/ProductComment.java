package com.xingyun.springbootwitheasyshopsample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author 星云
 * @功能 商品评论表
 * @date 9/22/2019 9:42 AM
 */
@Table(name = "T_PRODUCT_COMMENT")
@Entity
@Getter
@Setter
@ToString
public class ProductComment implements Serializable {
    private static final long serialVersionUID = -2663067961238356484L;
    /**
     * 商品评论数据库主键
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 所示商品的ID
     */
    private Long productId;
    /**
     * 评论作者的ID
     */
    private Long authorId;
    /**
     * 评论的具体内容
     */
    private String content;
    /**
     * 评论创建时间
     */
    private Date created;
}
