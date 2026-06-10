package com.proxiva.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proxiva.model.ServiceEntity;
import com.proxiva.repository.ServiceRepository;
import com.proxiva.service.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public ServiceEntity addService(ServiceEntity service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<ServiceEntity> getAllServices() {
        return serviceRepository.findAll();
    }
}