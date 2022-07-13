package com.dsmeta.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsmeta.app.entities.Sale;
import com.dsmeta.app.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    public ResponseEntity<Page<Sale>> findAll(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(saleService.findAll(pageable));
    }
    
}