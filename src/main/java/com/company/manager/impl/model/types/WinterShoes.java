package com.company.model.types;

import com.company.model.Sex;
import com.company.model.ShoeInfo;

public class WinterShoes extends ShoeInfo {
  private Boolean isWaterResistant;
  private Boolean isFur;
  private Assignment assignment;

  public WinterShoes(String model, String brand, Sex sex, String material, String color, int size,
      int priceInUah, boolean haveHeels, boolean isAvailable, boolean correctiveInsole,
      boolean isWaterResistant, boolean isFur) {
    super(model, brand, sex, material, color, size, priceInUah, haveHeels, isAvailable,
        correctiveInsole);
    this.isWaterResistant = isWaterResistant;
    this.isFur = isFur;
    this.assignment = Assignment.WinterShoes;
  }

  @Override
  public String toString() {
    return "WinterShoes [isWaterResistant=" + isWaterResistant + ", isFur=" + isFur
        + ", assignment=" + assignment + "," + super.toString() + "]";
  }

  public Assignment getAssignment() {
    return assignment;
  }

  public void setAssignment(Assignment assignment) {
    this.assignment = assignment;
  }



}
