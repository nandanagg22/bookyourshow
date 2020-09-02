package com.bookyourshow.frontdesk.persistence.repository;

import com.bookyourshow.frontdesk.persistence.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {
}
