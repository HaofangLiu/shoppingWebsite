/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1.transactionType.repository;


import ass4.entities.TransactionType;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author haofangliu
 */ 
@Remote
public interface TransactionTypeRepository {
    
    /**
     * Add the transaction type being passed as parameter into the repository
     *
     * @param transactionType
     * @throws java.lang.Exception
     */
    public void addTransactionType(TransactionType transactionType) throws Exception;

    /**
     * Search for a TransactionType by its TransactionType ID
     *
     * @param id - the TransactionType Id of the TransactionType to search for
     * @return the TransactionType found
     * @throws java.lang.Exception
     */
    public TransactionType searchById(int id) throws Exception;
    public List<TransactionType> searchByType(String transType) throws Exception;
    public List<TransactionType> searchByName(String transName) throws Exception;
    public List<TransactionType> getAllTransactionType() throws Exception;
    
    /**
     * Remove the TransactionType, whose TransactionType ID matches the one being passed as parameter, from the repository
     *
     * @param id - the ID of the TransactionType to remove
     * @throws java.lang.Exception
     */
    public void removeTransactionType(int id) throws Exception;
    
    /**
     * Update a property in the repository
     *
     * @param transactionType - the updated information regarding a property
     * @throws java.lang.Exception
     */
    public void editTransactionType(TransactionType transactionType) throws Exception;

}
