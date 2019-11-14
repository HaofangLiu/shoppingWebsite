/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerRepository;

import ass1.customer.repository.CustomerRepository;
import ass4.entities.Customer;
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
public class JPACustomerRepositoryImpl implements CustomerRepository {

    @PersistenceContext(unitName = "Ass4-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addCustomer(Customer customer) throws Exception {
        entityManager.persist(customer);
    }

    @Override
    public Customer searchCustomer(int id) throws Exception {
        Customer customer = entityManager.find(Customer.class, id);
        //customer.getCustomer();
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() throws Exception {
        return entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeCustomer(int id) throws Exception {
        Customer customer = this.searchCustomer(id);

        if (customer != null) {
            entityManager.remove(customer);
        }
    }

    @Override
    public void editCustomer(Customer customer) throws Exception {
        entityManager.merge(customer);
    }

    @Override
    public List<Customer> cuslistByType(String type) throws Exception {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> r = cq.from(Customer.class);
        Predicate condition = cb.equal(r.get("type"), type);
        cq.where(condition);
        TypedQuery<Customer> tq = entityManager.createQuery(cq);
        List<Customer> ob = tq.getResultList();
        return ob;
    }
    
        @Override
    public List<Customer> searchByFirstName(String firstName) throws Exception {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> r = cq.from(Customer.class);
        Predicate condition = cb.equal(r.get("firstName"), firstName);
        cq.where(condition);
        TypedQuery<Customer> tq = entityManager.createQuery(cq);
        List<Customer> ob = tq.getResultList();
        return ob;
    }
    
            @Override
    public List<Customer> searchByLastName(String lastName) throws Exception {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> r = cq.from(Customer.class);
        Predicate condition = cb.equal(r.get("lastName"), lastName);
        cq.where(condition);
        TypedQuery<Customer> tq = entityManager.createQuery(cq);
        List<Customer> ob = tq.getResultList();
        return ob;
    }
    
              @Override
    public List<Customer> searchByEmail(String email) throws Exception {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> r = cq.from(Customer.class);
        Predicate condition = cb.equal(r.get("email"), email);
        cq.where(condition);
        TypedQuery<Customer> tq = entityManager.createQuery(cq);
        List<Customer> ob = tq.getResultList();
        return ob;
    }

}
