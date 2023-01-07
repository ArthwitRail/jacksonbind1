package com.bluetree.jackson.poly;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

//@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property="type", visible = true)
//
//@JsonSubTypes({
//        @JsonSubTypes.Type(value = Type0StructureItem.class, name="type0"),
//        @JsonSubTypes.Type(value = Type1StructureItem.class, name="type1"),
//        @JsonSubTypes.Type(value = Type2StructureItem.class, name="type2"),
//})
public class MyDataItem {


    @JsonProperty("datavalue")
    int dataValue = 0;

    @JsonProperty("children")
    List<MyDataItem> children;

    public MyDataItem(int dataValue) {
        this.dataValue = dataValue;
        children = new ArrayList<>();
    }

    protected void addChild(MyDataItem child) {
        if (children != null)
            this.children.add(child);
    }

}
