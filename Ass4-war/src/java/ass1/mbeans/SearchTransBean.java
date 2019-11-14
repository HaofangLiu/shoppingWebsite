/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1.mbeans;

import ass1.transactionType.repository.TransactionTypeRepository;
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
@Named(value = "searchTransBean")
@SessionScoped
public class SearchTransBean implements Serializable {

    private String transType;
    private List<TransactionType> objsByType;
    private List<TransactionType> objsByTypeDetail;
    
    @EJB
    private TransactionTypeRepository jPATransactionTypeRepositoryImpl;
    
    
    public SearchTransBean() {
    }

    public List<TransactionType> getObjsByTypeDetail() {
        return objsByTypeDetail;
    }

    public void setObjsByTypeDetail(List<TransactionType> objsByTypeDetail) {
        this.objsByTypeDetail = objsByTypeDetail;
    }
    
    

    public List<TransactionType> getObjsByType() {
        return objsByType;
    }

    public void setObjsByType(List<TransactionType> objsByType) {
        this.objsByType = objsByType;
    }
    

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public void searchByType() throws Exception{
        objsByType = jPATransactionTypeRepositoryImpl.searchByType(transType);
        this.setObjsByType(objsByType);
    }

    public void displaySearchByType(){
        objsByTypeDetail = objsByType;
        this.setObjsByTypeDetail(objsByTypeDetail);
    }
    
    
}
