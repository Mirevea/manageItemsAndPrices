package com.itemsandprices.manageprices.domain.util;

import com.itemsandprices.manageprices.infraestructure.dao.PriceEntityDAO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {
    public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd-HH.mm.ss";

    public static boolean availablePrice(PriceEntityDAO daoItem, LocalDateTime specificTime) {
        LocalDateTime startDate = LocalDateTime.parse(daoItem.getStartDate(), DateTimeFormatter.ofPattern(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
        LocalDateTime endDate = LocalDateTime.parse(daoItem.getEndDate(), DateTimeFormatter.ofPattern(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
        return !specificTime.isBefore(startDate) && !specificTime.isAfter(endDate);
    }
}
