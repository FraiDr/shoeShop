package com.company.manager.impl.model.types;

import com.company.manager.impl.model.Sex;
import com.company.manager.impl.model.ShoeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;



@Getter
@EqualsAndHashCode
public class Sneakers extends ShoeInfo {

  private final Purpose purpose;
  private final boolean isNetting;
  private final Assignment assignment;

  @Override
  public String getHeaders() {
    return super.getHeaders() +",purpose"+"isNetting"+",assignment";
  }

  @Override
  public String toCSV() {
    return super.toCSV()+","+getPurpose()+","+getIsNetting()+","+getAssignment();
  }

  private boolean getIsNetting() {
    return  isNetting;
  }

  public Sneakers(String model, String brand, Sex sex, String material, String color, int size,
                  int priceInUah, boolean haveHeels, boolean isAvailable, boolean correctiveInsole,
                  Purpose purpose, boolean isNetting) {
    super(model, brand, sex, material, color, size, priceInUah, haveHeels, isAvailable,
            correctiveInsole);
    this.purpose = purpose;
    this.isNetting = isNetting;
    this.assignment = Assignment.Sneakers;

  }
}