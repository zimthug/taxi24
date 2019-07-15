package com.tamla.taxi24.service.impl;

import com.tamla.taxi24.model.Rider;
import com.tamla.taxi24.repository.RiderRepository;
import com.tamla.taxi24.service.RiderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderServiceImpl  implements RiderService {

    private RiderRepository riderRepository;

    public RiderServiceImpl(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    @Override
    public List<Rider> list() {
        return this.riderRepository.findAll();
    }

    @Override
    public Rider findRiderByRiderId(Long riderId) {
        return this.riderRepository.findRiderByRiderId(riderId) ;
    }
}
