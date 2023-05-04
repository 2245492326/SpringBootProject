package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cgs
 * @since 2023-04-01
 */
public class Goods implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String goodsname;

    private String goodsprice;

    private Object kucun;

    private String goodsInfo;

    private String goodstype;

    private String addData;

    private String addActor;

    private String goodsImg;

    private Integer purchaseQuantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(String goodsprice) {
        this.goodsprice = goodsprice;
    }

    public Object getKucun() {
        return kucun;
    }

    public void setKucun(Object kucun) {
        this.kucun = kucun;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype;
    }

    public String getAddData() {
        return addData;
    }

    public void setAddData(String addData) {
        this.addData = addData;
    }

    public String getAddActor() {
        return addActor;
    }

    public void setAddActor(String addActor) {
        this.addActor = addActor;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    @Override
    public String toString() {
        return "Goods{" +
            "id = " + id +
            ", goodsname = " + goodsname +
            ", goodsprice = " + goodsprice +
            ", kucun = " + kucun +
            ", goodsInfo = " + goodsInfo +
            ", goodstype = " + goodstype +
            ", addData = " + addData +
            ", addActor = " + addActor +
            ", goodsImg = " + goodsImg +
            ", purchaseQuantity = " + purchaseQuantity +
        "}";
    }
}
