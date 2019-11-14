/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass4.entities;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author haofangliu
 */
@Entity
@Table(name = "Customer")
@NamedQueries({@NamedQuery(name = Customer.GET_ALL_QUERY_NAME, query = "SELECT c FROM Customer c")})

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String GET_ALL_QUERY_NAME = "Customer.getAll";
    
    
    
    @Id
    //@NotNull(message ="Customer ID must not be empty!")
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
    @OneToMany(cascade = {CascadeType.MERGE},fetch=FetchType.EAGER)
    private Set<TransactionType> trans;

    public Customer() {
    }

    public Customer(int id, String lastName, String firstName, String password, String email, String type, String streetAddress, String city, String country, int postcode, int phoneNumber, Set<TransactionType> trans) {
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
        this.trans = trans;
    }

        public Customer(int id, String lastName, String firstName, String password, String email, String type, String streetAddress, String city, String country, int postcode, int phoneNumber) {
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
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Set<TransactionType> getTrans() {
        return trans;
    }

    public void setTrans(Set<TransactionType> trans) {
        this.trans = trans;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.lastName);
        hash = 53 * hash + Objects.hashCode(this.firstName);
        hash = 53 * hash + Objects.hashCode(this.password);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.type);
        hash = 53 * hash + Objects.hashCode(this.streetAddress);
        hash = 53 * hash + Objects.hashCode(this.city);
        hash = 53 * hash + Objects.hashCode(this.country);
        hash = 53 * hash + this.postcode;
        hash = 53 * hash + this.phoneNumber;
        hash = 53 * hash + Objects.hashCode(this.trans);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.postcode != other.postcode) {
            return false;
        }
        if (this.phoneNumber != other.phoneNumber) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.streetAddress, other.streetAddress)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        if (!Objects.equals(this.trans, other.trans)) {
            return false;
        }
        return true;
    }
    
   
    @Override
    public String toString() {
        return "ass1.tickets.entities.Customer[ id=" + id + " ]";
    }
    
}
