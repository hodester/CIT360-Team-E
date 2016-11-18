/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsapp;

import java.util.Iterator;
import java.util.List;
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
            stopUsing = skillsApp.mainMenu();
        }

        System.exit(0);

    }

    private boolean mainMenu() {
        boolean stopUsing = false;

        while (!stopUsing) {
            Integer choice = null;

            System.out.println();
            System.out.println("Main Menu");

            // place while loop for main menu here
            // and remove unneeded System.out.println()'s
            System.out.println(" 1 - Add Account");
            System.out.println(" 2 - List All Account's");
            System.out.println(" 3 - List Account by name search");
            System.out.println(" 4 - Update Account");
            System.out.println(" 5 - Remove Account");
            System.out.println(" 6 - QUIT");

            System.out.println("Please make a Selection");

            try {
                choice = Integer.parseInt(accountInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Invalid Entry, please try again.");
                System.out.println();
                return false;
            }

            switch (choice) {

                case 1:
                    VcreatAccount();
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
                    System.out.println("Invalid Entry, please try again.");
                    System.out.println();
                    break;

            }

        }

        return stopUsing;

    }

    private void VcreatAccount() {
        Integer account = null;
        System.out.println();
        System.out.println("Please Enter the following");

// The following code was change to add ACP compliance to the program 
//        System.out.print("Account Name:  ");
//        String aAccountName = accountInput.nextLine();
//        System.out.print("Created By:  ");
//        String aCreatedBy = accountInput.nextLine();
// The following was added for ACP compliance
        String aAccountName = VsystemInputAccountName(account);
        String aCreatedBy = VsystemInputCreatedBy(account);

        Controller.creatAccount(aAccountName, aCreatedBy);
        System.out.println();

    }

    private void VlistAccount() {

        System.out.println("Accounts currently in Database");
        System.out.printf("%-10s%-20s%-20s%-20s\n", "account_id", "accountname", "created_by", "created_date");
        System.out.printf("%-10s%-20s%-20s%-20s\n", "+++++++", "++++++++", "++++++++++", "++++++++++++");
        System.out.println();

        Iterator<DBAccount> iteratedAccounts = Controller.listAccount().iterator();

        while (iteratedAccounts.hasNext()) {
            DBAccount account = iteratedAccounts.next();
            System.out.printf("%-10s%-20s%-20s%-20s\n", account.getAccountId(), account.getAccountname(), account.getCreatedBy(), account.getCreatedDate());
        }
    }

    private void VlistSearchedAccount() {

        System.out.println("");
        System.out.println("Please enter the name of a account to search for, or Enter to return to the Main Menu:");
        String searchedAccount = null;
        try {
            searchedAccount = accountInput.nextLine();
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid Entry, please try again.");
            System.out.println();
            return;
        }

//NEED to ADD AN ESCAPE PATH
        //Controller.exit(Integer.parseInt(searchedAccount));
        System.out.println("Accounts currently in Database");
        System.out.printf("%-10s%-20s%-20s%-20s\n", "account_id", "accountname", "created_by", "created_date");
        System.out.printf("%-10s%-20s%-20s%-20s\n", "+++++++", "++++++++", "++++++++++", "++++++++++++");
        System.out.println();

//         Iterator<DBAccount> iteratedAccounts = Controller.listAccount().iterator();
        Iterator<DBAccount> iteratedAccounts = Controller.listSearchedAccount(searchedAccount).iterator();

        while (iteratedAccounts.hasNext()) {
            DBAccount account = iteratedAccounts.next();
            System.out.printf("%-10s%-20s%-20s%-20s\n", account.getAccountId(), account.getAccountname(), account.getCreatedBy(), account.getCreatedDate());
        }
    }

    private void VupdateAccount() {
        String aAccountName = null;
        String aCreatedBy = null;

//    System.out.println("update account stub");
        VlistAccount();

        System.out.println("");
        System.out.println("Please select a Account to update from the list, or 0 to return to main menu:");
        Integer account = null;
        try {
            account = Integer.parseInt(accountInput.nextLine());
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid Entry, please try again.");
            System.out.println();
            return;
        }

        Controller.exit(account);
        DBAccount updateAccount = Controller.updateAccount(account);

        System.out.println("");
        System.out.println("Updating Account: " + updateAccount.getAccountname());
        System.out.println("");
        System.out.println("Enter the corrected Information or press enter to keep the current Information just press Enter....");

// The following code was change to add ACP compliance to the program 
//    System.out.println("Account Name:       " + updateAccount.getAccountname());
//    System.out.print("new Account Name:   ");
//    aAccountName = Controller.ckForAccount(account,accountInput.nextLine());
//    System.out.println("Account CREATED_BY: " + updateAccount.getCreatedBy());
//    System.out.print("new CREATED_BY:  ");
//    aCreatedBy = Controller.ckForCreatedBy(account,accountInput.nextLine());
// add a confirm info is correst here
// to do that right the 16 lines above will need ot be moved 
// to a new method and called as a package
// IF done right the Add account could also call this method
// and the skillsApp would become ACP compliant 
// The following was added for ACP compliance
        aAccountName = VsystemInputAccountName(account);
        aCreatedBy = VsystemInputCreatedBy(account);

        Controller.updateTheAccount(account, aAccountName, aCreatedBy);

        System.out.println();
        updateAccount = Controller.updateAccount(account);

// added the new account lised here
        System.out.println("Updated Account information:");
        System.out.println("Account:       " + updateAccount.getAccountname());
        System.out.println("CREATED_BY: " + updateAccount.getCreatedBy());

        System.out.println();
        System.out.println();

    }

    private void VdeleteAccount() {

        System.out.println("delete account stub");
        VlistAccount();

        System.out.println("");
        System.out.println("Please select a Account to Remove from the list, ");
        System.out.println("or 0 to return to main menu:");
        Integer account = null;
        try {
            account = Integer.parseInt(accountInput.nextLine());
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid Entry, please try again.");
            System.out.println();
            return;
        }

        Controller.exit(account);

        System.out.println("Please confirm remove USER (Y/N)");
        System.out.println("Caution: This can not be undone!");
        String YESorNO = accountInput.nextLine();

//    String Happened = Controller.deleteAccount(account,YESorNO);
        System.out.println("");
        System.out.println(Controller.deleteAccount(account, YESorNO));
        System.out.println("");

    }

// THESE ARE NOT FULLY WORKING
// changing code to ACP compliance
    private String VsystemInputAccountName(Integer account) {
//    DBAccount updateAccount = Controller.updateAccount(account);

        System.out.print("Account Name:       " + Controller.ckAccount(account) + "   ");
        String aAccountName = Controller.ckForAccount(account, accountInput.nextLine());
        return aAccountName;
    }

    private String VsystemInputCreatedBy(Integer account) {
//    DBAccount updateAccount = Controller.updateAccount(account);

        System.out.print("Account CREATED_BY: " + Controller.ckCreatedBy(account) + "   ");
        String aCreatedBy = Controller.ckForCreatedBy(account, accountInput.nextLine());

        return aCreatedBy;
    }

}
