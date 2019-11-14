/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1.mbeans;

import ass1.customer.repository.CustomerRepository;
import ass1.transactionType.repository.TransactionTypeRepository;
import ass4.entities.Customer;
import ass4.entities.TransactionType;
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
public class addTransaction implements Serializable {

    @EJB
    private TransactionTypeRepository jPATransactionTypeRepositoryImpl;

    @EJB
    private CustomerRepository jPACustomerRepositoryImpl;
 
    private List<Customer> workers;
    private List<Customer> publicer;
    private int transId;
    private String transName;
    private String transType;
    private String transDesc;
    private Customer customer;
    private TransactionType payDetail;
    
    
    
    /**
     * Creates a new instance of addTransaction
     */
    public addTransaction() {
    }

    public TransactionType getPayDetail() {
        return payDetail;
    }

    public void setPayDetail(TransactionType payDetail) {
        this.payDetail = payDetail;
    }
    

    public CustomerRepository getjPACustomerRepositoryImpl() {
        return jPACustomerRepositoryImpl;
    }

    public void setjPACustomerRepositoryImpl(CustomerRepository jPACustomerRepositoryImpl) {
        this.jPACustomerRepositoryImpl = jPACustomerRepositoryImpl;
    }

    public TransactionTypeRepository getjPATransactionTypeRepositoryImpl() {
        return jPATransactionTypeRepositoryImpl;
    }

    public void setjPATransactionTypeRepositoryImpl(TransactionTypeRepository jPATransactionTypeRepositoryImpl) {
        this.jPATransactionTypeRepositoryImpl = jPATransactionTypeRepositoryImpl;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransDesc() {
        return transDesc;
    }

    public void setTransDesc(String transDesc) {
        this.transDesc = transDesc;
    }

    

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    

    public List<Customer> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Customer> workers) {
        this.workers = workers;
    }

    public List<Customer> getPublicer() {
        return publicer;
    }

    public void setPublicer(List<Customer> publicer) {
        this.publicer = publicer;
    }
    
    public void allPublicUsers() throws Exception{
        String typeUser = "public";
        publicer = jPACustomerRepositoryImpl.cuslistByType(typeUser);
        this.setPublicer(publicer);
    }
    
    public void addPayment(TransactionType a) throws Exception{
        //TransactionType pay = new TransactionType(transId,transType,transName,transDesc,customer);
        jPATransactionTypeRepositoryImpl.addTransactionType(a);
        
    }
    
    public TransactionType saveD(){
        TransactionType pay = new TransactionType(transId,transType,transName,transDesc,customer);
        return pay;
    }
    
    public void displayDetail(TransactionType t){
        payDetail = t;
        this.setPayDetail(payDetail);
    }
    
    public void deleteTrans(int p) throws Exception{
        jPATransactionTypeRepositoryImpl.removeTransactionType(p);
    }
    
}
