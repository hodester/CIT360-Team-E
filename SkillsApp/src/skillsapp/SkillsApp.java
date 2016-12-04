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
            boolean isMemberActive Controller.ckIsActive(Controller.accountLogin(accountname, password))
            :
            
            isAdmin = Controller.chIfActive(isAdmin, isMemberActive);

//            DataBaseUserTable theUser = Controller.accountLogin(accountname, password);
////            boolean isAdmin = Controller.ckAdmin(theUser);
//            boolean isAdmin = Controller.ckAdmin(theUser);
            while (isAdmin && !stopUsing) {
                stopUsing = adminMainMenu();
            }

            while (!isAdmin && !stopUsing) {
                stopUsing = userMainMenu();
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
                    VcreatAccount();
                    break;
                case 2:
                    VlistAccount();
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

    private boolean baseUser() {
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
    private String VUserName(DataBaseUserTable account) {

        System.out.print("Account Name: " + Control.ckForUserName(account));
        return accountInput.nextLine();
    }

    private String VPassword(DataBaseUserTable account) {

        System.out.print("Password:  " + Control.ckForPassword(account));
        return accountInput.nextLine();
    }

    private String VIsAdmin(DataBaseUserTable account) {

        System.out.print("Administrator\n(y/n):  " + Control.ckForAdmin(account));
        return accountInput.nextLine();
    }

    private String VFirstName(DB_member_table account) {

        System.out.print("First Name:\n::::  " + Control.ckForFirstName(account));
        return accountInput.nextLine();
    }

    private String VMiddleName(DB_member_table account) {

        System.out.print("Middle Name:\n::::  " + Control.ckForMiddleName(account));
        return accountInput.nextLine();
    }

    private String VLastName(DB_member_table account) {

        System.out.print("Last Name:\n::::  " + Control.ckForLastName(account));
        return accountInput.nextLine();
    }

    private String VPhone(DB_member_table account) {

        System.out.print("Phone Number:\n::::  " + Control.ckForPhone(account));
        return accountInput.nextLine();
    }

    private Integer VPhoneType(DB_member_table account) {

        System.out.print("Phone Type?\n1-Home, 2-cell, 3-business\n::::  " + Control.ckForPhoneType(account));
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

    private String VEmail(DB_member_table account) {

        System.out.print("Email Address:\n::::  " + Control.ckForEmail(account));
        return accountInput.nextLine();
    }

    private String VStreetAddress(DB_address_table account) {

        System.out.print("Street Address\n::::  " + Control.ckForStreetAdress(account));
        return accountInput.nextLine();
    }

    private String VCity(DB_address_table account) {

        System.out.print("City\n::::  " + Control.ckForCity(account));
        return accountInput.nextLine();
    }

    private String VState(DB_address_table account) {

        System.out.print("State\n::::  " + Control.ckForState(account));
        return accountInput.nextLine();
    }

    private String VZipCode(DB_address_table account) {

        System.out.print("Zip Code\n::::  " + Control.ckForZipCode(account));
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

    private void VCreateRecord() {

// METHOD working - See STUB statment for more info
        System.out.println("VCreateRecord() - STUB Needs final touches.");
        System.out.println("Add check for account name in DB before accepting.");
        System.out.println("Add check that phone num is 10 digits");
        System.out.println("Add check that email address is valid format");

        System.out.println("\nTo create a new record\nPlease Enter the following:\n");

        DataBaseUserTable theAccount = null;
        DB_member_table theMember = null;
        DB_address_table theAddress = null;

        String aUserName = VUserName(theUser);
        String aPassword = VPassword(theUser);
        String aIsAdmin = VIsAdmin(theUser);
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

        Control.creatUserRecord(aUserName, aPassword, aIsAdmin, aFirstName, aMiddelName, aLastName, aPhone, aPhoneType, aEmail, aStreetAddress, aCity, aState, aZipCode);
    }

    private void VListAllUser() {
// Skills Resource Assistant ~ method
// METHOD COMPLETE
        Iterator<DB_member_table> iteratedUsers = Control.listMemberTable().iterator();
        System.out.printf("%-10s%-20s%-20s\n", "ID", "First Name", "Last Name");
        System.out.printf("%-10s%-20s%-20s\n", "--", "----------", "---------");
        while (iteratedUsers.hasNext()) {
            DB_member_table account = iteratedUsers.next();
            System.out.printf("%-10s%-20s%-20s\n", account.getMemberID(), account.getFName(), account.getLName());
        }
    }

    private void VListUserByName() {

// METHOD working - needs an escape path
        System.out.println("\nPlease enter the name of a account to search for, \nor Enter to return to main menu:");
        String searchedUser = null;
        try {
            searchedUser = accountInput.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("\n\nInvalid Entry, please select a valid option.");
            return;
        }

        //NEED to ADD AN ESCAPE PATH
        //Control.exit(Integer.parseInt(searchedUser));
        Iterator<DB_member_table> iteratedUsers = Control.listSearchedMemberTable(searchedUser).iterator();
        System.out.printf("%-10s%-20s%-20s\n", "ID", "First Name", "Last Name");
        System.out.printf("%-10s%-20s%-20s\n", "--", "----------", "---------");
        while (iteratedUsers.hasNext()) {
            DB_member_table account = iteratedUsers.next();
            System.out.printf("%-10s%-20s%-20s\n", account.getMemberID(), account.getFName(), account.getLName());
        }
    }

    private void VListUserByInActive() {

// METHOD COMPLETE
        Iterator<DB_member_table> iteratedUsers = Control.listIsActiveMemberTable().iterator();
        System.out.printf("%-10s%-20s%-20s\n", "ID", "First Name", "Last Name");
        System.out.printf("%-10s%-20s%-20s\n", "--", "----------", "---------");
        while (iteratedUsers.hasNext()) {
            DB_member_table account = iteratedUsers.next();
            System.out.printf("%-10s%-20s%-20s\n", account.getMemberID(), account.getFName(), account.getLName());
        }

    }

    private void VEditRecord() {
// Skills Resource Assistant ~ method
// FUTURE UPDATE - Call a new menu to list all account or search by account name

        VListAllUser();

        System.out.println("\nPlease select a account to update from the list, or 0 to return to main menu:\n");
        Integer account = null;
        try {
            account = Integer.parseInt(accountInput.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\n\nInvalid Entry, please select a valid option.");
            return;
        }

        Control.exit(account);

        DB_member_table theMember = Control.findMember(account);
        DataBaseUserTable theUser = Control.findUser(theMember);
        DB_address_table theAddress = Control.findAddress(theMember);

        System.out.println("\nUpdating: " + theMember.getFName() + " " + theMember.getMName() + " " + theMember.getLName()
                + "\nEnter the corrected Information or press enter to keep the current Information just press Enter....");

        String aUserName = VUserName(theUser);
        String aPassword = VPassword(theUser);
        String aIsAdmin = VIsAdmin(theUser);
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

        account = Control.updateMemberRecord(aUserName, aPassword, aIsAdmin, aFirstName, aMiddelName, aLastName, aPhone, aPhoneType, aEmail, aStreetAddress, aCity, aState, aZipCode, theUser, theMember, theAddress);
        DB_member_table theUpdatedMember = Control.findMember(account);
        DataBaseUserTable theUpdatedUser = Control.findUser(theMember);
        DB_address_table theUpdatedAddress = Control.findAddress(theMember);

        System.out.println(Control.printTheFullMemberDetails(theUpdatedMember, theUpdatedUser, theUpdatedAddress) + "\n\n");

    }

    private void VHideRecord() {

        System.out.println("VHideRecord() - STUB Not supported yet.");
//        INSERT INTO `DataBaseUserTable` (`userID`, `username`, `password`, `adminuser`, `isActive`, `memberID`) VALUES ('1008', 'rierubeirb', 'eriubeirb', '0', '0', '1008');

// Sends to different method that will be depreciated later
        VRemoveMemberRecord();
    }

    private void VRemoveMemberRecord() {

// METHOD COMPLETE
        System.out.println("Member delete account stub, \nthis will not be part of the normal program\n");

        VListAllUser();

        System.out.println("\nPlease select a account to Remove from the list,\nor 0 to return to main menu:");

        Integer account = null;

        try {
            account = Integer.parseInt(accountInput.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("\n\nInvalid Entry, please select a valid option.");
            return;
        }

        Control.exit(account);

        System.out.println("Please confirm remove account (Y/N)\nCaution: This can not be undone!");

        String YESorNO = accountInput.nextLine();

        System.out.println("\n" + Control.deleteMemberRecords(account, YESorNO) + "\n");

    }

    private void VaddSkillToUser() {

        System.out.println("VaddSkillToUser() - STUB Not supported yet.");
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
                    VcreatUser();
                    break;

                case 2:
                    VlistUser();
                    break;

                case 3:
                    VlistSearchedUser();
                    break;

                case 4:
                    VupdateUser();
                    break;

                case 5:
                    VdeleteUser();
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

    private void VcreatUser() {
        Integer account = null;
        System.out.println();
        System.out.println("Please Enter the following");

        String aUserName = VsystemInputUserName(account);
        String aCreatedBy = VsystemInputCreatedBy(account);

        Control.creatUser(aUserName, aCreatedBy);
        System.out.println();

    }

    private void VlistUser() {
        UsersCurrentlyInDatabase();
        Iterator<DB_user> iteratedUsers = Control.listUser().iterator();
        while (iteratedUsers.hasNext()) {
            DB_user account = iteratedUsers.next();
            System.out.printf("%-10s%-20s%-20s%-20s\n", account.getUserId(), account.getUsername(), account.getCreatedBy(), account.getCreatedDate());
        }
    }

    private void VlistSearchedUser() {
        System.out.println("");
        System.out.println("Please enter the name of a account to search for, or Enter to return to main menu:");
        String searchedUser = null;
        try {
            searchedUser = accountInput.nextLine();
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid Entry, please select a valid option.");
            System.out.println();
            return;
        }

        //NEED to ADD AN ESCAPE PATH
        //Control.exit(Integer.parseInt(searchedUser));
        UsersCurrentlyInDatabase();
        Iterator<DB_user> iteratedUsers = Control.listSearchedUser(searchedUser).iterator();
        while (iteratedUsers.hasNext()) {
            DB_user account = iteratedUsers.next();
            System.out.printf("%-10s%-20s%-20s%-20s\n", account.getUserId(), account.getUsername(), account.getCreatedBy(), account.getCreatedDate());
        }
    }

    private void VupdateUser() {
        String aUserName = null;
        String aCreatedBy = null;

        VlistUser();

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

        Control.exit(account);
        DB_user updateUser = Control.updateUser(account);

        System.out.println("");
        System.out.println("Updating account: " + updateUser.getUsername());
        System.out.println("");
        System.out.println("Enter the corrected Information or press enter to keep the current Information just press Enter....");

        aUserName = VsystemInputUserName(account);
        aCreatedBy = VsystemInputCreatedBy(account);

        Control.updateTheUser(account, aUserName, aCreatedBy);

        System.out.println();
        updateUser = Control.updateUser(account);

        // added the new account lised here
        System.out.println("Updated account information:");
        System.out.println("account:       " + updateUser.getUsername());
        System.out.println("CREATED_BY: " + updateUser.getCreatedBy());

        System.out.println();
        System.out.println();

    }

    private void VdeleteUser() {

        System.out.println("delete account stub");
        VlistUser();

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

        Control.exit(account);

        System.out.println("Please confirm remove account (Y/N)");
        System.out.println("Caution: This can not be undone!");

        String YESorNO = accountInput.nextLine();

        System.out.println("");
        System.out.println(Control.deleteUser(account, YESorNO));
        System.out.println("");
    }

    private String VsystemInputUserName(Integer account) {
        System.out.print("account Name:       " + Control.ckUser(account) + "   ");
        String aUserName = Control.ckForUser(account, accountInput.nextLine());
        return aUserName;
    }

    private String VsystemInputCreatedBy(Integer account) {
        System.out.print("account CREATED_BY: " + Control.ckCreatedBy(account) + "   ");
        String aCreatedBy = Control.ckForCreatedBy(account, accountInput.nextLine());
        return aCreatedBy;
    }

    private void UsersCurrentlyInDatabase() {
        System.out.println("Users currently in Database");
        System.out.printf("%-10s%-20s%-20s%-20s\n", "user_id", "username", "created_by", "created_date");
        System.out.printf("%-10s%-20s%-20s%-20s\n", "+++++++", "++++++++", "++++++++++", "++++++++++++");
        System.out.println();
    }

// THIS IS TESTING AREA
    private boolean DBTESTlistUser() {
        UsersCurrentlyInDatabase();
        Iterator<DataBaseUserTable> iteratedUsers = Control.DBTESTlistUser().iterator();
        while (iteratedUsers.hasNext()) {
            DataBaseUserTable account = iteratedUsers.next();
            System.out.printf("%-10s%-20s%-20s\n", account.getUserName(), account.getPassword(), account.getAdminUser());
        }

        return true;
    }

    private boolean userMainMenu() {
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
                    VlistUser();
                    break;

                case 2:
                    VlistSearchedUser();
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
