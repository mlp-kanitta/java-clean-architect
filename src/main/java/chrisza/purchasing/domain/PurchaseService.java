package chrisza.purchasing.domain;

import chrisza.purchasing.domain.dependencies.PurchaseRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PurchaseService {

    public static final int APPROVAL_LIMIT = 100000;
    public static final String MID_LEVEL_APPROVAL_EMAIL = "steve@microapplesoft.com";
    public static final String SENIOR_LEVEL_APPROVAL_EMAIL = "mark@microapplesoft.com";


    @Autowired
    private PurchaseRequestRepository purchaseRequestRepository;

    public PurchaseRequest purchaseRequest (PurchaseRequest purchaseRequest){
        int totalAmount = getTotalAmount(purchaseRequest);

        if(totalAmount > APPROVAL_LIMIT && "SENIOR".equals(purchaseRequest.getApprover().getLevel())){
            purchaseRequestRepository.Create(purchaseRequest);
        }else if (totalAmount <= APPROVAL_LIMIT ){
            purchaseRequestRepository.Create(purchaseRequest);
        }
        return null;
    }

    public int getTotalAmount(PurchaseRequest purchaseRequest){
        int totalAmount = 0;
        for ( PurchaseRequestItem item :  purchaseRequest.getItems()) {
            totalAmount+= item.getTotalPrice();
        }
        return totalAmount;
    }
}
