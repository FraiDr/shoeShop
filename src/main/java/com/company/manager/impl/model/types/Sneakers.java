package com.company.model.types;

import com.company.model.Sex;
import com.company.model.ShoeInfo;

public class Sneakers extends ShoeInfo {

  private Purpose purpose;
  private boolean isNetting;
  private Assignment assignment;

  public Sneakers(String model, String brand, Sex sex, String material, String color, int size,
      int priceInUah, boolean haveHeels, boolean isAvailable, boolean correctiveInsole,
      Purpose purpose, boolean isNetting) {
    super(model, brand, sex, material, color, size, priceInUah, haveHeels, isAvailable,
        correctiveInsole);
    this.purpose = purpose;
    this.isNetting = isNetting;
    this.assignment = Assignment.Sneakers;

  }

  @Override
  public String toString() {
    return "Sneakers [purpose=" + purpose + ", isNetting=" + isNetting + ", assignment="
        + assignment + "," + super.toString() + "]";
  }

  public Assignment getAssignment() {
    return assignment;
  }

  public void setAssignment(Assignment assignment) {
    this.assignment = assignment;
  }


}
