package com.proxiva.model;

import jakarta.persistence.*;

@Entity
@Table(name="bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id")
    private Long userId;

    @Column(name="provider_id")
    private Long providerId;

    @Column(name="service_id")
    private Long serviceId;

    private String status;

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProviderId() {
        return providerId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}