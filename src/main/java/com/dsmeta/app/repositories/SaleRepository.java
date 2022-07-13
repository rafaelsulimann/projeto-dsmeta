package com.dsmeta.app.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dsmeta.app.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

    @Query(value = "SELECT obj FROM Sale obj WHERE obj.date BETWEEN :minDate AND :maxDate ORDER BY obj.amount DESC")
    Page<Sale> findAllByDate(LocalDate minDate, LocalDate maxDate, Pageable pageable);
    
}
