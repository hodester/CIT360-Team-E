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

    static void createAccountRecord(String aAccountName, String aPassword, String aIsAdmin, 
            String aFirstName, String aMiddelName, String aLastName, String aPhone, 
            Integer aPhoneType, String aEmail, String aStreetAddress, String aCity, 
            String aState, String aZipCode) {
// Skills Resource Assistant ~ method        

        DataBaseAccountTable account = new DataBaseAccountTable();
        DataBaseMembers member = new DataBaseMembers();
        DataBaseAddress address = new DataBaseAddress();
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
        List<DataBaseAddress> query = Model.newMemberNumber();
        int result = Integer.parseInt(query.toString().replace("[", "").replace("]",""))+1;
//        System.out.println("results - "+result);
        return result;
    }

    
    
    static List<DataBaseMembers> listMemberTable() {
// Skills Resource Assistant ~ method        
         List<DataBaseMembers> accountList = Model.showAllDBMemberTable();
         return accountList;
    }

    static List<DataBaseMembers> listSearchedMemberTable(String account) {
// Skills Resource Assistant ~ method        
         List<DataBaseMembers> accountList = Model.showMemberTableListByUniqueSearch(account);
         return accountList;
    }

    static boolean ckIsActive(DataBaseAccountTable theAccount) {
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

    static List<DataBaseMembers> listIsActiveMemberTable() {
// Skills Resource Assistant ~ method        
         List<DataBaseMembers> accountList = Model.showAllActiveDBMemberTable();
         return accountList;
    }

    static DataBaseMembers findMember(Integer account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             DataBaseMembers theAccount = Model.showMemberByID(account);
             return theAccount;
         }
    }

    static DataBaseAccountTable findAccount(DataBaseMembers theMember) {
// Skills Resource Assistant ~ method        
        DataBaseAccountTable account = Model.accountByMemberNumber(theMember);
        return account;
    }

    static DataBaseAddress findAddress(DataBaseMembers theMember) {
// Skills Resource Assistant ~ method        
        DataBaseAddress address;
        address = Model.AddressByMemberNumber(theMember.getAddressTableMapping());
        return address;
    }

    static String ckForAccountName(DataBaseAccountTable account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getAccountName() + "  -  update to: ";
         }
    }

    static String ckForPassword(DataBaseAccountTable account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getPassword() + "  -  update to: ";
         }
    }

    static String ckForAdmin(DataBaseAccountTable account) {
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

    static String ckForFirstName(DataBaseMembers account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getFName() + "  -  update to: ";
         }
    }

    static String ckForMiddleName(DataBaseMembers account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getMName() + "  -  update to: ";
         }
    }

    static String ckForLastName(DataBaseMembers account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getLName() + "  -  update to: ";
         }
    }

    static String ckForPhone(DataBaseMembers account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getPhone() + "  -  update to: ";
         }
    }

    static String ckForPhoneType(DataBaseMembers account) {
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

    static String ckForEmail(DataBaseMembers account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getEmail() + "\nupdate to: ";
         }
    }

    static String ckForStreetAdress(DataBaseAddress account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getStreetAddress() + "  -  update to: ";
         }
    }

    static String ckForCity(DataBaseAddress account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getCity() + "  -  update to: ";
         }
    }

    static String ckForState(DataBaseAddress account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getHomeState() + "  -  update to: ";
         }
    }

    static String ckForZipCode(DataBaseAddress account) {
// Skills Resource Assistant ~ method        
         if("".equals(account)){
             return null;
         } else{
             return account.getZipCode() + "  -  update to: ";
         }
    }

    static Integer updateMemberRecord(String aAccountName, String aPassword, String aIsAdmin, String aFirstName, String aMiddelName, String aLastName, String aPhone, Integer aPhoneType, String aEmail, String aStreetAddress, String aCity, String aState, String aZipCode, DataBaseAccountTable theOldAccount, DataBaseMembers theOldMember, DataBaseAddress theOldAddress) {
        DataBaseAccountTable theAccount = theOldAccount;
        DataBaseMembers theMember = theOldMember;
        DataBaseAddress theAddress = theOldAddress;
        
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
         
         Model.updateTheAccount(theAccount);
         Model.updateTheMember(theMember);
         Model.updateTheAddress(theAddress);
         
         return theMember.getMemberID();
    }

    static String printTheFullMemberDetails(DataBaseMembers theUpdatedMember, DataBaseAccountTable theUpdatedAccount, DataBaseAddress theUpdatedAddress) {
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
             DataBaseMembers aMember = Model.showMemberByID(account);
             Model.deletMembersRecord(aMember);
             return "account Removed!";
         } else {
             return "account Not Removed, Returning to Main Menu";
         }
    }

     private Scanner accountInput = new Scanner(System.in);
    
//    public static void main(String[] args) {}

    static DataBaseAccountTable accountLogin(String accountname, String password) {
// Skills Resource Assistant ~ method        
        DataBaseAccountTable account = Model.showAccountByUniqueSearch(accountname, password);
        if (account != null){
            return account;
        }
        return account;
    }

    static boolean ckAdmin(DataBaseAccountTable theAccount) {
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
        
             DataBaseAccount person = new DataBaseAccount();
             person.setAccountname(aAccountName);
             person.setCreatedBy(aCreatedBy);
             person.setCreatedDate(new Date());
             
             Model.insertAccount(person);
    }
    
    static DataBaseAccount updateAccount(Integer account){
         if("".equals(account)){
             return null;
         } else{
             DataBaseAccount theAccount = Model.showAccountByID(account);
             return theAccount;
         }
    }
    
    static DataBaseAccount updateTheAccount(Integer account, String name, String by){
         DataBaseAccount person = new DataBaseAccount();
         person.setAccountId(account);
         person.setAccountname(name);
         person.setCreatedBy(by);
         person.setCreatedDate(new Date());
             
         Model.updateAccount(person);
         return person;
    }
    
    static List<DataBaseAccount> listAccount(){
         List<DataBaseAccount> accountList = Model.showAllAccount();
         return accountList;
    }
    
    static List<DataBaseAccount> listSearchedAccount(String account){
         List<DataBaseAccount> accountList = Model.showAccountListByUniqueSearch(account);
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
             SkillsApp.main(null);
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
         DataBaseAccount theAccount = Model.showAccountByID(account);
         return theAccount.getAccountname();
    }
    
    static String theCreatedBy(Integer account){
         DataBaseAccount theAccount = Model.showAccountByID(account);
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
    
    static List<DataBaseAccountTable> DBTESTlistAccount(){
         List<DataBaseAccountTable> accountList = Model.showAllDBAccounts();
         return accountList;
    }
}