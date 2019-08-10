package com.example.db.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDetails {
  @XmlAttribute
  private Long prodcut_id;

  @XmlAttribute
  private Long prodcut_details_id;

  private String product_brand;

  private String product_category;

  public ProductDetails() {
    super();

  }

  public Long getProdcut_id() {
    return prodcut_id;
  }

  public void setProdcut_id(Long prodcut_id) {
    this.prodcut_id = prodcut_id;
  }

  public Long getProdcut_details_id() {
    return prodcut_details_id;
  }

  public void setProdcut_details_id(Long prodcut_details_id) {
    this.prodcut_details_id = prodcut_details_id;
  }

  public String getProduct_brand() {
    return product_brand;
  }

  public void setProduct_brand(String product_brand) {
    this.product_brand = product_brand;
  }

  public String getProduct_category() {
    return product_category;
  }

  public void setProduct_category(String product_category) {
    this.product_category = product_category;
  }

}
