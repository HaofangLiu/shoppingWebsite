package ass4.entities;


import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.FetchType.EAGER;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author haofangliu
 */
@Entity
@Table(name = "TransactionType")
@NamedQueries({@NamedQuery(name =TransactionType.GET_ALL_QUERY_NAME, query = "SELECT t FROM TransactionType t")})

public class TransactionType implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String GET_ALL_QUERY_NAME = "TransactionType.getAll";
    
    @Id
    private int id;
    @Column(name = "TransType_type")
    private String transType;
    @Column(name = "TransType_name")
    private String transName;
    @Column(name = "TransType_describtion")
    private String transDesc;
    @ManyToOne(cascade = {CascadeType.MERGE},fetch=FetchType.EAGER)
    private Customer customer;
    
    
    public TransactionType() {
    }

    public TransactionType(int id, String transType, String transName, String transDesc, Customer customer) {
        this.id = id;
        this.transType = transType;
        this.transName = transName;
        this.transDesc = transDesc;
        this.customer = customer;
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
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.transType);
        hash = 83 * hash + Objects.hashCode(this.transName);
        hash = 83 * hash + Objects.hashCode(this.transDesc);
        hash = 83 * hash + Objects.hashCode(this.customer);
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
        final TransactionType other = (TransactionType) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.transType, other.transType)) {
            return false;
        }
        if (!Objects.equals(this.transName, other.transName)) {
            return false;
        }
        if (!Objects.equals(this.transDesc, other.transDesc)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        return true;
    }

    
    
    
    @Override
    public String toString() {
        return "ass1.tickets.entities.TransactionType[ id=" + id + " ]";
    }
    
}