package com.dsmeta.app.services.impl;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dsmeta.app.entities.Sale;
import com.dsmeta.app.repositories.SaleRepository;
import com.dsmeta.app.services.SaleService;

@Service
public class SaleServiceImpl implements SaleService{

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Page<Sale> findAll(String minDate, String maxDate, Pageable pageable) {
        LocalDate now = LocalDate.now(ZoneId.of("UTC"));

        LocalDate min = minDate.equals("") ? now.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? now : LocalDate.parse(maxDate);

        return saleRepository.findAllByDate(min, max, pageable);
    }
    
}
