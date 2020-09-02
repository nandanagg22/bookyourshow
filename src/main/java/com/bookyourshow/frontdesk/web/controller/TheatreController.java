package com.bookyourshow.frontdesk.web.controller;

import com.bookyourshow.frontdesk.persistence.model.Theatre;
import com.bookyourshow.frontdesk.persistence.repository.TheatreRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/theatre")
public class TheatreController {

    private TheatreRepository theatreRepository;

    public TheatreController(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @GetMapping
    public Iterable<Theatre> listAllTheaters(@RequestParam String city) {
        return this.theatreRepository.findAllByCity(city);
    }
}
