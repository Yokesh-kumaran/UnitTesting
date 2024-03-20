package com.testing.unittesting.service;

import com.testing.unittesting.data.ItemRepository;
import com.testing.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JsonServiceTest {
    @InjectMocks
    private ReturnJsonService returnJsonService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    public void serviceJsonTest() {
        when(itemRepository.findAll()).thenReturn(Arrays.asList(new Item(1, "A", 1, 2),
                new Item(2, "B", 2, 2)));

        List<Item> items = returnJsonService.retreiveAllData();

        assertEquals(2, items.get(0).getValue());
        assertEquals(4, items.get(1).getValue());
    }
}
