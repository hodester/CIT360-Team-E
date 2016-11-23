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
     * DBAccount Database functions
     */
    
    static void insertUser(DBAccount account) {
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
    }
    
    static void updateUser(DBAccount updateDB){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query accountDB = session.createQuery("Select u from DBAccount as u where u.id = :uId");
	accountDB.setParameter("uId", updateDB.getUserId());
	session.merge(updateDB);
        transaction.commit();
    }
    
    static void deletUser(DBAccount account){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(account);
        transaction.commit();
    }
    
    static DBAccount showUserByID(Integer account){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DBAccount as u where u.id = :uId");
        accountDB.setParameter("uId", account);
        DBAccount theUser = (DBAccount) accountDB.uniqueResult();
        transaction.commit();
        return theUser;
    }
    
    static List<DBAccount> showAllUsers(){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DBAccount as u");
        @SuppressWarnings("unchecked")
        List<DBAccount> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }
    
    static List<DBAccount> showUserListByUniqueSearch(String account){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("from DBAccount as u where u.accountname like :searchName");
        accountDB.setParameter("searchName", "%"+account+"%");
        @SuppressWarnings("unchecked")
        List<DBAccount> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }
    
     

// NOT working below this line  -  YET
// http://javabeat.net/how-to-use-named-parameters-and-named-query-in-hibernate/

    static DBAccount showUserByUniqueSearch(String account){
        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select * from DBAccount as u where u.accountname like :searchName");
        accountDB.setParameter("searchName", account);
        DBAccount theUser = (DBAccount) accountDB.uniqueResult();
        transaction.commit();
        return theUser;
    }
    
    
//    static List<DBAccount> showUserListByUniqueSearch(String account){
//        Session session = DBSessionFactory.getSessionFactory().getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//String queryStr = "from Student s where s.name like :searchName"; 
//List result = session.createQuery(queryStr) 
//            result.setString("searchName",account); 
//            .list; 
//   
//}
    
}
