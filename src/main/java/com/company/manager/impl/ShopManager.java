package com.company.manager.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.company.manager.IShopManager;
import com.company.model.ShoeInfo;
import com.company.model.types.Assignment;

public class ShopManager implements IShopManager {
  private Map<String, List<ShoeInfo>> shoesMap = new HashMap<>();

  private Comparator<ShoeInfo> priceComparator = (sh1, sh2) -> {

    if (sh1.getPriceInUah() > sh2.getPriceInUah()) {
      return 1;
    } else if (sh1.getPriceInUah() < sh2.getPriceInUah()) {
      return -1;
    }
    return 0;
  };
  private Comparator<ShoeInfo> sizeComparator = (sh1, sh2) -> {
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
      var existingShoes = shoesMap.get(name);
      if (existingShoes == null) {
        existingShoes = new LinkedList<ShoeInfo>();
        shoesMap.put(name, existingShoes);
      }
      existingShoes.add(shoe);
    });
  }

  @Override
  public void printAsorty() {
    shoesMap.forEach((brand, listo) -> {
      System.out.println("brand=" + brand);
      listo.forEach(shoe -> System.out.println(shoe.toString()));
    });
  };

  @Override
  public List<ShoeInfo> sortByPrice(int direction) {
    List<ShoeInfo> tempo = new LinkedList<>();

    shoesMap.values().forEach(shoes -> {
      shoes.forEach(shoe -> {
        tempo.add(shoe);
      });
    });
    Collections.sort(tempo, priceComparator);
    if (direction == -1) {
      Collections.reverse(tempo);
      return tempo;
    } else
      return tempo;
  }

  @Override
  public List<ShoeInfo> sortBySize(int direction) {
    List<ShoeInfo> tempo = new LinkedList<>();

    shoesMap.values().forEach(shoes -> {
      shoes.forEach(shoe -> {
        tempo.add(shoe);
      });
    });
    Collections.sort(tempo, sizeComparator);
    if (direction == -1) {
      Collections.reverse(tempo);
      return tempo;
    } else
      return tempo;
  }



  @Override
  public List<ShoeInfo> searchBySize(final int size) {
    List<ShoeInfo> finded = new LinkedList<>();
    for (List<ShoeInfo> listo : shoesMap.values()) {
      finded.addAll(
          listo.stream().filter(shoe -> shoe.getSize().equals(size)).collect(Collectors.toList()));

    }
    return finded;
  }

  @Override
  public List<ShoeInfo> searchByAssignment(Assignment assignment) {
    List<ShoeInfo> finded = new LinkedList<>();
    for (List<ShoeInfo> listo : shoesMap.values()) {
      finded.addAll(listo.stream().filter(shoe -> shoe.getAssignment().equals(assignment))
          .collect(Collectors.toList()));

    }
    return finded;
  }



}
