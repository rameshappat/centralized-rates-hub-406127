package com.organization.rates;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Service class for managing Rates.
 */
@Service
public class RateService {
    private final RateRepository rateRepository;

    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Transactional
    public Rate createRate(Rate rate) {
        return rateRepository.save(rate);
    }

    public List<Rate> getAllRates() {
        return rateRepository.findAll();
    }

    public Rate getRateById(Long id) {
        return rateRepository.findById(id).orElseThrow(() -> new RuntimeException("Rate not found"));
    }
}