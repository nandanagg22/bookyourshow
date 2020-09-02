package com.bookyourshow.frontdesk.web.controller;

import com.bookyourshow.frontdesk.persistence.model.Show;
import com.bookyourshow.frontdesk.persistence.model.ShowStatus;
import com.bookyourshow.frontdesk.persistence.repository.ShowRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/show")
public class ShowController {
    private ShowRepository showRepository;

    public ShowController(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    @GetMapping
    public Iterable<Show> loadAllActiveShowByTheatre(@RequestParam Long theatreId) {
        return this.showRepository.findAllByTheatreIdAndStatus(theatreId, ShowStatus.ACTIVE);
    }

}
