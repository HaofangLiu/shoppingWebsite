/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1.mbeans;

import ass1.customer.repository.CustomerRepository;
import ass4.entities.Customer;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author haofangliu
 */
@Named
@SessionScoped
public class ViewCus implements Serializable {

    @EJB
    private CustomerRepository jPACustomerRepositoryImpl;

    private List<Customer> cusAll;
    
    
    /**
     * Creates a new instance of ViewCus
     */
    public ViewCus() {
    }

    public List<Customer> getCusAll() {
        return cusAll;
    }

    public void setCusAll(List<Customer> cusAll) {
        this.cusAll = cusAll;
    }
    
    public void getAllCus() throws Exception{
        List<Customer> customersAll = jPACustomerRepositoryImpl.getAllCustomer();
        this.setCusAll(customersAll);
    }
    
    
}
