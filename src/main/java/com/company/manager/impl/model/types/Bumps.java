package com.company.model.types;

import com.company.model.Sex;
import com.company.model.ShoeInfo;

public class Bumps extends ShoeInfo {


  private Boolean isLacquered;
  private String typeOfToeCap;
  private String typeOfHeels;
  private Assignment assignment;

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
  public String toString() {
    return "Bumps [isLacquered=" + isLacquered + ", typeOfToeCap=" + typeOfToeCap + ", typeOfHeels="
        + typeOfHeels + ", assignment=" + assignment + "," + super.toString() + "]";
  }

  public Assignment getAssignment() {
    return assignment;
  }

  public void setAssignment(Assignment assignment) {
    this.assignment = assignment;
  }



}
