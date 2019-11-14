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
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author haofangliu
 */
@Named(value = "searchUser")
@SessionScoped
public class SearchUser implements Serializable {

    @EJB
    private CustomerRepository jPACustomerRepositoryImpl;

    private String searchType;
    private String searchContent;
    private List<String> searchList;
    private List<Customer> resultCus;

    /**
     * Creates a new instance of SearchUser
     */
    public SearchUser() {
        searchList = new ArrayList<>();
        searchList.add("Id");
        searchList.add("Last Name");
        searchList.add("First Name");
        searchList.add("Type");
        searchList.add("Email");
    }

    public List<Customer> getResultCus() {
        return resultCus;
    }

    public void setResultCus(List<Customer> resultCus) {
        this.resultCus = resultCus;
    }
    
    

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
    }

    public List<String> getSearchList() {
        return searchList;
    }

    public void setSearchList(ArrayList<String> searchList) {
        this.searchList = searchList;
    }

    public void searchCust() throws Exception {
        if (searchType.equals("Id")) {
            int cusId = Integer.parseInt(searchContent);
            List<Customer> list = new ArrayList<>();
            list.add(jPACustomerRepositoryImpl.searchCustomer(cusId));
            resultCus = list;
        }
        if (searchType.equals("Last Name")) {
            resultCus = jPACustomerRepositoryImpl.searchByLastName(searchContent);
        }
        if (searchType.equals("First Name")) {
            resultCus = jPACustomerRepositoryImpl.searchByFirstName(searchContent);
        }
        if (searchType.equals("Type")) {
            resultCus = jPACustomerRepositoryImpl.cuslistByType(searchContent);
        }
        if (searchType.equals("Email")){
            resultCus = jPACustomerRepositoryImpl.searchByEmail(searchContent);
        }
        this.setResultCus(resultCus);
    }

    
}
