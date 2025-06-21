package com.anthonycorp.reservapp.Service.application.DeleteService;

public interface DeleteServiceUseCase {
    void execute(Long serviceId, String providerEmail);
}
