package com.itemsandprices.manageprices.controller;

import com.itemsandprices.manageprices.api.controller.ItemsAndPricesController;
import com.itemsandprices.manageprices.domain.dto.PriceEntityDto;
import com.itemsandprices.manageprices.service.impl.PriceServiceImpl;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
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

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(priceController)
                .build();
    }

    @Test
    void findAllByPage() {
        Page<PriceEntityDto> page = new PageImpl<>(Collections.singletonList(PriceBuilder.getDto()));
        when(priceServiceImpl.findByCondition(any(), any(), any(), any()))
                .thenReturn(page);

        Page<PriceEntityDto> res = priceServiceImpl.findByCondition(any(), any(), any(), any());
        assertNotNull(res);
    }

    @Test
    void getById() {
        when(priceServiceImpl.findById(ArgumentMatchers.anyString()))
                .thenReturn(Optional.of(PriceBuilder.getDto()));
        Optional<PriceEntityDto> resultActions = priceServiceImpl.findById("1111");

        assertNotNull(resultActions);
    }

}
