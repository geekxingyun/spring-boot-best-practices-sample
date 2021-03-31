package com.xingyun.springbootwitheasyshopsample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 技术宅星云
 * @功能 商品表
 * @date 9/22/2019 9:36 AM
 */
@Table(name = "T_PRODUCT")
@Entity
@Getter
@Setter
@ToString
public class Product implements Serializable {
    private static final long serialVersionUID = 6003315201652318080L;
    /**
     * 用户数据库主键
     * id 会映射为ID
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品封面图片
     */
    private String coverImage;
    /**
     * 商品价格
     */
    private int productPrice;
}
