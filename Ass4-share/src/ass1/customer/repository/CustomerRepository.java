/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1.customer.repository;

import ass4.entities.Customer;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author haofangliu
 */
@Remote
public interface CustomerRepository {
    
    
    public List<Customer> searchByEmail(String email) throws Exception;
    public List<Customer> searchByFirstName(String firstName) throws Exception;
    public List<Customer> searchByLastName(String LastName) throws Exception;
    public List<Customer> cuslistByType(String type) throws Exception;
    /**
     * Add the transaction type being passed as parameter into the repository
     *
     * @param customer
     * @throws java.lang.Exception
     */
    public void addCustomer(Customer customer) throws Exception;

    /**
     * Search for a TransactionType by its TransactionType ID
     *
     * @param id - the TransactionType Id of the TransactionType to search for
     * @return the TransactionType found
     * @throws java.lang.Exception
     */
    public Customer searchCustomer(int id) throws Exception;

    /**
     * Return all the TransactionType in the repository
     *
     * @return all the TransactionType in the repository
     * @throws java.lang.Exception
     */
    public List<Customer> getAllCustomer() throws Exception;
    
    /**
     * Remove the TransactionType, whose TransactionType ID matches the one being passed as parameter, from the repository
     *
     * @param id - the ID of the TransactionType to remove
     * @throws java.lang.Exception
     */
    public void removeCustomer(int id) throws Exception;
    
    /**
     * Update a property in the repository
     *
     * @param Customer
     * @throws java.lang.Exception
     */
    public void editCustomer(Customer Customer) throws Exception;

}

