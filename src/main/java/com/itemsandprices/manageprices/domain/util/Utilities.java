package com.itemsandprices.manageprices.domain.util;

import com.itemsandprices.manageprices.infraestructure.dao.PriceEntityDAO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {
    public static boolean availablePrice(PriceEntityDAO daoItem, LocalDateTime specificTime) {
        LocalDateTime startDate = LocalDateTime.parse(daoItem.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));
        LocalDateTime endDate = LocalDateTime.parse(daoItem.getEndDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));
        return !specificTime.isBefore(startDate) && !specificTime.isAfter(endDate);
    }
}
