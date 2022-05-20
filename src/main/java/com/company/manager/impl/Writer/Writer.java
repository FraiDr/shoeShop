package com.company.manager.impl.Writer;


import com.company.manager.impl.model.ShoeInfo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//"src//main//resources//"+"results.csv"
public class Writer {
    public static void writeCSV(Map<String, List<ShoeInfo>> shoes)

    {
        File file = new File("src//main//resources//"+"results.csv");
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)){
            Map<String, List<ShoeInfo>> shoesSorted = shoes.entrySet().stream()
                    .sorted((o1, o2) ->
                            CharSequence.compare(o1.getKey().getClass().getSimpleName(), o2.getKey().getClass().getSimpleName()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (o1, o2) -> o1, LinkedHashMap::new));
            String previousClassName = "";
            for (Map.Entry<String, List<ShoeInfo>> entrySet : shoesSorted.entrySet()){

                if (!entrySet.getKey().getClass().getSimpleName().equals(previousClassName)) {
                    for(ShoeInfo shoe : entrySet.getValue())
                    {
                        writer.write(shoe.getClass().getSimpleName()+":");
                    }

                    writer.write("\r\n");
                    for(ShoeInfo shoe : entrySet.getValue())
                    {
                        writer.write(shoe.getHeaders());
                    }
                    writer.write("\r\n");
                    for(ShoeInfo shoe : entrySet.getValue())
                    {
                        previousClassName = shoe.getClass().getSimpleName();
                    }

                }
                for(ShoeInfo shoe : entrySet.getValue())
                {
                    writer.write(entrySet.getKey()+","+ shoe.toCSV()  );
                }

                writer.write("\r\n");
            }
        } catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}

