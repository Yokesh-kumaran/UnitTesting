package com.testing.unittesting.controller;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {
    @Test
    public void learning() {
        String response = "[" +
                "{\"id\":1, \"name\":\"pen\", \"price\":10}," +
                "{\"id\":2, \"name\":\"pencil\", \"price\":7}," +
                "{\"id\":3, \"name\":\"eraser\", \"price\":5}" +
                "]";

        DocumentContext parse = JsonPath.parse(response);
        int length = parse.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids = parse.read("$..id");
        assertThat(ids).contains(1,2,3);

        System.out.println(parse.read("$.[1]").toString());
        System.out.println(parse.read("$.[0:2]").toString());
        System.out.println(parse.read("$.[?(@.name == 'pen')]").toString());
        System.out.println(parse.read("$.[?(@.price == 5)]").toString());
    }
}
