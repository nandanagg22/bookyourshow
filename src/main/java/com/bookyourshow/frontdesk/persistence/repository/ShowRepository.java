package com.bookyourshow.frontdesk.persistence.repository;

import com.bookyourshow.frontdesk.persistence.model.Show;
import com.bookyourshow.frontdesk.persistence.model.ShowStatus;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShowRepository extends PagingAndSortingRepository<Show, Long> {

    Iterable<Show> findAllByTheatreIdAndStatus(Long theatreId, ShowStatus status);
}
