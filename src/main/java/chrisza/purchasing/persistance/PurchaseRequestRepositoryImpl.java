package chrisza.purchasing.persistance;

import java.util.*;

import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.dependencies.PurchaseRequestRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class PurchaseRequestRepositoryImpl implements PurchaseRequestRepository {

    public Map<UUID, PurchaseRequest> getPurchaseHistory() {
        return purchaseHistory;
    }

    private Map<UUID,PurchaseRequest> purchaseHistory;

    @PostConstruct
    public void PurchaseRequestRepositoryImpl(){
        this.purchaseHistory = new HashMap<UUID,PurchaseRequest>();
    }

    @Override
    public PurchaseRequest Create(PurchaseRequest purchaseRequest) {
        this.purchaseHistory.put(purchaseRequest.getId(),purchaseRequest);
        return purchaseRequest;
    }

    @Override
    public PurchaseRequest getById(UUID id) {
        return  this.purchaseHistory.get(id);
    }

}
