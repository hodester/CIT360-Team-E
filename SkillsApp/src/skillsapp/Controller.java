/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsapp;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mhodes
 */

public class Controller {

    static void creatAccountRecord(String aAccountName, String aPassword, String aIsAdmin, 
            String aFirstName, String aMiddelName, String aLastName, String aPhone, 
            Integer aPhoneType, String aEmail, String aStreetAddress, String aCity, 
            String aState, String aZipCode) {
// Skills Resource Assistant ~ method        

        DataBaseUserTable account = new DataBaseUserTable();
        DB_member_table member = new DB_member_table();
        DB_address_table address = new DB_address_table();
        int newMemberID = newMemNumber();
        
        aPhone = aPhone.replaceAll("[-+.^:,_]","");
        
        account.setAccountName(aAccountName);
        account.setPassword(aPassword);
        if (aIsAdmin.equalsIgnoreCase("Y")){
            account.setAdminAccount(1);
        } else {
            account.setAdminAccount(0);
        }
        account.setIsActive(1);
        
        member.setLName(aLastName);
        member.setFName(aFirstName);
        member.setMName(aMiddelName);
        if (aPhone != null){
           aPhone = aPhone.replaceAll("[-+.^:,_*]","");
            member.setPhone(Long.parseLong(aPhone));
        } else {
           aPhone = aPhone.replaceAll("[-+.^:,_*]","");
            member.setPhone(Long.parseLong(aPhone));
        }
        member.setPhoneType(aPhoneType);
        member.setEmail(aEmail);
        member.setSkillsID("");
        member.setWardID(0);
        account.setMemberMapping(member);
        address.setStreetAddress(aStreetAddress);
        address.setCity(aCity);
        address.setHomeState(aState);
        address.setZipCode(aZipCode);
        member.setAddressTableMapping(address);
        
        Model.insertAccount(account,member,address,newMemberID);
             
             
    }
    
    static Integer newMemNumber (){
// Skills Resource Assistant ~ method
// this works
        List<DB_address_table> query = Model.newMemberNumber();
        int result = Integer.parseInt(query.toString().replace("[", "").replace("]",""))+1;
//        System.out.println("results - "+result);
        return result;
    }

    
    
    static List<DB_member_table> listMemberTable() {
// Skills Resource Assistant ~ method        
         List<DB_member_table> accountList = Model.showAllDBMemberTable();
         return accountList;
    }

    static List<DB_member_table> listSearchedMemberTable(String account) {
// Skills Resource Assistant ~ method        
         List<DB_member_table> accountList = Model.showMemberTableListByUniqueSearch(account);
         return accountList;
    }

    static boolean ckIsActive(DataBaseUserTable theAccount) {
// Skills Resource Assistant ~ method        
        if (theAccount != null){
        Integer active = theAccount.getIsActive();
        
        if (active == 1){
            return true;
        }} else {
            return false;
        }
         return false;
    }

// check to see is member is active and an administator
    static boolean ckIfActive(boolean admin, boolean memberActive) {
// Skills Resource Assistant ~ method        
        if(memberActive == true && admin == true){
                return true;
            } else {
                return false;
            }
    }

    static List<DB_member_table> listIsActiveMemberTable() {
// Skills Resource Assistant ~ method        
         List<DB_member_table> accountList = Model.showAllActiveDBMemberTable();
         return accountList;
    }

    static DB_member_table findMember(Integer account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             DB_member_table theAccount = Model.showMemberByID(account);
             return theAccount;
         }
    }

    static DataBaseUserTable findAccount(DB_member_table theMember) {
// Skills Resource Assistant ~ method        
        DataBaseUserTable account = Model.accountByMemberNumber(theMember);
        return account;
    }

    static DB_address_table findAddress(DB_member_table theMember) {
// Skills Resource Assistant ~ method        
        DB_address_table address;
        address = Model.AddressByMemberNumber(theMember.getAddressTableMapping());
        return address;
    }

    static String ckForAccountName(DataBaseUserTable account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getAccountName() + "  -  update to: ";
         }
    }

    static String ckForPassword(DataBaseUserTable account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getPassword() + "  -  update to: ";
         }
    }

    static String ckForAdmin(DataBaseUserTable account) {
// Skills Resource Assistant ~ method        
         switch (account.getAdminAccount()){
             case 0:
                 return "  NO  -  update to: ";
             case 1:
                 return "  YES  -  update to: ";
             default:
                 return null;
         }
    }

    static String ckForFirstName(DB_member_table account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getFName() + "  -  update to: ";
         }
    }

    static String ckForMiddleName(DB_member_table account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getMName() + "  -  update to: ";
         }
    }

    static String ckForLastName(DB_member_table account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getLName() + "  -  update to: ";
         }
    }

    static String ckForPhone(DB_member_table account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getPhone() + "  -  update to: ";
         }
    }

    static String ckForPhoneType(DB_member_table account) {
// Skills Resource Assistant ~ method        
         switch (account.getPhoneType()){
             case 1:
                 return "\n Home Phone - update to: ";
             case 2:
                 return "\n Cell Phone - update to: ";
             case 3:
                 return "\n Business Phone - update to: ";
             default:
                 return null;
         }
         
    }

    static String ckForEmail(DB_member_table account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getEmail() + "\nupdate to: ";
         }
    }

    static String ckForStreetAdress(DB_address_table account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getStreetAddress() + "  -  update to: ";
         }
    }

    static String ckForCity(DB_address_table account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getCity() + "  -  update to: ";
         }
    }

    static String ckForState(DB_address_table account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getHomeState() + "  -  update to: ";
         }
    }

    static String ckForZipCode(DB_address_table account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getZipCode() + "  -  update to: ";
         }
    }

    static Integer updateMemberRecord(String aAccountName, String aPassword, String aIsAdmin, String aFirstName, String aMiddelName, String aLastName, String aPhone, Integer aPhoneType, String aEmail, String aStreetAddress, String aCity, String aState, String aZipCode, DataBaseUserTable theOldUser, DB_member_table theOldMember, DB_address_table theOldAddress) {
        DataBaseUserTable theAccount = theOldAccount;
        DB_member_table theMember = theOldMember;
        DB_address_table theAddress = theOldAddress;
        
         if (!aAccountName.isEmpty()){
             theAccount.setAccountName(aAccountName);
         }
         if (!aPassword.isEmpty()){
             theAccount.setPassword(aPassword);
         }
         if (!aIsAdmin.isEmpty()){
             if (aIsAdmin.equalsIgnoreCase("Y")){
                 theAccount.setAdminAccount(1);
             } else {
                 theAccount.setAdminAccount(0);
             }
         }
         if(!aFirstName.isEmpty()){
             theMember.setFName(aFirstName);
         }
         if (!aMiddelName.isEmpty()){
             theMember.setMName(aMiddelName);
         }
         if(!aLastName.isEmpty()){
             theMember.setLName(aLastName);
         }
         if(!aPhone.isEmpty()){
            aPhone = aPhone.replaceAll("[-+.^:,_*]","");
            theMember.setPhone(Long.parseLong(aPhone));
         }  
         if(aPhoneType>0){
             theMember.setPhoneType(aPhoneType);
         }
         if(!aEmail.isEmpty()){
             theMember.setEmail(aEmail);
         }
         if(!aStreetAddress.isEmpty()){
             theAddress.setStreetAddress(aStreetAddress);
         }
         if(!aCity.isEmpty()){
             theAddress.setCity(aCity);
         }
         if(!aState.isEmpty()){
             theAddress.setHomeState(aState);
         }
         if(!aZipCode.isEmpty()){
             theAddress.setZipCode(aZipCode);
         }
         
         Model.updatetheAccount(theAccount);
         Model.updateTheMember(theMember);
         Model.updateTheAddress(theAddress);
         
         return theMember.getMemberID();
    }

    static String printTheFullMemberDetails(DB_member_table theUpdatedMember, DataBaseUserTable theUpdatedUser, DB_address_table theUpdatedAddress) {
         return "\nUpdated account information:\n" +
                 "\nAccount:           " + theUpdatedAccount.getAccountName() + 
                 "\npassword:       " + theUpdatedAccount.getPassword() + 
                 "\nName:           " + theUpdatedMember.getFName() + " " + theUpdatedMember.getMName() + " " + theUpdatedMember.getLName()+
                 "\nPhone:          " + theUpdatedMember.getPhone()+
                 "\nPhone Type:     " + theUpdatedMember.getPhoneType()+
                 "\nE-Mail:         " + theUpdatedMember.getEmail() + 
                 "\nStreet Address: " + theUpdatedAddress.getStreetAddress() + 
                 "\nCity:           " + theUpdatedAddress.getCity() + 
                 "\nState:          " + theUpdatedAddress.getHomeState() + 
                 "\nZip Code:       " + theUpdatedAddress.getZipCode() + 
                 "\n\n\n";
    }

    static String deleteMemberRecords(Integer account, String YESorNO) {
         if (YESorNO.equalsIgnoreCase("Y")){
             DB_member_table aMember = Model.showMemberByID(account);
             Model.deletMembersRecord(aMember);
             return "account Removed!";
         } else {
             return "account Not Removed, Returning to Main Menu";
         }
    }

     private Scanner accountInput = new Scanner(System.in);
    
//    public static void main(String[] args) {}

    static DataBaseUserTable accountLogin(String username, String password) {
// Skills Resource Assistant ~ method        
        DataBaseUserTable account = Model.showAccountByUniqueSearch(username, password);
        if (account != null){
            return account;
        }
        return account;
    }

    static boolean ckAdmin(DataBaseUserTable theAccount) {
// Skills Resource Assistant ~ method        
        if (theAccount != null){
        Integer admin = theAccount.getAdminAccount();
        
        if (admin == 1){
            return true;
        }} else {
            return false;
        }
         return false;
    }

    static void creatAccount(String aAccountName, String aCreatedBy) {
        
             DB_account person = new DB_account();
             person.setAccountName(aAccountName);
             person.setCreatedBy(aCreatedBy);
             person.setCreatedDate(new Date());
             
             Model.insertAccount(person);
    }
    
    static DB_account updateAccount(Integer account){
         if("".equals(account)){
             return null;
         } else{
             DB_account theAccount = Model.showAccountByID(account);
             return theAccount;
         }
    }
    
    static DB_account updatetheAccount(Integer account, String name, String by){
         DB_account person = new DB_account();
         person.setAccountId(account);
         person.setAccountName(name);
         person.setCreatedBy(by);
         person.setCreatedDate(new Date());
             
         Model.updateAccount(person);
         return person;
    }
    
    static List<DB_account> listAccount(){
         List<DB_account> accountList = Model.showAllAccount();
         return accountList;
    }
    
    static List<DB_account> listSearchedAccount(String account){
         List<DB_account> accountList = Model.showAccountListByUniqueSearch(account);
         return accountList;
    }

    static String deleteAccount(Integer account, String YESorNO) {
         if (YESorNO.equalsIgnoreCase("Y")){
             Model.deletAccount(Model.showAccountByID(account));
             return "account Removed!";
         } else {
             return "account Not Removed, Returning to Main Menu";
         }
    }
    
    public static void getMainMenu(){
         DBMainMenu menu = new DBMainMenu();
    }
    
    static String ckForAccount(Integer account, String name){
         if(!"".equals(name)){
             return name;
         } else{
             return theAccount(account);
         }
    }

    
    static String ckForCreatedBy(Integer account, String by){
         if(!"".equals(by)){
             return by;
         } else{
             return theCreatedBy(account);
         }
    }
    
    static void exit(Integer account){
         if(account == 0){
             View.main(null);
        }
    }
    
    static String ckAccount(Integer account){
         if(account == null){
             return "";
         } else{
             return theAccount(account)+" - update to:  ";
         }
    }

    static String ckCreatedBy(Integer account){
         if(account == null){
             return "";
         } else{
             return theCreatedBy(account)+" - update to:  ";
         }
    }

    static String theAccount(Integer account){
         DB_account theAccount = Model.showUserByID(account);
         return theAccount.getAccountname();
    }
    
    static String theCreatedBy(Integer account){
         DB_account theAccount = Model.showAccountByID(account);
         return theAccount.getCreatedBy();
    }

    /**
     * @return the accountInput
     */
    public Scanner getAccountInput() {
         return accountInput;
    }

    /**
     * @param accountInput the userInput to set
     */
    public void setAccountInput(Scanner accountInput) {
         this.accountInput = accountInput;
    }


// THIS IS TESTING AREA
    
    static List<DataBaseUserTable> DBTESTlistAccount(){
         List<DataBaseUserTable> accountList = Model.showAllDBAccounts();
         return accountList;
    }
}