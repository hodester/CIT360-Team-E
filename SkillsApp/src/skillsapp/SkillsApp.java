/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsapp;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author mhodes
 */
public class SkillsApp {

    Scanner accountInput = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SkillsApp skillsApp = new SkillsApp();
        boolean stopUsing = false;

        while (!stopUsing) {
            stopUsing = skillsApp.accountLogin();
        }
        System.exit(0);
    }

    private boolean accountLogin() {
        boolean stopUsing = false;

        while (!stopUsing) {
            String accountname = null;
            String password = null;
            Integer account = null;

            System.out.println("Welcom to Skills application");
            System.out.print("Please enter account name: ");
//            accountname = accountInput.nextLine();
//            System.out.print("Please enter password: ");
//            password = accountInput.nextLine();
            boolean isAdmin = Controller.ckAdmin(Controller.accountLogin(accountname, password));
            boolean isMemberActive Controller.ckIsActive(Controller.accountLogin(accountname, password));
            
            isAdmin = Controller.ckIfActive(isAdmin, isMemberActive);

            while (isAdmin && !stopUsing) {
                stopUsing = adminMainMenu();
            }

            while (!isAdmin && !stopUsing) {
                stopUsing = accountMainMenu();
            }
            stopUsing = true;
        }
        return stopUsing;
    }

    private boolean adminMainMenu() {
        boolean stopUsing = false;

        while (!stopUsing) {
            Integer choice = null;

            System.out.println();
            System.out.println("Administrator Main Menu");

            System.out.println(" 1 - Add Account");
            System.out.println(" 2 - List All Account's");
            System.out.println(" 3 - List Account by name search");
            System.out.println(" 4 - List inactive accounts");
            System.out.println(" 5 - Update Account");
            System.out.println(" 6 - Remove Account");
            System.out.println(" 7 - Add account to Skills List");
            System.out.println(" 6 - QUIT");
            System.out.println("Please chose an options");

            while (choice == null) {
                choice = getChoice();
            }

            switch (choice) {

                case 1:
                    VCreatAccount();
                    break;
                case 2:
                    VListAccount();
                    break;
                case 3:
                    VListAccountByName();
                    break;
                case 4:
                    VlistAccountByInActive();
                    break;
                case 5:
                    VEditAccount();
                    break;
                case 6:
                    VHideAccount();
                    break;
                case 7:
                    VAddSkillToAccount();
                    break;
                case 8:
                    stopUsing = true;
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid Entry, please select a valid option.");
                    System.out.println();
                    break;
            }
        }
        return stopUsing;
    }

    private boolean baseAccount() {
        boolean stopUsing = false;

        while (!stopUsing) {
            Integer choice = null;

            System.out.println("Main Menu");
            System.out.println();
            System.out.println("Search Skills List by:");
            System.out.println("----------------------");
            System.out.println(" 1 - Category & Name");
            System.out.println(" 2 - Skill Name");
            System.out.println(" 3 - QUIT");
            System.out.println("Please chose an options");

            while (choice == null) {
                choice = getChoice();
            }

            switch (choice) {
                case 1:
                    VSearchCategoryAndName();
                    break;
                case 2:
                    VSearchSkillName();
                    break;
                case 3:
                    stopUsing = true;
                    break;
                default:
                    System.out.println("\n\nInvalid Entry, please select a valid option.");
            }
        }
        return stopUsing;
    }

    /*
    * Administrator View
     */
    private String VAccountName(DataBaseAccountTable account) {

        System.out.print("Account Name: " + Controller.ckForAccountName(account));
        return accountInput.nextLine();
    }

    private String VPassword(DataBaseAccountTable account) {

        System.out.print("Password:  " + Controller.ckForPassword(account));
        return accountInput.nextLine();
    }

    private String VIsAdmin(DataBaseAccountTable account) {

        System.out.print("Administrator\n(y/n):  " + Controller.ckForAdmin(account));
        return accountInput.nextLine();
    }

    private String VFirstName(DataBaseMembers account) {

        System.out.print("First Name:\n::::  " + Controller.ckForFirstName(account));
        return accountInput.nextLine();
    }

    private String VMiddleName(DataBaseMembers account) {

        System.out.print("Middle Name:\n::::  " + Controller.ckForMiddleName(account));
        return accountInput.nextLine();
    }

    private String VLastName(DataBaseMembers account) {

        System.out.print("Last Name:\n::::  " + Controller.ckForLastName(account));
        return accountInput.nextLine();
    }

    private String VPhone(DataBaseMembers account) {

        System.out.print("Phone Number:\n::::  " + Controller.ckForPhone(account));
        return accountInput.nextLine();
    }

    private Integer VPhoneType(DataBaseMembers account) {

        System.out.print("Phone Type?\n1-Home, 2-cell, 3-business\n::::  " + Controller.ckForPhoneType(account));
        Integer oldNumber = account.getPhoneType();
        Integer number = null;
        while (oldNumber == null) {
            while (number == null) {
                return getChoice();
            }
        }

        try {
            number = Integer.parseInt(accountInput.nextLine());
        } catch (NumberFormatException e) {
            if (number == null) {
                return number = oldNumber;
            } else {
                System.out.println("\n\nInvalid Entry, please select a valid option.");
                return null;
            }
        }

        return number;
    }

    private String VEmail(DataBaseMembers account) {

        System.out.print("Email Address:\n::::  " + Controller.ckForEmail(account));
        return accountInput.nextLine();
    }

    private String VStreetAddress(DataBaseAddress account) {

        System.out.print("Street Address\n::::  " + Controller.ckForStreetAdress(account));
        return accountInput.nextLine();
    }

    private String VCity(DataBaseAddress account) {

        System.out.print("City\n::::  " + Controller.ckForCity(account));
        return accountInput.nextLine();
    }

    private String VState(DataBaseAddress account) {

        System.out.print("State\n::::  " + Controller.ckForState(account));
        return accountInput.nextLine();
    }

    private String VZipCode(DataBaseAddress account) {

        System.out.print("Zip Code\n::::  " + Controller.ckForZipCode(account));
        return accountInput.nextLine();
    }

    private Integer getChoice() {
        Integer numBer = null;
        try {
            numBer = Integer.parseInt(accountInput.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\n\nInvalid Entry, please select a valid option.");
            return null;
        }
        return numBer;
    }

    private void VCreatAccount() {

// METHOD working - See STUB statment for more info
        System.out.println("VCreateRecord() - STUB Needs final touches.");
        System.out.println("Add check for account name in DB before accepting.");
        System.out.println("Add check that phone num is 10 digits");
        System.out.println("Add check that email address is valid format");

        System.out.println("\nTo create a new record\nPlease Enter the following:\n");

        DataBaseAccountTable theAccount = null;
        DataBaseMembers theMember = null;
        DataBaseAddress theAddress = null;

        String aAccountName = VAccountName(theAccount);
        String aPassword = VPassword(theAccount);
        String aIsAdmin = VIsAdmin(theAccount);
        String aFirstName = VFirstName(theMember);
        String aMiddelName = VMiddleName(theMember);
        String aLastName = VLastName(theMember);
        String aPhone = VPhone(theMember);
        Integer aPhoneType = VPhoneType(theMember);
        String aEmail = VEmail(theMember);
        String aStreetAddress = VStreetAddress(theAddress);
        String aCity = VCity(theAddress);
        String aState = VState(theAddress);
        String aZipCode = VZipCode(theAddress);

        Controller.createAccountRecord(aAccountName, aPassword, aIsAdmin, aFirstName, aMiddelName, aLastName, aPhone, aPhoneType, aEmail, aStreetAddress, aCity, aState, aZipCode);
    }

    private void VListAccount() {
// Skills Resource Assistant ~ method
// METHOD COMPLETE
        Iterator<DataBaseMembers> iteratedAccounts = Controller.listMemberTable().iterator();
        System.out.printf("%-10s%-20s%-20s\n", "ID", "First Name", "Last Name");
        System.out.printf("%-10s%-20s%-20s\n", "--", "----------", "---------");
        while (iteratedAccounts.hasNext()) {
            DataBaseMembers account = iteratedAccounts.next();
            System.out.printf("%-10s%-20s%-20s\n", account.getMemberID(), account.getFName(), account.getLName());
        }
    }

    private void VListAccountByName() {

// METHOD working - needs an escape path
        System.out.println("\nPlease enter the name of a account to search for, \nor Enter to return to main menu:");
        String searchedAccount = null;
        try {
            searchedAccount = accountInput.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("\n\nInvalid Entry, please select a valid option.");
            return;
        }

        //NEED to ADD AN ESCAPE PATH
        //Controller.exit(Integer.parseInt(searchedAccount));
        Iterator<DataBaseMembers> iteratedAccounts = Controller.listSearchedMemberTable(searchedAccount).iterator();
        System.out.printf("%-10s%-20s%-20s\n", "ID", "First Name", "Last Name");
        System.out.printf("%-10s%-20s%-20s\n", "--", "----------", "---------");
        while (iteratedAccounts.hasNext()) {
            DataBaseMembers account = iteratedAccounts.next();
            System.out.printf("%-10s%-20s%-20s\n", account.getMemberID(), account.getFName(), account.getLName());
        }
    }

    private void VListAccountByInActive() {

// METHOD COMPLETE
        Iterator<DataBaseMembers> iteratedAccounts = Controller.listIsActiveMemberTable().iterator();
        System.out.printf("%-10s%-20s%-20s\n", "ID", "First Name", "Last Name");
        System.out.printf("%-10s%-20s%-20s\n", "--", "----------", "---------");
        while (iteratedAccounts.hasNext()) {
            DataBaseMembers account = iteratedAccounts.next();
            System.out.printf("%-10s%-20s%-20s\n", account.getMemberID(), account.getFName(), account.getLName());
        }

    }

    private void VEditAccount() {
// Skills Resource Assistant ~ method
// FUTURE UPDATE - Call a new menu to list all account or search by account name

        VListAccount();

        System.out.println("\nPlease select a account to update from the list, or 0 to return to main menu:\n");
        Integer account = null;
        try {
            account = Integer.parseInt(accountInput.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\n\nInvalid Entry, please select a valid option.");
            return;
        }

        Controller.exit(account);

        DataBaseMembers theMember = Controller.findMember(account);
        DataBaseAccountTable theAccount = Controller.findAccount(theMember);
        DataBaseAddress theAddress = Controller.findAddress(theMember);

        System.out.println("\nUpdating: " + theMember.getFName() + " " + theMember.getMName() + " " + theMember.getLName()
                + "\nEnter the corrected Information or press enter to keep the current Information just press Enter....");

        String aAccountName = VAccountName(theAccount);
        String aPassword = VPassword(theAccount);
        String aIsAdmin = VIsAdmin(theAccount);
        String aFirstName = VFirstName(theMember);
        String aMiddelName = VMiddleName(theMember);
        String aLastName = VLastName(theMember);
        String aPhone = VPhone(theMember);
        Integer aPhoneType = VPhoneType(theMember);
        String aEmail = VEmail(theMember);
        String aStreetAddress = VStreetAddress(theAddress);
        String aCity = VCity(theAddress);
        String aState = VState(theAddress);
        String aZipCode = VZipCode(theAddress);

        account = Controller.updateMemberRecord(aAccountName, aPassword, aIsAdmin, aFirstName, aMiddelName, aLastName, aPhone, aPhoneType, aEmail, aStreetAddress, aCity, aState, aZipCode, theAccount, theMember, theAddress);
        DataBaseMembers theUpdatedMember = Controller.findMember(account);
        DataBaseAccountTable theUpdatedAccount = Controller.findAccount(theMember);
        DataBaseAddress theUpdatedAddress = Controller.findAddress(theMember);

        System.out.println(Controller.printTheFullMemberDetails(theUpdatedMember, theUpdatedAccount, theUpdatedAddress) + "\n\n");

    }

    private void VHideAccount() {

        System.out.println("VHideRecord() - STUB Not supported yet.");
//        INSERT INTO `DataBaseAccountTable` (`userID`, `username`, `password`, `adminuser`, `isActive`, `memberID`) VALUES ('1008', 'rierubeirb', 'eriubeirb', '0', '0', '1008');

// Sends to different method that will be depreciated later
        VRemoveMemberRecord();
    }

    private void VRemoveMemberRecord() {

// METHOD COMPLETE
        System.out.println("Member delete account stub, \nthis will not be part of the normal program\n");

        VListAccount();

        System.out.println("\nPlease select a account to Remove from the list,\nor 0 to return to main menu:");

        Integer account = null;

        try {
            account = Integer.parseInt(accountInput.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\n\nInvalid Entry, please select a valid option.");
            return;
        }

        Controller.exit(account);

        System.out.println("Please confirm remove account (Y/N)\nCaution: This can not be undone!");

        String YESorNO = accountInput.nextLine();

        System.out.println("\n" + Controller.deleteMemberRecords(account, YESorNO) + "\n");

    }

    private void VAddSkillToAccount() {

        System.out.println("VAddSkillToAccount() - STUB Not supported yet.");
        System.out.println("This STUB Will utilize JSON");
    }

    /*
    * Account View
     */
    private void VSearchCategoryAndName() {
        System.out.println("VSearchCategoryAndName() - STUB Not supported yet.");
    }

    private void VSearchSkillName() {
        System.out.println("VSearchSkillName() - STUB Not supported yet.");
    }

    /*
    * return
    */
    public boolean adminMainMenu() {
        boolean stopUsing = false;

        while (!stopUsing) {
            Integer choice = null;

            System.out.println();
            System.out.println("Administrator Main Menu");

            // FUTURE PLANNING: place while loop for main menu here
            // and remove unneeded System.out.println()'s
            System.out.println(" 1 - Add account");
            System.out.println(" 2 - List All account's");
            System.out.println(" 3 - List account by name search");
            System.out.println(" 4 - Update account");
            System.out.println(" 5 - Remove account");
            System.out.println(" 6 - QUIT");

            System.out.println("Please make a Selection");

            try {
                choice = Integer.parseInt(accountInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Invalid Entry, please select a valid option.");
                System.out.println();
                return false;
            }

            switch (choice) {

                case 1:
                    VcreateAccount();
                    break;

                case 2:
                    VlistAccount();
                    break;

                case 3:
                    VlistSearchedAccount();
                    break;

                case 4:
                    VupdateAccount();
                    break;

                case 5:
                    VdeleteAccount();
                    break;

                case 6:
                    stopUsing = true;
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid Entry, please select a valid option.");
                    System.out.println();
                    break;

            }

        }

        return stopUsing;

    }

    private void VcreateAccount() {
        Integer account = null;
        System.out.println();
        System.out.println("Please Enter the following");

        String aAccountName = VsystemInputAccountName(account);
        String aCreatedBy = VsystemInputCreatedBy(account);

        Controller.creatAccount(aAccountName, aCreatedBy);
        System.out.println();

    }

    private void VlistAccount() {
        AccountsCurrentlyInDB();
        Iterator<DataBaseAccount> iteratedAccounts = Controller.listAccount().iterator();
        while (iteratedAccounts.hasNext()) {
            DataBaseAccount account = iteratedAccounts.next();
            System.out.printf("%-10s%-20s%-20s%-20s\n", account.getUserId(), account.getUsername(), account.getCreatedBy(), account.getCreatedDate());
        }
    }

    private void VlistSearchedAccount() {
        System.out.println("");
        System.out.println("Please enter the name of a account to search for, or Enter to return to main menu:");
        String searchedAccount = null;
        try {
            searchedAccount = accountInput.nextLine();
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid Entry, please select a valid option.");
            System.out.println();
            return;
        }

        //NEED to ADD AN ESCAPE PATH
        //Controller.exit(Integer.parseInt(searchedAccount));
        AccountsCurrentlyInDB();
        Iterator<DataBaseAccount> iteratedAccounts = Controller.listSearchedAccount(searchedAccount).iterator();
        while (iteratedAccounts.hasNext()) {
            DataBaseAccount account = iteratedAccounts.next();
            System.out.printf("%-10s%-20s%-20s%-20s\n", account.getUserId(), account.getUsername(), account.getCreatedBy(), account.getCreatedDate());
        }
    }

    private void VupdateAccount() {
        String aAccountName = null;
        String aCreatedBy = null;

        VlistAccount();

        System.out.println("");
        System.out.println("Please select a account to update from the list, or 0 to return to main menu:");
        Integer account = null;
        try {
            account = Integer.parseInt(accountInput.nextLine());
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid Entry, please select a valid option.");
            System.out.println();
            return;
        }

        Controller.exit(account);
        DataBaseAccount updateAccount = Controller.updateAccount(account);

        System.out.println("");
        System.out.println("Updating account: " + updateAccount.getUsername());
        System.out.println("");
        System.out.println("Enter the corrected Information or press enter to keep the current Information just press Enter....");

        aAccountName = VsystemInputAccountName(account);
        aCreatedBy = VsystemInputCreatedBy(account);

        Controller.updateTheAccount(account, aAccountName, aCreatedBy);

        System.out.println();
        updateAccount = Controller.updateAccount(account);

        // added the new account lised here
        System.out.println("Updated account information:");
        System.out.println("account:       " + updateAccount.getUsername());
        System.out.println("CREATED_BY: " + updateAccount.getCreatedBy());

        System.out.println();
        System.out.println();

    }

    private void VdeleteAccount() {

        System.out.println("delete account stub");
        VlistAccount();

        System.out.println("");
        System.out.println("Please select a account to Remove from the list, ");
        System.out.println("or 0 to return to main menu:");
        Integer account = null;
        try {
            account = Integer.parseInt(accountInput.nextLine());
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid Entry, please select a valid option.");
            System.out.println();
            return;
        }

        Controller.exit(account);

        System.out.println("Please confirm remove account (Y/N)");
        System.out.println("Caution: This can not be undone!");

        String YESorNO = accountInput.nextLine();

        System.out.println("");
        System.out.println(Controller.deleteAccount(account, YESorNO));
        System.out.println("");
    }

    private String VsystemInputAccountName(Integer account) {
        System.out.print("account Name:       " + Controller.ckUser(account) + "   ");
        String aAccountName = Controller.ckForAccount(account, accountInput.nextLine());
        return aAccountName;
    }

    private String VsystemInputCreatedBy(Integer account) {
        System.out.print("account CREATED_BY: " + Controller.ckCreatedBy(account) + "   ");
        String aCreatedBy = Controller.ckForCreatedBy(account, accountInput.nextLine());
        return aCreatedBy;
    }

    private void AccountsCurrentlyInDB() {
        System.out.println("Accounts currently in Database");
        System.out.printf("%-10s%-20s%-20s%-20s\n", "user_id", "username", "created_by", "created_date");
        System.out.printf("%-10s%-20s%-20s%-20s\n", "+++++++", "++++++++", "++++++++++", "++++++++++++");
        System.out.println();
    }

// THIS IS TESTING AREA
    private boolean DBTESTlistUser() {
        AccountsCurrentlyInDB();
        Iterator<DataBaseAccountTable> iteratedAccounts = Controller.DBTESTlistUser().iterator();
        while (iteratedAccounts.hasNext()) {
            DataBaseAccountTable account = iteratedAccounts.next();
            System.out.printf("%-10s%-20s%-20s\n", account.getUserName(), account.getPassword(), account.getAdminUser());
        }

        return true;
    }

    private boolean accountMainMenu() {
        boolean stopUsing = false;

        while (!stopUsing) {
            Integer choice = null;

            System.out.println();
            System.out.println("Main Menu");

            // FUTURE PLANNING: place while loop for main menu here
            // and remove unneeded System.out.println()'s
            System.out.println(" 1 - List All account's");
            System.out.println(" 2 - List account by name search");
            System.out.println(" 3 - QUIT");

            System.out.println("Please make a Selection");

            try {
                choice = Integer.parseInt(accountInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Invalid Entry, please select a valid option.");
                System.out.println();
                return false;
            }

            switch (choice) {
                case 1:
                    VlistAccount();
                    break;
                case 2:
                    VlistSearchedAccount();
                    break;
                case 3:
                    stopUsing = true;
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid Entry, please select a valid option.");
                    System.out.println();
                    break;
            }
        }
        return stopUsing;
        }
    }