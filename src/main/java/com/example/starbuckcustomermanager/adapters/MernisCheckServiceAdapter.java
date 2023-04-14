package com.example.starbuckcustomermanager.adapters;

import com.example.starbuckcustomermanager.business.abstracts.CustomerCheckService;
import com.example.starbuckcustomermanager.entities.Customer;
import com.example.starbuckcustomermanager.mernis.DAKKPSPublicSoap;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MernisCheckServiceAdapter implements CustomerCheckService {

    @Override
    public boolean checkIfRealPerson(Customer customer) {

        DAKKPSPublicSoap client = new DAKKPSPublicSoap();
        try{
            boolean customerCheck = client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityIdentity())
                    ,customer.getFirstName(),customer.getLastName()
                    ,customer.getBirthYear().getYear());

            if(customerCheck){
                System.out.println("saved!");
            }else{
                throw new Exception("not saved");
            }
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return false;
    }
}
