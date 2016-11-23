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
public class DataBaseUser implements Serializable {

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

    public DBAccount() {

    }

    public DBAccount(Integer id, String name, String by, Date date) {
        this.accountId = id;
        this.accountname = name;
        this.createdBy = by;
        this.createdDate = date;
    }

    public int getUserId() {
        return accountId;
    }

    public void setUserId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return accountname;
    }

    public void setUsername(String accountusername) {
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
