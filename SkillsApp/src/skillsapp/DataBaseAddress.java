/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsapp;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Hodes
 */
public class DataBaseAddress {
    @Entity
@Table(name = "DB_address_table")
public class DataBaseAddress implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "addressID")
     private Integer addressID;
    
    @Column(name = "streetAddress")
     private String streetAddress;
    
    @Column(name = "city")
     private String city;
    
    @Column(name = "homeState")
     private String homeState;
    
    @Column(name = "zipCode")
     private String zipCode;    
    
    @OneToMany(mappedBy="addressTableMapping")
    private Set<DB_member_table> addresses;
    
    
    
    public DataBaseAddress (){}
    
    public DataBaseAddress(Integer addressID, String streetAddress, String city, String homeState, String zipCode){
        this.addressID = addressID;
        this.streetAddress = streetAddress;
        this.city = city;        
        this.homeState = homeState;
        this.zipCode = zipCode;
    }

    /**
     * @return the addressID
     */
    public Integer getAddressID() {
        return addressID;
    }

    /**
     * @param addressID the addressID to set
     */
    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    /**
     * @return the streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the homeState
     */
    public String getHomeState() {
        return homeState;
    }

    /**
     * @param homeState the homeState to set
     */
    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the addresses
     */
    public Set<DB_member_table> getAddresses() {
        return addresses;
    }

    /**
     * @param addresses the addresses to set
     */
    public void setAddresses(Set<DB_member_table> addresses) {
        this.addresses = addresses;
    }
}