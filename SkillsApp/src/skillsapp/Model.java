/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsapp;

import static java.util.Collections.list;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author mhodes
 */
public class Model {
    /*
     * DataBaseAccount Database functions
     */
    
    static void insertAccount(DataBaseAccount account) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
    }
    
    static void updateAccount(DataBaseAccount updateDB){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query accountDB = session.createQuery("Select u from DataBaseAccount as u where u.id = :uId");
	accountDB.setParameter("uId", updateDB.getAccountId());
	session.merge(updateDB);
        transaction.commit();
    }
    
    static void deletAccount(DataBaseAccount account){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(account);
        transaction.commit();
    }
    
    static DataBaseAccount showAccountByID(Integer account){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DataBaseAccount as u where u.id = :uId");
        accountDB.setParameter("uId", account);
        DataBaseAccount theAccount = (DataBaseAccount) accountDB.uniqueResult();
        transaction.commit();
        return theAccount;
    }
    
    static List<DataBaseAccount> showAllAccounts(){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DB_user as u");
        @SuppressWarnings("unchecked")
        List<DataBaseAccount> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }
    
    static List<DataBaseAccount> showAccountListByUniqueSearch(String account){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("from DB_User as u where u.username like :account");
        accountDB.setParameter("account", "%"+account+"%");
        @SuppressWarnings("unchecked")
        List<DataBaseAccount> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }
    
     

// NOT working below this line  -  YET
// http://javabeat.net/how-to-use-named-parameters-and-named-query-in-hibernate/

    static DB_user_table showAccountByUniqueSearch(String account, String password){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DB_user_table as u where u.accountName = :account and u.password = :password");
        accountDB.setParameter("account", account);
        accountDB.setParameter("password", password);
        DB_user_table theAccount = (DB_user_table) accountDB.uniqueResult();
        transaction.commit();
        return theAccount;
    }
    
    static List<DB_user_table> showAllDBAccounts(){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query userDB = (Query) session.createQuery("Select u from DB_user_table as u");
        @SuppressWarnings("unchecked")
        List<DB_user_table> userList = userDB.list();
        transaction.commit();
        return userList;
    }
}
