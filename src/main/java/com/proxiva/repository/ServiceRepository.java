package com.proxiva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.proxiva.model.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

}