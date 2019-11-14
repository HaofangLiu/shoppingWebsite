/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1.mbeans;

import ass1.transactionType.repository.TransactionTypeRepository;
import ass4.entities.TransactionType;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

/**
 *
 * @author haofangliu
 */
@SessionScoped
@Named
public class TransactionBeans implements Serializable {

    private int transId;
    private TransactionType objId;
    private TransactionType objIdDetail;
    private String transName;
    private List<TransactionType> objsName;
    private List<TransactionType> objsNameDetail;
    //private String transDesc;
    //private String transName;
    //private Customer customer;
    //private int customerId;
    //private List<TransactionType> transList;
    
    @EJB
    private TransactionTypeRepository jPATransactionTypeRepositoryImpl;

    public List<TransactionType> getObjsNameDetail() {
        return objsNameDetail;
    }

    public void setObjsNameDetail(List<TransactionType> objsNameDetail) {
        this.objsNameDetail = objsNameDetail;
    }
    
    
    
    
    public void searchTransName() throws Exception{
        objsName = jPATransactionTypeRepositoryImpl.searchByName(transName);
        this.setObjsName(objsName);
    }

    public List<TransactionType> getObjsName() {
        return objsName;
    }

    public void setObjsName(List<TransactionType> objsName) {
        this.objsName = objsName;
    }

    public void displayObjsName(){
        objsNameDetail = objsName;
        this.setObjsNameDetail(objsNameDetail);
    }
                
    public TransactionBeans() {
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public TransactionTypeRepository getjPATransactionTypeRepositoryImpl() {
        return jPATransactionTypeRepositoryImpl;
    }

    public void setjPATransactionTypeRepositoryImpl(TransactionTypeRepository jPATransactionTypeRepositoryImpl) {
        this.jPATransactionTypeRepositoryImpl = jPATransactionTypeRepositoryImpl;
    }

    public TransactionType getObjIdDetail() {
        return objIdDetail;
    }

    public void setObjIdDetail(TransactionType objIdDetail) {
        this.objIdDetail = objIdDetail;
    }

    public void searchById() throws Exception{
        objId = jPATransactionTypeRepositoryImpl.searchById(this.getTransId());
        this.setObjId(objId);
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public TransactionType getObjId() {
        return objId;
    }

    public void setObjId(TransactionType objId) {
        this.objId = objId;
    }
    /**
     * 
     * @throws Exception 
    
    public void addTransobj() throws Exception {        
        Customer customer = jPACustomerRepositoryImpl.searchCustomer(getCustomerId());
        TransactionType trans = new TransactionType(transId, transDesc,transName,customer);
        jPATransactionTypeRepositoryImpl.addTransactionType(trans);
    }
    **/
    
    public void displayObjId(){
        objIdDetail = objId;
        this.setObjIdDetail(objIdDetail);
         }
    
    
    
    
    
    
}
