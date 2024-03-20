package com.testing.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
    String actualResponse = "{\"id\":1,\"name\":\"Love\",\"price\":10,\"quantity\":20}";

    @Test
    public void jsonAssert_ExactMatchExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":  1 ,\n\"name\":\"Love\",\"price\":10,\"quantity\":20}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\":  1 ,\"name\":\"Love\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeCharacter() throws JSONException{
        String expectedResponse = "{id : 1, name : 'Love'  , price: 10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
