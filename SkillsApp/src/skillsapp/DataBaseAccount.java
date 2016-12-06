/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsapp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author mhodes
 */
@Entity
@Table(name = "DB_user")
public class DataBaseAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "USER_ID")
    private int accountId;

    @Column(name = "USERNAME")
    private String accountname;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    public DataBaseAccount() {

    }

    public DataBaseAccount(Integer id, String name, String by, Date date) {
        this.accountId = id;
        this.accountname = name;
        this.createdBy = by;
        this.createdDate = date;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountname;
    }

    public void setAccountName(String accountusername) {
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