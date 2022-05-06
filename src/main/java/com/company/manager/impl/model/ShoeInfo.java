package com.company.manager.impl.model;

import com.company.manager.impl.model.types.Assignment;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
public abstract class ShoeInfo {
  private final String model;
  private final String brand;
  private final Sex sex;
  private final String material;
  private final String color;
  private final Integer size;
  private final int priceInUah;
  private final Boolean haveHeels;
  private final Boolean isAvailable;
  private final Boolean correctiveInsole;
  private final Assignment assignment=null;

  public String getHeaders() {
    return  "model," + "brand  ," + "sex ," + "material ," + "color,"+"size,"+"priceInUah,"+"haveHeels,"+"isAvailable,"+"correctiveInsole,"+"assignment,";
  }
  public String toCSV() {
    return getModel() + ", " + getBrand() + ", " +  getSex() + ", " + getMaterial()+", " + getColor()+", " + getSize()+", " + getPriceInUah() + ", "+ getHaveHeels()+", "+ getIsAvailable()+", "+ getCorrectiveInsole()+", " + getAssignment();
  }






}
