package com.bluetree.jackson.poly;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

import java.io.IOException;
import java.lang.invoke.MutableCallSite;

public class MyDataItemDeserialiser extends StdDeserializer<MyDataItem> {

    public MyDataItemDeserialiser() {
        this(null);
    }

    public MyDataItemDeserialiser(Class<?> vc) {
        super(vc);
    }

    @Override
    public MyDataItem deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        int id = (Integer) ((IntNode) node.get("datavalue")).numberValue();
        MyDataItem mdi = new MyDataItem(id);
        JsonNode children = node.get("children");
        if (children != null) {
            if (children.isArray()) {
                for (JsonNode child : children) {
                    MyDataItem childDataItem = jp.getCodec().treeToValue(child, MyDataItem.class);
                    mdi.addChild(childDataItem);
                }
            }
            else {
                System.out.println("Ignoring children as not array");
            }
        }

        return mdi;
    }
}
