package com.company.manager.impl.model.types;

import com.company.manager.impl.model.Sex;
import com.company.manager.impl.model.ShoeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@EqualsAndHashCode
public class WinterShoes extends ShoeInfo {
  private final Boolean isWaterResistant;
  private final Boolean isFur;
  private final Assignment assignment;

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
  public String getHeaders() {
    return super.getHeaders()+"isWaterResistant"+"isFur"+"assignment";
  }

  @Override
  public String toCSV() {
    return super.toCSV()+", " + getIsWaterResistant() +", " + getIsFur() +", " + getAssignment()   ;
  }
}
