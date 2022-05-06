package com.company.manager;

import java.util.List;
import com.company.manager.impl.model.ShoeInfo;
import com.company.manager.impl.model.types.Assignment;

public interface IShopManager {
  List<ShoeInfo> sortByPrice(final int direction);

  List<ShoeInfo> sortBySize(final int direction);

  List<ShoeInfo> searchBySize(final int size);

  List<ShoeInfo> searchByAssignment(final Assignment assignment);

  void addShoes(List<ShoeInfo> shoes);



}
