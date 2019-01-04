package com.scala.library;

public class RunnerClass {

    public static void main(String... s) {
        String result = JsonPathMapper.mapper(SampleJson.json, "$.store.book[0].author");
        System.out.println(result);

        result = JsonPathMapper.mapper(SampleJson.json, "$.store.book[*]");
        System.out.println(result);
    }

}
