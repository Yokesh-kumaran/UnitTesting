package com.testing.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:test-configuration.properties"})
public class ReturnJsonIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() throws JSONException {
        String response = testRestTemplate.getForObject("/allDataFromService", String.class);
        JSONAssert.assertEquals("[{id:100, name:'Abcd', price:1000, quantity:10}, " +
                "{id:101, name:'Abcde', price:2000, quantity:20}, {}]", response, false);
    }
}
