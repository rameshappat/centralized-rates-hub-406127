package com.organization.rates;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST controller for managing Rates.
 */
@RestController
@RequestMapping("/api/rates")
public class RateController {
    private final RateService rateService;

    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @PostMapping
    public ResponseEntity<Rate> createRate(@RequestBody Rate rate) {
        Rate createdRate = rateService.createRate(rate);
        return ResponseEntity.ok(createdRate);
    }

    @GetMapping
    public ResponseEntity<List<Rate>> getAllRates() {
        List<Rate> rates = rateService.getAllRates();
        return ResponseEntity.ok(rates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rate> getRateById(@PathVariable Long id) {
        Rate rate = rateService.getRateById(id);
        return ResponseEntity.ok(rate);
    }
}