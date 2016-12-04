/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsapp;

import java.io.Serializable;
import javax.persistence.*;


/**
 *
 * @author Hodes
 */
@Entity
@Table(name = "DB_user_table")
public class DataBaseUserTable implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name = "userID")
     private int accountID;
    
    @Column(name = "username")
     private String accountName;
    
    @Column(name = "password")
     private String password;
    
    @Column(name = "adminuser")
     private int adminUser;
    
    @OneToOne
    @JoinColumn(name = "memberID", nullable=false)
     private DB_member_table memberMapping;
    
    @Column(name = "isActive")
     private int isActive;
    
    public DataBaseUserTable(){
    }
    
    public DataBaseUserTable(Integer accountID, String username, String password, Integer adminuser, DB_member_table id, Integer isActive){
        this.accountID = userID;
        this.accountName = username;
        this.password = password;
        this.adminUser = adminuser;        
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
    public int getAdminUser() {
        return adminUser;
    }
    public void setAdminUser(int adminuser) {
        this.adminUser = adminuser;
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
    public DB_member_table getMemberMapping() {
        return memberMapping;
    }

    /**
     * @param memberMapping the memberMapping to set
     */
    public void setMemberMapping(DB_member_table memberMapping) {
        this.memberMapping = memberMapping;
    }

    /**
     * @return the accountID
     */
    public int getAccountID() {
        return accountID;
    }

    /**
     * @param accountID the userID to set
     */
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
}
