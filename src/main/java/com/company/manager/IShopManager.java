package com.company.manager;

import java.util.List;
import com.company.model.ShoeInfo;
import com.company.model.types.Assignment;

public interface IShopManager {
  List<ShoeInfo> sortByPrice(final int direction);

  List<ShoeInfo> sortBySize(final int direction);

  List<ShoeInfo> searchBySize(final int size);

  List<ShoeInfo> searchByAssignment(final Assignment assignment);

  void addShoes(List<ShoeInfo> shoes);

  void printAsorty();
}
