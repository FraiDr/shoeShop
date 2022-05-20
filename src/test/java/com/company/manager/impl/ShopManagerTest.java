package com.company.manager.impl;

import com.company.manager.impl.model.Sex;
import com.company.manager.impl.model.ShoeInfo;
import com.company.manager.impl.model.types.Bumps;
import com.company.manager.impl.model.types.Purpose;
import com.company.manager.impl.model.types.Sneakers;
import com.company.manager.impl.model.types.WinterShoes;
import com.company.manager.impl.model.types.Assignment;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopManagerTest {
    private final static ShopManager managerTest = new ShopManager();
    List<ShoeInfo> asorty = new LinkedList<>();
    private final static WinterShoes shoes1 = new WinterShoes("nzx1", "CAT", Sex.male, "leather", "brown", 42, 3500,
            false, true, true, true, true);
    private final static Sneakers trainers = new Sneakers("AirForce", "Nike", Sex.unisex, "leather", "white", 43, 3400,
            false, true, false, Purpose.forSoccer, false);
    private final static Bumps bumps1 = new Bumps("Shaleniese", "GUCCI", Sex.female, "leather", "black", 40, 2900, true,
            false, false, true, "triangle", "bottier");

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        asorty.add(shoes1);
        asorty.add(trainers);
        asorty.add(bumps1);
        managerTest.addShoes(asorty);

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        managerTest.getShoesMap().clear();
    }

    @Test
    void addShoes() {
        Map<String, List<ShoeInfo>> actualMap =managerTest.getShoesMap();

        assertFalse(managerTest.getShoesMap().isEmpty());
        assertEquals(3,actualMap.size());
        assertEquals(managerTest.getShoesMap(),actualMap);
    }

    @Test
    void sortByPrice() {
        var expectedMapAsc=(Arrays.asList(bumps1,trainers,shoes1));
        var actualMapAsc=managerTest.sortByPrice(1);
        assertEquals(expectedMapAsc.indexOf(bumps1), 0);
        assertEquals(expectedMapAsc.indexOf(trainers), 1);
        assertEquals(expectedMapAsc.indexOf(shoes1), 2);
        assertEquals(actualMapAsc.get(0),expectedMapAsc.get(0));
        assertEquals(actualMapAsc.get(1),expectedMapAsc.get(1));
        assertEquals(actualMapAsc.get(2),expectedMapAsc.get(2));
        var expectedMapDesc=(Arrays.asList(shoes1,trainers,bumps1));
        var actualMapDesc=managerTest.sortByPrice(-1);
        assertEquals(expectedMapDesc.indexOf(shoes1), 0);
        assertEquals(expectedMapDesc.indexOf(trainers), 1);
        assertEquals(expectedMapDesc.indexOf(bumps1), 2);
        assertEquals(actualMapDesc.get(0),expectedMapDesc.get(0));
        assertEquals(actualMapDesc.get(1),expectedMapDesc.get(1));
        assertEquals(actualMapDesc.get(2),expectedMapDesc.get(2));

    }

    @Test
    void sortBySize() {
        var expectedMapAsc=(Arrays.asList(bumps1,shoes1,trainers));
        var actualMapAsc=managerTest.sortBySize(1);
        assertEquals(expectedMapAsc.indexOf(bumps1), 0);
        assertEquals(expectedMapAsc.indexOf(shoes1), 1);
        assertEquals(expectedMapAsc.indexOf(trainers), 2);
        assertEquals(actualMapAsc.get(0),expectedMapAsc.get(0));
        assertEquals(actualMapAsc.get(1),expectedMapAsc.get(1));
        assertEquals(actualMapAsc.get(2),expectedMapAsc.get(2));
        var expectedMapDesc=(Arrays.asList(trainers,shoes1,bumps1));
        var actualMapDesc=managerTest.sortBySize(-1);
        assertEquals(expectedMapDesc.indexOf(trainers), 0);
        assertEquals(expectedMapDesc.indexOf(shoes1), 1);
        assertEquals(expectedMapDesc.indexOf(bumps1), 2);
        assertEquals(expectedMapDesc.get(0),actualMapDesc.get(0));
        assertEquals(expectedMapDesc.get(1),actualMapDesc.get(1));
        assertEquals(expectedMapDesc.get(2),actualMapDesc.get(2));
    }

    @Test
    void searchBySize() {
        assertTrue(managerTest.searchBySize(45).isEmpty());
        var actualMap=managerTest.searchBySize(43);
        assertFalse(managerTest.searchBySize(43).isEmpty());

        assertFalse(actualMap.contains(shoes1));
        assertTrue(actualMap.contains(trainers));
        assertFalse(actualMap.contains(bumps1));
    }

    @Test
    void searchByAssignment() {
        var actualMap=managerTest.searchByAssignment(Assignment.Sneakers);
        assertFalse(managerTest.searchBySize(43).isEmpty());

        assertFalse(actualMap.contains(shoes1));
        assertTrue(actualMap.contains(trainers));
        assertFalse(actualMap.contains(bumps1));
    }
}