package com.testing.unittesting.controller;

import com.testing.unittesting.model.Item;
import com.testing.unittesting.service.ReturnJsonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReturnJsonController.class)
public class ReturnJsonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReturnJsonService returnJsonService;

    @Test
    public void returnJson() throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders
                .get("/returnJson")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().json("{" +
                        "\"id\":1," +
                        "\"name\":\"Love\"," +
                        "\"price\":10" +
//                        "\"quantity\":20\n" +
                        "}"))
                .andReturn();
    }

    @Test
    public void returnJsonFromService() throws Exception {
        when(returnJsonService.returnJson()).thenReturn(new Item(3, "Love2", 10, 100));

        RequestBuilder builder = MockMvcRequestBuilders
                .get("/itemFromService")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2, name:'Love2', price:10, quantity:100}"))
                .andReturn();
    }

    @Test
    public void returnJsonFromService2() throws Exception {
        when(returnJsonService.retreiveAllData()).thenReturn(Arrays.asList(new Item(1, "A", 1, 2),
                new Item(2, "B", 2, 2)));

        RequestBuilder builder = MockMvcRequestBuilders
                .get("/allDataFromService")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:1, name:'A ', price:1, quantity:2}, {id:2, name:'B', price:2, quantity:2}]"))
                .andReturn();
    }


}
