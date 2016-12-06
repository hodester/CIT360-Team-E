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

@Entity
@Table(name = "DB_member_table")
public class DataBaseMembers implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name = "memberID")
     private Integer memberID;
    
    @Column(name = "LName")
     private String LName;
    
    @Column(name = "FName")
     private String FName;
    
    @Column(name = "MName")
     private String MName;
    
    @Column(name = "phone")
     private Long phone;
    
    @Column(name = "phoneType")
     private Integer phoneType;
    
    @Column(name = "Email")
     private String Email;
    
    @ManyToOne
    @JoinColumn(name = "addressID")
     private DataBaseAddress addressTableMapping;
    
    @OneToOne(mappedBy="memberMapping")
    private DataBaseAccountTable memberUser;
    
    @Column(name = "skillsID")
     private String skillsID;
    
    @Column(name = "wardID")
     private Integer wardID;
    
    public DataBaseMembers(){
    }

    public DataBaseMembers(Integer memberID, String LName, String FName, String MName, Long phone, Integer phoneType, String Email, DataBaseAddress addressTableID, String skillsID, Integer wardID){
        this.memberID = memberID;
        this.LName = LName;
        this.FName = FName;        
        this.MName = MName;
        this.phone = phone;
        this.phoneType = phoneType;
        this.Email = Email;
        this.addressTableMapping = addressTableID;
        this.skillsID = skillsID;
        this.wardID = wardID;
    }
    
    

    /**
     * @return the memberID
     */
    public Integer getMemberID() {
        return memberID;
    }

    /**
     * @param memberID the memberID to set
     */
    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    /**
     * @return the LName
     */
    public String getLName() {
        return LName;
    }

    /**
     * @param LName the LName to set
     */
    public void setLName(String LName) {
        this.LName = LName;
    }

    /**
     * @return the FName
     */
    public String getFName() {
        return FName;
    }

    /**
     * @param FName the FName to set
     */
    public void setFName(String FName) {
        this.FName = FName;
    }

    /**
     * @return the MName
     */
    public String getMName() {
        return MName;
    }

    /**
     * @param MName the MName to set
     */
    public void setMName(String MName) {
        this.MName = MName;
    }

    /**
     * @return the phone
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**
     * @return the phoneType
     */
    public Integer getPhoneType() {
        return phoneType;
    }

    /**
     * @param phoneType the phoneType to set
     */
    public void setPhoneType(Integer phoneType) {
        this.phoneType = phoneType;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }


    /**
     * @return the skillsID
     */
    public String getSkillsID() {
        return skillsID;
    }

    /**
     * @param skillsID the skillsID to set
     */
    public void setSkillsID(String skillsID) {
        this.skillsID = skillsID;
    }

    /**
     * @return the wardID
     */
    public Integer getWardID() {
        return wardID;
    }

    /**
     * @param wardID the wardID to set
     */
    public void setWardID(Integer wardID) {
        this.wardID = wardID;
    }

    /**
     * @return the addressTableMapping
     */
    public DataBaseAddress getAddressTableMapping() {
        return addressTableMapping;
    }

    /**
     * @param addressTableMapping the addressTableMapping to set
     */
    public void setAddressTableMapping(DataBaseAddress addressTableMapping) {
        this.addressTableMapping = addressTableMapping;
    }

    /**
     * @return the memberAccount
     */
    public DataBaseAccountTable getMemberAccount() {
        return memberUser;
    }

    /**
     * @param memberUser the memberUser to set
     */
    public void setMemberUser(DataBaseAccountTable memberUser) {
        this.memberUser = memberUser;
    }
}