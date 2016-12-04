/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsapp;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Hodes
 */
@Entity
@Table(name = "DB_user")
public class DB_account implements Serializable{
 
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)

@Column(name = "USER_ID")
 private int userId;
 
@Column(name = "USERNAME")
 private String username;
 
@Column(name = "CREATED_BY")
 private String createdBy;
 
@Column(name = "CREATED_DATE")
@Temporal(javax.persistence.TemporalType.DATE)
 private Date createdDate;
 
public DB_account(){
    
}
    
public DB_account(Integer id, String name, String by, Date date){
        this.accountId = id;
        this.accountame = name;
        this.createdBy = by;
        this.createdDate = date;
    }
    
 
public int getAccountId() {
 return accountId;
 }
 public void setAccountId(int accountId) {
 this.accountId = accountId;
 }
 public String getAccountname() {
 return accountname;
 }
 public void setAccountname(String accountname) {
 this.accountname = accountname;
 }
 public String getCreatedBy() {
 return createdBy;
 }
 public void setCreatedBy(String createdBy) {
 this.createdBy = createdBy;
 }
 public Date getCreatedDate() {
 return createdDate;
 }
 public void setCreatedDate(Date createdDate) {
 this.createdDate = createdDate;
 }
}

