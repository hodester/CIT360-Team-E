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
            //stopUsing = skillsApp.mainMenu();
            stopUsing = skillsApp.accountLogin();
        }

        System.exit(0);

    }

    private boolean accountLogin() {
        boolean stopUsing = false;

        while (!stopUsing) {
            String accountname = null;
            String password = null;

            System.out.println("For testing");
            System.out.println("Administrator Menu access:");
            System.out.println("U: mark3   P: mark3");
            System.out.println();
            System.out.println("User Menu access:");
            System.out.println("U: matt5  P: matt5");
            System.out.println();
            System.out.println();
            System.out.println("Welcom to Skills lister");
            System.out.print("Please enter user name: ");
            accountname = accountInput.nextLine();
            System.out.print("Please enter password: ");
            password = accountInput.nextLine();

            DB_user_table theUser = Controller.accountLogin(accountname, password);
//            boolean isAdmin = Controller.ckAdmin(theUser);
            boolean isAdmin = Controller.ckAdmin(theUser);

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

        String aAccountName = VsystemInputAccountName(account);
        String aCreatedBy = VsystemInputCreatedBy(account);

        Controller.creatAccount(aAccountName, aCreatedBy);
        System.out.println();
    }

    private void VlistAccount() {
        AccountsInDatabase();
        Iterator<DataBaseAccount> iteratedUsers = Controller.listAccount().iterator();
        while (iteratedUsers.hasNext()) {
            DataBaseAccount account = iteratedUsers.next();
            System.out.printf("%-10s%-20s%-20s%-20s\\n", account.getAccountId(), account.getAccountname(), account.getCreatedBy(), account.getCreatedDate());
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

        AccountsInDatabase();
        Iterator<DataBaseAccount> iteratedAccounts = Controller.listSearchedAccount(searchedAccount).iterator();
        while (iteratedAccounts.hasNext()) {
            DataBaseAccount account = iteratedAccounts.next();
            System.out.printf("%-10s%-20s%-20s%-20s\n", account.getAccountId(), account.getAccountname(), account.getCreatedBy(), account.getCreatedDate());
        }
    }

    private void VupdateAccount() {
        String aAccountName = null;
        String aCreatedBy = null;

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
        DataBaseAccount updateAccount = Controller.updateAccount(account);

        System.out.println("");
        System.out.println("Updating Account: " + updateAccount.getAccountname());
        System.out.println("");
        System.out.println("Enter the corrected Information or press enter to keep the current Information just press Enter....");

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
        System.out.println("Caution: Changes are permant and can not be reversed");
        String YESorNO = accountInput.nextLine();

        System.out.println("");
        System.out.println(Controller.deleteAccount(account, YESorNO));
        System.out.println("");
    }

    private String VsystemInputAccountName(Integer account) {
        System.out.print("Account Name:       " + Controller.ckAccount(account) + "   ");
        String aAccountName = Controller.ckForAccount(account, accountInput.nextLine());
        return aAccountName;
    }

    private String VsystemInputCreatedBy(Integer account) {
        System.out.print("Account CREATED_BY: " + Controller.ckCreatedBy(account) + "   ");
        String aCreatedBy = Controller.ckForCreatedBy(account, accountInput.nextLine());
        return aCreatedBy;
    }

    private void AccountsInDatabase() {
        System.out.println("Users currently in Database");
        System.out.printf("%-10s%-20s%-20s%-20s\n", "user_id", "username", "created_by", "created_date");
        System.out.printf("%-10s%-20s%-20s%-20s\n", "+++++++", "++++++++", "++++++++++", "++++++++++++");
        System.out.println();
    }

// THIS IS TESTING AREA
    private boolean DBTESTlistUser() {
        AccountsInDatabase();
        Iterator<DB_user_table> iteratedUsers = Controller.DBTESTlistUser().iterator();
        while (iteratedUsers.hasNext()) {
            DB_user_table user = iteratedUsers.next();
            System.out.printf("%-10s%-20s%-20s%-20s\n", user.getUserName(), user.getPassword(), user.getAdminUser(), user.getMember_ID());
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
            System.out.println(" 1 - List All User's");
            System.out.println(" 2 - List User by name search");
            System.out.println(" 3 - QUIT");

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
                    System.out.println("Invalid Entry, please try again.");
                    System.out.println();
                    break;

            }

        }

        return stopUsing;
    }
}
