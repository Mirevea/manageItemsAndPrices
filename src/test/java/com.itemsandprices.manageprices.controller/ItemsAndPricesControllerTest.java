package com.itemsandprices.manageprices.controller;

import com.itemsandprices.manageprices.api.controller.ItemsAndPricesController;
import com.itemsandprices.manageprices.api.dto.PriceEntityDTO;
import com.itemsandprices.manageprices.service.impl.PriceServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@Transactional
class ItemsAndPricesControllerTest {
    private static final String ENDPOINT_URL = "/api/price";

    @InjectMocks
    private ItemsAndPricesController priceController;

    @Mock
    private PriceServiceImpl priceServiceImpl;

    private MockMvc mockMvc;
    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(priceController)
                .build();
    }

    @AfterEach
    public void tearDown() throws Exception {
        closeable.close();
    }

/*    @Test
    void findAllByPage() {
        when(priceServiceImpl.findByCondition(any(), any(), any()))
                .thenReturn(PriceBuilder.getDto());

        Optional<PriceEntityDTO> res = priceServiceImpl.findByCondition(any(), any(), any());
        assertNotNull(res);
    }*/

    @Test
    void getById() {
        when(priceServiceImpl.findById(ArgumentMatchers.anyString()))
                .thenReturn(Optional.of(PriceBuilder.getDto()));
        Optional<PriceEntityDTO> resultActions = priceServiceImpl.findById("1111");

        assertNotNull(resultActions);
    }

}
