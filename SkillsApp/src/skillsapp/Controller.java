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

    public static void main(String[] args) {
    }

    static void creatAccount(String aAccountName, String aCreatedBy) {

        DBAccount person = new DBAccount();
        person.setAccountname(aAccountName);
        person.setCreatedBy(aCreatedBy);
        person.setCreatedDate(new Date());

        Model.insertAccount(person);
    }

    static DBAccount updateAccount(Integer account) {
        if ("".equals(account)) {
            return null;
        } else {
            DBAccount theAccount = Model.showAccountByID(account);
            return theAccount;
        }
    }

    static DBAccount updateTheAccount(Integer account, String name, String by) {
        DBAccount person = new DBAccount();
        person.setAccountId(account);
        person.setAccountname(name);
        person.setCreatedBy(by);
        person.setCreatedDate(new Date());

        Model.updateAccount(person);
        return person;

    }

    static List<DBAccount> listAccount() {
        List<DBAccount> accountList = Model.showAllAccounts();
        return accountList;
    }

    static List<DBAccount> listSearchedAccount(String account) {
        List<DBAccount> accountList = Model.showAccountListByUniqueSearch(account);
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
//            DBAccount theAccount = Model.showAccountByID(account);
//            DBAccount theAccount = updateAccount(account);
//            return theAccount.getAccountname();

// this line makes this ACP compliant
            return theAccount(account);
        }
    }

    static String ckForCreatedBy(Integer account, String by) {
        if (!"".equals(by)) {
            return by;
        } else {
//            DBAccount theAccount = Model.showAccountByID(account);
//            DBAccount theAccount = updateAccount(account);
//            return theAccount.getCreatedBy();

// This line makes this ACP compliant
            return theCreatedBy(account);
        }
    }

    static void exit(Integer account) {
        if (account == 0) {
            View.main(null);
        }
    }

    static String ckAccount(Integer account) {
        if (account == null) {
            return "";
        } else {
//            DBAccount theAccount = Model.showAccountByID(account);
//            return theAccount.getAccountname();
//This makes these ACP compliant
            return theAccount(account);
        }
    }

    static String ckCreatedBy(Integer account) {
        if (account == null) {
            return "";
        } else {
//            DBAccount theAccount = Model.showAccountByID(account);
//            return theAccount.getCreatedBy();
//This makes these ACP compliant
            return theCreatedBy(account);
        }
    }

    static String theAccount(Integer account) {
        DBAccount theAccount = Model.showAccountByID(account);
        return theAccount.getAccountname();
    }

    static String theCreatedBy(Integer account) {
        DBAccount theAccount = Model.showAccountByID(account);
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

}
