package chrisza.purchasing.domain.dependencies;

import java.util.Map;
import java.util.UUID;

import chrisza.purchasing.domain.PurchaseRequest;

public interface PurchaseRequestRepository {
    PurchaseRequest Create(PurchaseRequest purchaseRequest);

    PurchaseRequest getById(UUID id);

    Map<UUID, PurchaseRequest> getPurchaseHistory() ;
}
