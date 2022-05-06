package com.company.manager.impl;

import lombok.Getter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.company.manager.IShopManager;
import com.company.manager.impl.model.ShoeInfo;
import com.company.manager.impl.model.types.Assignment;
@Getter
public class ShopManager implements IShopManager {
  private final Map<String, List<ShoeInfo>> shoesMap = new HashMap<>();

  private final Comparator<ShoeInfo> priceComparator = (sh1, sh2) -> {

    if (sh1.getPriceInUah() > sh2.getPriceInUah()) {
      return 1;
    } else if (sh1.getPriceInUah() < sh2.getPriceInUah()) {
      return -1;
    }
    return 0;
  };
  private final Comparator<ShoeInfo> sizeComparator = (sh1, sh2) -> {
    if (sh1.getSize() > sh2.getSize()) {
      return 1;
    } else if (sh1.getSize() < sh2.getSize()) {
      return -1;
    }
    return 0;
  };



  @Override
  public void addShoes(List<ShoeInfo> shoes) {
    shoes.forEach(shoe -> {
      String name = shoe.getBrand();
      var existingShoes = shoesMap.computeIfAbsent(name, k -> new LinkedList<>());
      existingShoes.add(shoe);
    });
  }
  @Override
  public List<ShoeInfo> sortByPrice(int direction) {
    List<ShoeInfo> tempo = new LinkedList<>();
    shoesMap.values().forEach(tempo::addAll);
    tempo.sort(priceComparator);
    if (direction == -1) {
      Collections.reverse(tempo);
    }
    return tempo;
  }
  @Override
  public List<ShoeInfo> sortBySize(int direction) {
    List<ShoeInfo> tempo = new LinkedList<>();

    shoesMap.values().forEach(tempo::addAll);
    tempo.sort(sizeComparator);
    if (direction == -1) {
      Collections.reverse(tempo);
    }
    return tempo;
  }
  @Override
  public List<ShoeInfo> searchBySize(final int size) {
    List<ShoeInfo> finded = new LinkedList<>();
    for (List<ShoeInfo> listo : shoesMap.values()) {
      finded.addAll(
              listo.stream().filter(shoe -> shoe.getSize().equals(size)).toList());

    }
    return finded;
  }
  @Override
  public List<ShoeInfo> searchByAssignment(Assignment assignment) {
    List<ShoeInfo> finded = new LinkedList<>();
    for (List<ShoeInfo> listo : shoesMap.values()) {
      finded.addAll(listo.stream().filter(shoe -> shoe.getAssignment().equals(assignment)).toList());

    }
    return finded;
  }
}
