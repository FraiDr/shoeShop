package com.company.manager.impl.model.types;

import com.company.manager.impl.model.Sex;
import com.company.manager.impl.model.ShoeInfo;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@EqualsAndHashCode(callSuper = true)
public class Bumps extends ShoeInfo {


  private final Boolean isLacquered;
  private final String typeOfToeCap;
  private final String typeOfHeels;
  private final Assignment assignment;

  public Bumps(String model, String brand, Sex sex, String material, String color, Integer size,
               Integer priceInUah, Boolean haveHeels, Boolean isAvailable, Boolean correctiveInsole,
               Boolean isLacquered, String typeOfToeCap, String typeOfHeels) {
    super(model, brand, sex, material, color, size, priceInUah, haveHeels, isAvailable,
            correctiveInsole);
    this.isLacquered = isLacquered;
    this.typeOfToeCap = typeOfToeCap;
    this.typeOfHeels = typeOfHeels;
    this.assignment = Assignment.Bumps;
  }

  @Override
  public String getHeaders() {
    return super.getHeaders()+",isLacquered"+",typeOfToeCap"+",typeOfHeels"+",assignment";
  }

  @Override
  public String toCSV() {
    return super.toCSV()+", " + getIsLacquered() +", " + getTypeOfToeCap() + ", " + getTypeOfHeels() +", " + getAssignment()   ;
  }
}
