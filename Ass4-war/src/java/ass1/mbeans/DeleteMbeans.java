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
import javax.ejb.EJB;

/**
 *
 * @author haofangliu
 */
@Named(value = "deleteMbeans")
@SessionScoped
public class DeleteMbeans implements Serializable {

    @EJB
    private CustomerRepository jPACustomerRepositoryImpl;
    private Customer customer;
    //private Customer editedCus;
    
    /**
     * Creates a new instance of DeleteMbeans
     */
    public DeleteMbeans() {
    }
/**
 * 
 * @return 

    public Customer getEditedCus() {
        return editedCus;
    }
    * 

    public void setEditedCus(Customer editedCus) {
        this.editedCus = editedCus;
    }
     */

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    

    public CustomerRepository getjPACustomerRepositoryImpl() {
        return jPACustomerRepositoryImpl;
    }

    public void setjPACustomerRepositoryImpl(CustomerRepository jPACustomerRepositoryImpl) {
        this.jPACustomerRepositoryImpl = jPACustomerRepositoryImpl;
    }
    
    public void deleCus(int id) throws Exception{
        jPACustomerRepositoryImpl.removeCustomer(id);
    }
    
    public void editCus(int id) throws Exception {
        Customer i = jPACustomerRepositoryImpl.searchCustomer(id);
        this.setCustomer(i);
        
    }
            
    public void updateNewCus() throws Exception
    {
        jPACustomerRepositoryImpl.editCustomer(customer);
    }
    
}
