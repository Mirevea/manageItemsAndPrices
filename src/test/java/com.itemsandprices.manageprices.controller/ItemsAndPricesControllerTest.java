package com.itemsandprices.manageprices.controller;

import com.itemsandprices.manageprices.dto.PriceDto;
import com.itemsandprices.manageprices.service.PriceService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
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

@Transactional
public class ItemsAndPricesControllerTest {
    private static final String ENDPOINT_URL = "/api/price";

    @InjectMocks
    private ItemsAndPricesController priceController;

    @Mock
    private PriceService priceService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(priceController)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<PriceDto> page = new PageImpl<>(Collections.singletonList(PriceBuilder.getDto()));

        Mockito.when(priceService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any()))
                .thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(priceService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(priceService);
    }

    @Test
    public void getById() throws Exception {
        Mockito.when(priceService.findById(ArgumentMatchers.anyString()))
                .thenReturn(PriceBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));

        Mockito.verify(priceService, Mockito.times(1)).findById("1");
        Mockito.verifyNoMoreInteractions(priceService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(priceService.save(ArgumentMatchers.any(PriceDto.class)))
                .thenReturn(PriceBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(PriceBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        Mockito.verify(priceService, Mockito.times(1)).save(ArgumentMatchers.any(PriceDto.class));
        Mockito.verifyNoMoreInteractions(priceService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(priceService.update(ArgumentMatchers.any(), ArgumentMatchers.anyString()))
                .thenReturn(PriceBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(PriceBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(priceService, Mockito.times(1))
                .update(ArgumentMatchers.any(PriceDto.class), ArgumentMatchers.anyString());
        Mockito.verifyNoMoreInteractions(priceService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(priceService).deleteById(ArgumentMatchers.anyString());

        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(PriceBuilder.getIds())))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(priceService, Mockito.times(1))
                .deleteById(Mockito.anyString());
        Mockito.verifyNoMoreInteractions(priceService);
    }
}
