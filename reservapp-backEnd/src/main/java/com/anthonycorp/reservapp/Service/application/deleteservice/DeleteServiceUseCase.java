package com.anthonycorp.reservapp.Service.application.DeleteService;

import java.util.concurrent.CompletableFuture;

public interface DeleteServiceUseCase {
    CompletableFuture<Void> execute(Long serviceId, String providerEmail);
}
