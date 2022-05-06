package com.company.manager.impl.Writer;

import com.company.manager.impl.ShopManager;
import com.company.manager.impl.model.Sex;

import com.company.manager.impl.model.types.Bumps;
import com.company.manager.impl.model.types.Purpose;
import com.company.manager.impl.model.types.Sneakers;
import com.company.manager.impl.model.types.WinterShoes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;

class WriterTest {

    @BeforeEach
    void setUp() throws IOException {
        final ShopManager managerTest = new ShopManager();

        final WinterShoes shoes1 = new WinterShoes("nzx1", "CAT", Sex.male, "leather", "brown", 42, 3500,
                false, true, true, true, true);
        final Sneakers trainers = new Sneakers("AirForce", "Nike", Sex.unisex, "leather", "white", 43, 3400,
                false, true, false, Purpose.forSoccer, false);
        final Bumps bumps1 = new Bumps("Shaleniese", "GUCCI", Sex.female, "leather", "black", 40, 2900, true,
                false, false, true, "triangle", "bottier");
        final Sneakers trainers2 = new Sneakers("Superstar", "Adidas", Sex.unisex, "leather", "green", 45, 3100,
                false, true, false, Purpose.casual, false);
        var asorty=(Arrays.asList(bumps1,trainers,shoes1,trainers2));
        managerTest.addShoes(asorty);
        Writer.writeCSV(managerTest.getShoesMap());
    }

    @Test
    void writeCSV() throws IOException {
        try(FileReader expectedReader = new FileReader(new File("src//test//resources//", "expected.csv"));
            FileReader actualReader = new FileReader(new File("src//main//resources//", "results.csv"));
            BufferedReader expectedBufferReader = new BufferedReader(expectedReader);
            BufferedReader actualBufferReader = new BufferedReader(actualReader) ){
            String line;
            while ((line = expectedBufferReader.readLine()) != null) {
                Assertions.assertEquals(line, actualBufferReader.readLine());
            }
        }
    }
    }
