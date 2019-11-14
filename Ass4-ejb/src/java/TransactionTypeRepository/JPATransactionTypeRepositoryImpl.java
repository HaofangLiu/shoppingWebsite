/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransactionTypeRepository;


import ass1.transactionType.repository.TransactionTypeRepository;
import ass4.entities.TransactionType;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author haofangliu
 */
@Stateless
public class JPATransactionTypeRepositoryImpl implements TransactionTypeRepository{

    @PersistenceContext(unitName="Ass4-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addTransactionType(TransactionType transactionType) throws Exception { 
        entityManager.persist(transactionType);
    }

    @Override
    public TransactionType searchById(int id) throws Exception {    
        TransactionType transactionType = entityManager.find(TransactionType.class, id);
        return transactionType;
    }
    
        @Override
    public List<TransactionType> searchByType(String type) throws Exception {    
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TransactionType> cq = cb.createQuery(TransactionType.class);
        Root<TransactionType> r = cq.from(TransactionType.class);
        Predicate condition = cb.equal(r.get("transType"),type);
        cq.where(condition);
        TypedQuery<TransactionType> tq = entityManager.createQuery(cq);
        List<TransactionType> ob = tq.getResultList();
        return ob;
    }
    
        @Override
    public List<TransactionType> searchByName(String name) throws Exception {    
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<TransactionType> cq = cb.createQuery(TransactionType.class);
        Root<TransactionType> r = cq.from(TransactionType.class);
        Predicate condition = cb.equal(r.get("transName"),name);
        cq.where(condition);
        TypedQuery<TransactionType> tq = entityManager.createQuery(cq);
        List<TransactionType> ob = tq.getResultList();
        return ob;
    }

    @Override
    public List<TransactionType> getAllTransactionType() throws Exception {        
        return entityManager.createNamedQuery(TransactionType.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeTransactionType(int id) throws Exception {          
        TransactionType transactionType = this.searchById(id);
      
        if (transactionType != null) {
            entityManager.remove(transactionType);
        }
    }

    @Override
    public void editTransactionType(TransactionType transactionType) throws Exception {      
        entityManager.merge(transactionType);
    }  
   

}
