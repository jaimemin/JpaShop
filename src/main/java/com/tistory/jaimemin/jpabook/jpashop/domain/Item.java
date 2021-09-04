package com.tistory.jaimemin.jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 단일 테이블 전략
 * create table Item (
 *        DTYPE varchar(31) not null,
 *         ITEM_ID bigint not null,
 *         name varchar(255),
 *         price integer not null,
 *         stockQuantity integer not null,
 *         author varchar(255),
 *         isbn varchar(255),
 *         actor varchar(255),
 *         director varchar(255),
 *         artist varchar(255),
 *         etc varchar(255),
 *         primary key (ITEM_ID)
 *     )
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
public abstract class Item extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
