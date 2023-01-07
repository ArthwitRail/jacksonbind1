package com.bluetree.jackson.poly;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MyObject
{

    @JsonProperty("mydata")
    List<MyDataItem> mydata;


}
