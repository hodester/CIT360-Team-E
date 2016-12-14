/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsapp;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Table;




/**
 *
 * @author Hodes
 */


@Entity
@Table(name = "DB_user_table")
public class DataBaseAccountTable implements Serializable{
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "userID")
     private int userID;
    
    @Column(name = "username")
     private String accountName;
    
    @Column(name = "password")
     private String password;
    
    @Column(name = "adminuser")
     private int adminAccount;
    
    @OneToOne
    @JoinColumn(name = "memberID", nullable=false)
     private DataBaseMembers memberMapping;
    
    @Column(name = "isActive")
     private int isActive;
    
    public DataBaseAccountTable(){
    }
    


    public DataBaseAccountTable(Integer userID, String username, String password, Integer adminuser, DataBaseMembers id, Integer isActive){
        this.userID = userID;
        this.accountName = username;
        this.password = password;
        this.adminAccount = adminuser;        
//        this.memberMapping = id;
        this.isActive = isActive;
    }


    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountname) {
        this.accountName = accountname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAdminAccount() {
        return adminAccount;
    }
    public void setAdminAccount(int adminuser) {
        this.adminAccount = adminuser;
    }

    /**
     * @return the isActive
     */
    public int getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the memberMapping
     */
    public DataBaseMembers getMemberMapping() {
        return memberMapping;
    }

    /**
     * @param memberMapping the memberMapping to set
     */
    public void setMemberMapping(DataBaseMembers memberMapping) {
        this.memberMapping = memberMapping;
    }

    /**
     * @return the AccountID
     */
    public int getAccountID() {
        return userID;
    }

    /**
     * @param AccountID the userID to set
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }
}
