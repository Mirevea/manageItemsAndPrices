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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;

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

/*    @Test
    void findAllByPage() {
        Page<PriceEntityDto> page = new PageImpl<>(Collections.singletonList(PriceBuilder.getDto()));

        Mockito.when(priceServiceImpl.findByCondition(any(), any(), any(), any()))
                .thenReturn(page);

        Mockito.verify(priceServiceImpl, Mockito.times(1)).findByCondition(any(), any(), any(), any());
        Mockito.verifyNoMoreInteractions(priceServiceImpl);
    }*/

    /*@Test
    void getById() throws Exception {
        Mockito.when(priceServiceImpl.findById(ArgumentMatchers.anyString()))
                .thenReturn(PriceBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));

        Mockito.verify(priceServiceImpl, Mockito.times(1)).findById("1");
        Mockito.verifyNoMoreInteractions(priceServiceImpl);
    }*/

}
