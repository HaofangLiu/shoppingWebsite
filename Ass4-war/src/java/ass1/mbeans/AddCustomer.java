/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass1.mbeans;

import ass1.customer.repository.CustomerRepository;
import ass4.entities.Customer;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author haofangliu
 */
@Named
@SessionScoped
public class AddCustomer implements Serializable {

    @EJB
    private CustomerRepository jPACustomerRepositoryImpl;

    //private boolean showForm = true;
    //private Customer customer;
    private int id;
    private String lastName;
    private String firstName;
    private String password;
    private String email;
    private String type;
    private String streetAddress;
    private String city;
    private String country;
    private int postcode;
    private int phoneNumber;

    /**
     * Creates a new instance of AddCustomer
     */
    public AddCustomer() {
    }

   
      public void addCus() throws Exception {
        Customer customer = new Customer(id, lastName, firstName, password, email, type, streetAddress, city, country, postcode, phoneNumber);
        jPACustomerRepositoryImpl.addCustomer(customer);
    }

    public void logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();
        try {
            context.getExternalContext().redirect("../index.xhtml");
        } catch (IOException e) {
        }
    }

    public CustomerRepository getjPACustomerRepositoryImpl() {
        return jPACustomerRepositoryImpl;
    }

    public void setjPACustomerRepositoryImpl(CustomerRepository jPACustomerRepositoryImpl) {
        this.jPACustomerRepositoryImpl = jPACustomerRepositoryImpl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

     public AddCustomer(int id, String lastName, String firstName, String password, String email, String type, String streetAddress, String city, String country, int postcode, int phoneNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
        this.type = type;
        this.streetAddress = streetAddress;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

  

}
