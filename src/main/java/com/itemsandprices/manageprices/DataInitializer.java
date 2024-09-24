package com.itemsandprices.manageprices;

import com.fasterxml.jackson.core.type.TypeReference;
import com.itemsandprices.manageprices.domain.entity.PriceEntity;
import com.itemsandprices.manageprices.domain.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Component
public class DataInitializer {

    @Autowired
    private PriceRepository priceRepository;
    private final ResourceLoader resourceLoaderlocal;

    public DataInitializer(ResourceLoader resourceLoaderlocal) {
        this.resourceLoaderlocal = resourceLoaderlocal;

    }

    @PostConstruct
    public void init() {
        loadPricesFromYaml();
    }

    private void loadPricesFromYaml() {
        Resource resource = resourceLoaderlocal.getResource("classpath:data/pricesdatabase.yml");

        try (InputStream inputStream = resource.getInputStream()) {
            Yaml yaml = new Yaml();
            List<Map<String, Object>> pricesList = yaml.load(inputStream); // Cargar como List<Map<String, Object>>

            // Convertir cada Map en PriceEntity
            for (Map<String, Object> priceData : pricesList) {
                PriceEntity priceEntity = new PriceEntity();
                priceEntity.setRateId(((Number) priceData.get("RATE_ID")).longValue());
                priceEntity.setBrandId(((Number) priceData.get("BRAND_ID")).longValue());
                priceEntity.setStartDate((String) priceData.get("START_DATE"));
                priceEntity.setEndDate((String) priceData.get("END_DATE"));
                priceEntity.setPriceList((String) priceData.get("PRICE_LIST"));
                priceEntity.setProductId((String) priceData.get("PRODUCT_ID"));
                priceEntity.setPriority((String) priceData.get("PRIORITY"));
                priceEntity.setPrice((String) priceData.get("PRICE"));
                priceEntity.setCurr((String) priceData.get("CURR"));

                priceRepository.save(priceEntity); // Guardar en la base de datos
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo YAML: " + e.getMessage(), e);
        }
    }
}

