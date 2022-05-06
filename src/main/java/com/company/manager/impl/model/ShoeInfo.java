package com.company.model;

import com.company.model.types.Assignment;

public abstract class ShoeInfo {
  private String model;


  private String brand;
  private Sex sex;
  private String material;
  private String color;
  private Integer size;
  private int priceInUah;
  private Boolean haveHeels;
  private Boolean isAvailable;
  private Boolean correctiveInsole;
  private Assignment assignment;

  public ShoeInfo(String model, String brand, Sex sex, String material, String color, Integer size,
      Integer priceInUah, Boolean haveHeels, Boolean isAvailable, Boolean correctiveInsole) {
    this.model = model;
    this.brand = brand;
    this.sex = sex;
    this.material = material;
    this.color = color;
    this.size = size;
    this.priceInUah = priceInUah;
    this.haveHeels = haveHeels;
    this.isAvailable = isAvailable;
    this.correctiveInsole = correctiveInsole;
    this.assignment = null;
  }

  public Assignment getAssignment() {
    return assignment;
  }

  public void setAssignment(Assignment assignment) {
    this.assignment = assignment;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Integer getPriceInUah() {
    return priceInUah;
  }

  public void setPriceInUah(Integer priceInUah) {
    this.priceInUah = priceInUah;
  }

  public Boolean getHaveHeels() {
    return haveHeels;
  }

  public void setHaveHeels(Boolean haveHeels) {
    this.haveHeels = haveHeels;
  }

  public Boolean getIsAvailable() {
    return isAvailable;
  }

  public void setIsAvailable(Boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public Boolean getCorrectiveInsole() {
    return correctiveInsole;
  }

  public void setCorrectiveInsole(Boolean correctiveInsole) {
    this.correctiveInsole = correctiveInsole;
  }

  @Override
  public String toString() {
    return "model=" + model + ", brand=" + brand + ", sex=" + sex + ", material=" + material
        + ", color=" + color + ", size=" + size + ", priceInUah=" + priceInUah + ", haveHeels="
        + haveHeels + ", isAvailable=" + isAvailable + ", correctiveInsole=" + correctiveInsole;
  }



}
