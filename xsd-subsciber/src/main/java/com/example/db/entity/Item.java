package com.example.db.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "item")
@DefaultCoder(AvroCoder.class)
public class Item {
  @XmlAttribute
  private Long prodcut_id;

  private String product_name;

  private String product_item_number;

  private String product_description;

  private String product_quantity;

  private ProductDetails product_details;

  public Item() {
    super();
  }

  public Item(Long prodcut_id, String product_name, String product_item_number,
      String product_description, String product_quantity,
      com.example.db.entity.ProductDetails product_details) {
    super();
    this.prodcut_id = prodcut_id;
    this.product_name = product_name;
    this.product_item_number = product_item_number;
    this.product_description = product_description;
    this.product_quantity = product_quantity;
    this.product_details = product_details;
  }

  public Long getProdcut_id() {
    return prodcut_id;
  }

  public void setProdcut_id(Long prodcut_id) {
    this.prodcut_id = prodcut_id;
  }

  public String getProduct_name() {
    return product_name;
  }

  public void setProduct_name(String product_name) {
    this.product_name = product_name;
  }

  public String getProduct_item_number() {
    return product_item_number;
  }

  public void setProduct_item_number(String product_item_number) {
    this.product_item_number = product_item_number;
  }

  public String getProduct_description() {
    return product_description;
  }

  public void setProduct_description(String product_description) {
    this.product_description = product_description;
  }

  public String getProduct_quantity() {
    return product_quantity;
  }

  public void setProduct_quantity(String product_quantity) {
    this.product_quantity = product_quantity;
  }

  public ProductDetails getProduct_details() {
    return product_details;
  }

  public void setProduct_details(ProductDetails product_details) {
    this.product_details = product_details;
  }

}
