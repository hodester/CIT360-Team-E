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

public class Model{
    /*
     * DB_Account Database functions
     */

    static void insertAccount(DB_Account account) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(account);
        transaction.commit();
    }
    
    static void updateAccount(DB_Account accountDB){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query accountDB = session.createQuery("Select u from DB_Account as u where u.id = :uId");
	accountDB.setParameter("uId", accountDB.getAccountId());
	session.merge(accountDB);
        transaction.commit();
    }
    
    static void deletAccount(DB_Account account){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(account);
        transaction.commit();
    }
    
    static DB_Account showAccountByID(Integer account){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DB_Account as u where u.id = :uId");
        accountDB.setParameter("uId", account);
        DB_Account theAccount = (DB_Account) accountDB.uniqueResult();
        transaction.commit();
        return theAccount;
    }
    
    static List<DB_Account> showAllAccount(){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DB_Account as u");
        @SuppressWarnings("unchecked")
        List<DB_Account> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }
    
    static List<DB_Account> showAccountListByUniqueSearch(String account){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("from DB_Account as u where u.username like :searchName");
        accountDB.setParameter("searchName", "%"+account+"%");
        @SuppressWarnings("unchecked")
        List<DB_Account> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }
    
     


    static DataBaseUserTable showAccountByUniqueSearch(String account, String password){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DB_user_table as u where u.accountName = :username and u.password = :password");
        accountDB.setParameter("username", account);
        accountDB.setParameter("password", password);
        DataBaseUserTable theAccount = (DataBaseUserTable) accountDB.uniqueResult();
        transaction.commit();
        return theAccount;
    }

    static List<DataBaseUserTable> showAllDBAccounts(){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DB_user_table as u");
        @SuppressWarnings("unchecked")
        List<DataBaseUserTable> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }
    
    
// END of FILE

    static List<DB_member_table> showAllDBMemberTable() {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DB_member_table as u");
        @SuppressWarnings("unchecked")
        List<DB_member_table> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }

    static List<DB_member_table> showMemberTableListByUniqueSearch(String account) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("from DB_member_table as u where u.FName like :searchName or u.LName like :searchName");
        accountDB.setParameter("searchName", "%"+account+"%");
        @SuppressWarnings("unchecked")
        List<DB_member_table> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }

    static List<DB_member_table> showAllActiveDBMemberTable() {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select m from DB_member_table as m inner join m.memberUser as u where u.isActive = :searchActive");
        accountDB.setParameter("searchActive", 0);
        @SuppressWarnings("unchecked")
        List<DB_member_table> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }

    static void insertAccount(DataBaseUserTable account, DB_member_table member, DB_address_table address, Integer id) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

// address
        session.save(address);

//member
        session.save(member);

//account
        session.save(account);

        transaction.commit();        
    }
    
    static List<DB_address_table> newMemberNumber(){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query memberDB = (Query) session.createQuery("Select u.addressID from DB_address_table AS u where u.addressID = (select max(t.addressID) from DB_address_table AS t)");
        @SuppressWarnings("unchecked")
        List<DB_address_table> memberList = memberDB.list();
        transaction.commit();
        return memberList;
    }

    static DB_member_table showMemberByID(Integer account) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select m from DB_member_table as m where m.id = :mId");
        accountDB.setParameter("mId", account);
        DB_member_table theAccount = (DB_member_table) accountDB.uniqueResult();
        transaction.commit();
        return theAccount;
    }

    static DB_address_table AddressByMemberNumber(DB_address_table theMember) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select a from DB_address_table as a where a.addressID = :aId");
        accountDB.setParameter("aId", theMember.getAddressID());
        DB_address_table theAddress = (DB_address_table) accountDB.uniqueResult();
        transaction.commit();
        return theAddress;
    }

    static DataBaseUserTable accountByMemberNumber(DB_member_table theMember) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select m from DB_user_table as m where m.memberMapping = :mId");
        accountDB.setParameter("mId", theMember);
        DataBaseUserTable theAccount = (DataBaseUserTable) accountDB.uniqueResult();
        transaction.commit();
        return theAccount;
    }


    static void updateTheAccount(DataBaseUserTable theAccount) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query accountDB = session.createQuery("Select u from DB_user_table as u where u.id = :uId");
	accountDB.setParameter("uId", theAccount.getAccountID() );
        session.merge(theAccount);
        transaction.commit();
    }

    static void updateTheMember(DB_member_table theMember) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query memberDB = session.createQuery("Select m from DB_member_table as m where m.id = :mId");
	memberDB.setParameter("mId", theMember.getMemberID());
	session.merge(theMember);
        transaction.commit();
    }

    static void updateTheAddress(DB_address_table theAddress) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query addressDB = session.createQuery("Select a from DB_address_table as a where a.id = :aId");
	addressDB.setParameter("aId", theAddress.getAddressID());
	session.merge(theAddress);
        transaction.commit();
    }

    static void deletMembersRecord(DB_member_table aMember) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
//Address
        Query addressDB = (Query) session.createQuery("DELETE from DB_address_table AS a where a = :aId");
        addressDB.setParameter("aId", aMember.getAddressTableMapping());
//account
        Query accountDB = (Query) session.createQuery("DELETE from DB_user_table as m where m = :uId");
        accountDB.setParameter("uId", aMember.getMemberAccount());
//member
        Query memberDB = (Query) session.createQuery("DELETE from DB_member_table where memberID = :mId");
        memberDB.setParameter("mId", aMember.getMemberID());

        accountDB.executeUpdate();
        memberDB.executeUpdate();
        addressDB.executeUpdate();
        
        
        transaction.commit();
    }

// NOT working below this line  -  YET
// http://javabeat.net/how-to-use-named-parameters-and-named-query-in-hibernate/
    
    
}