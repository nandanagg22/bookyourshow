package com.bookyourshow.frontdesk.persistence.repository;

import com.bookyourshow.frontdesk.persistence.model.Theatre;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TheatreRepository extends PagingAndSortingRepository<Theatre, Long> {
    List<Theatre> findAllByCity(String city);
}
