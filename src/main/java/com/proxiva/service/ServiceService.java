package com.proxiva.service;

import java.util.List;
import com.proxiva.model.ServiceEntity;

public interface ServiceService {

    ServiceEntity addService(ServiceEntity service);

    List<ServiceEntity> getAllServices();
}