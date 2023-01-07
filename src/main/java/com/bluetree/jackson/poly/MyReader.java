package com.bluetree.jackson.poly;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class MyReader {

    public static void main(String[] args) {

        try {

            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            SimpleModule module = new SimpleModule();
            module.addDeserializer(MyDataItem.class, new MyDataItemDeserialiser());
            objectMapper.registerModule(module);
            Path rp = Paths.get("src", "test", "resources");
            String absPath = rp.toFile().getAbsolutePath();

            MyObject o = objectMapper.readValue(new File(absPath + File.separator + "aa.json"), MyObject.class);

            System.out.println(o);


        } catch (Exception e) {
            System.out.println("e:" + e);
        }
    }
}

