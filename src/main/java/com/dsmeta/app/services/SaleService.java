package com.dsmeta.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dsmeta.app.entities.Sale;

public interface SaleService {

    Page<Sale> findAll(Pageable pageable);
    
}
