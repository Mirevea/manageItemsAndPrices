package com.itemsandprices.manageprices.domain.util;

import com.itemsandprices.manageprices.infraestructure.dao.PriceEntityDAO;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Comparator;
import java.util.List;

public class Utilities {
    public static PriceEntityDAO getHighestPriorityPrice(List<PriceEntityDAO> prices) {
        return prices.stream()
                .max(Comparator.comparingInt(price -> Integer.parseInt(price.getPriority())))
                .orElseThrow(() -> new ResourceNotFoundException("No price found"));
    }

    /*private static int parsePriority(String priority) {
        try {
            return Integer.parseInt(priority);
        } catch (NumberFormatException e) {
            throw new InvalidPriorityException("Invalid priority format: " + priority);
        }
    }*/
}
