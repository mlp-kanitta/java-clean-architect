package chrisza.purchasing.persistance;

import chrisza.purchasing.domain.Employee;
import chrisza.purchasing.domain.PurchaseRequest;
import chrisza.purchasing.domain.PurchaseRequestItem;
import chrisza.purchasing.domain.dependencies.PurchaseRequestRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PurchaseRequestRepositoryTest {

    @Autowired
    private PurchaseRequestRepository purchaseRequestRepository;

    @Test
    public void create_purchase_success() {

        PurchaseRequest input = prepareTestData(UUID.randomUUID());
        input.setId(UUID.randomUUID());

        PurchaseRequest actual = purchaseRequestRepository.Create(input);
        assertEquals(1,purchaseRequestRepository.getPurchaseHistory().size());
        assertEquals(input.getId(), actual.getId());
    }


    @Test
    public void getById_success() {

        UUID uuid1 = UUID.randomUUID();

        PurchaseRequest input = prepareTestData(uuid1);
        purchaseRequestRepository.Create(input);

        PurchaseRequest actual = purchaseRequestRepository.getById(uuid1);
        assertEquals(uuid1, actual.getId());
    }

    public PurchaseRequest prepareTestData(UUID id){

        PurchaseRequestItem item1 = new PurchaseRequestItem();
        item1.setId(UUID.randomUUID());
        item1.setItem("Item1");
        item1.setAmount(10);
        item1.setTotalPrice(25000);

        PurchaseRequestItem item2 = new PurchaseRequestItem();
        item1.setId(UUID.randomUUID());
        item1.setItem("Item2");
        item1.setAmount(2);
        item1.setTotalPrice(300);

        List<PurchaseRequestItem> itemList = new ArrayList<PurchaseRequestItem>();
        itemList.add(item1);
        itemList.add(item2);

        Employee owner = new Employee("me@microapplesoft.com","STAFF");

        Employee approver = new Employee("steve@microapplesoft.com", "MID-LEVEL");

        PurchaseRequest input = new PurchaseRequest(itemList,owner,approver);
        input.setId(id);

        return input;

    }


}
