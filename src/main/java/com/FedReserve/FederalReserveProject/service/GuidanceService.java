package com.FedReserve.FederalReserveProject.service;

import com.FedReserve.FederalReserveProject.model.GuidanceEntity;
import com.FedReserve.FederalReserveProject.repository.GuidanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@RequiredArgsConstructor
@Service
public class GuidanceService {

    private final GuidanceRepository guidanceRepository;

    @Transactional
    public GuidanceEntity create(GuidanceEntity guidance){
        return guidanceRepository.save(guidance);
    }

    @Transactional(readOnly = true)
    public GuidanceEntity findGuidance(Integer id){
        return guidanceRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Check Id"));
    }

    @Transactional(readOnly = true)
    public List<GuidanceEntity> findAll(){
        return guidanceRepository.findAll();
    }

    @Transactional
    public String delete(Integer id){
        guidanceRepository.deleteById(id);
        return "ok";
    }


}