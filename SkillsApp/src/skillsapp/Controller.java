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

    private Scanner accountInput = new Scanner(System.in);

    static DB_user_table accountLogin(String accountname, String password) {
        DB_user_table account = Model.showAccountByUniqueSearch(accountname);
        //DB_user_table account = Model.showAccountByUniqueSearch(accountName, password);
        if (account != null) {
            return account;
        }
        return account;
    }

    static boolean ckAdmin(DB_user_table theAccount) {
        Integer admin = theAccount.getAdminUser();

        if (admin == 1) {
            return true;
        } else {
            return false;
        }
    }

    static void creatAccount(String aAccountName, String aCreatedBy) {

        DataBaseAccount person = new DataBaseAccount();
        person.setAccountname(aAccountName);
        person.setCreatedBy(aCreatedBy);
        person.setCreatedDate(new Date());

        Model.insertAccount(person);
    }

    static DataBaseAccount updateAccount(Integer account) {
        if ("".equals(account)) {
            return null;
        } else {
            DataBaseAccount theAccount = Model.showAccountByID(account);
            return theAccount;
        }
    }

    static DataBaseAccount updateTheAccount(Integer account, String name, String by) {
        DataBaseAccount person = new DataBaseAccount();
        person.setAccountId(account);
        person.setAccountname(name);
        person.setCreatedBy(by);
        person.setCreatedDate(new Date());

        Model.updateAccount(person);
        return person;

    }

    static List<DataBaseAccount> listAccount() {
        List<DataBaseAccount> accountList = Model.showAllAccounts();
        return accountList;
    }

    static List<DataBaseAccount> listSearchedAccount(String account) {
        List<DataBaseAccount> accountList = Model.showAccountListByUniqueSearch(account);
        return accountList;
    }

    static String deleteAccount(Integer account, String YESorNO) {
        if (YESorNO.equalsIgnoreCase("Y")) {
            Model.deletAccount(Model.showAccountByID(account));
            return "Account Removed!";
        } else {
            return "Account Not Removed, Returning to Main Menu";
        }
    }

    public static void getMainMenu() {
        DBMainMenu menu = new DBMainMenu();
    }

    static String ckForAccount(Integer account, String name) {
        if (!"".equals(name)) {
            return name;
        } else {
            return theAccount(account);
        }
    }

    static String ckForCreatedBy(Integer account, String by) {
        if (!"".equals(by)) {
            return by;
        } else {
            return theCreatedBy(account);
        }
    }

    static void exit(Integer account) {
        if (account == 0) {
            SkillsApp.main(null);
        }
    }

    static String ckAccount(Integer account) {
        if (account == null) {
            return "";
        } else {
            return theAccount(account);
        }
    }

    static String ckCreatedBy(Integer account) {
        if (account == null) {
            return "";
        } else {
            return theCreatedBy(account) + " - update to: ";
        }
    }

    static String theAccount(Integer account) {
        DataBaseAccount theAccount = Model.showAccountByID(account);
        return theAccount.getAccountname();
    }

    static String theCreatedBy(Integer account) {
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
     * @param accountInput the accountInput to set
     */
    public void setAccountInput(Scanner accountInput) {
        this.accountInput = accountInput;
    }

    // THIS IS TESTING AREA
    static List<DB_user_table> DBTESTlistUser() {
        List<DB_user_table> accountList = Model.showAllDBAccounts();
        return accountList;
    }

}
