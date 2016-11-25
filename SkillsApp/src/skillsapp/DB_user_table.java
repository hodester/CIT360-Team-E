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
public class DB_user_table implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name = "username")
     private String accountName;
    
    @Column(name = "password")
     private String password;
    
    @Column(name = "adminuser")
     private int adminUser;
    
    @Column(name = "memberID")
     private int memberID;
    
    public DB_user_table(){
    }
    


    public DB_user_table(String username, String password, Integer adminuser, Integer id){
        this.accountName = username;
        this.password = password;
        this.adminUser = adminuser;        
        this.memberID = id;
    }

    public int getMember_ID() {
        return memberID;
    }
    public void setMember_ID(int member_ID) {
        this.memberID = member_ID;
    }
    public String getUserName() {
        return accountName;
    }
    public void setUserName(String username) {
        this.accountName = username;
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
    
}
