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
    
    static List<DataBaseAccount> showAllAccount(){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DataBaseAccount as u");
        @SuppressWarnings("unchecked")
        List<DataBaseAccount> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }
    
    static List<DataBaseAccount> showAccountListByUniqueSearch(String account){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("from DataBaseAccount as u where u.username like :searchName");
        accountDB.setParameter("searchName", "%"+account+"%");
        @SuppressWarnings("unchecked")
        List<DataBaseAccount> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }
    
     


    static DataBaseAccountTable showAccountByUniqueSearch(String account, String password){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DataBaseAccountTable as u where u.username = :username and u.password = :password");
        accountDB.setParameter("username", account);
        accountDB.setParameter("password", password);
        DataBaseAccountTable theAccount = (DataBaseAccountTable) accountDB.uniqueResult();
        transaction.commit();
        return theAccount;
    }

    static List<DataBaseAccountTable> showAllDBAccounts(){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DataBaseAccountTable as u");
        @SuppressWarnings("unchecked")
        List<DataBaseAccountTable> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }
    
    
// END of FILE

    static List<DataBaseMembers> showAllDBMemberTable() {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select u from DataBaseMembers as u");
        @SuppressWarnings("unchecked")
        List<DataBaseMembers> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }

    static List<DataBaseMembers> showMemberTableListByUniqueSearch(String account) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("from DataBaseMembers as u where u.FName like :searchName or u.LName like :searchName");
        accountDB.setParameter("searchName", "%"+account+"%");
        @SuppressWarnings("unchecked")
        List<DataBaseMembers> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }

    static List<DataBaseMembers> showAllActiveDBMemberTable() {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select m from DataBaseMembers as m inner join m.memberUser as u where u.isActive = :searchActive");
        accountDB.setParameter("searchActive", 0);
        @SuppressWarnings("unchecked")
        List<DataBaseMembers> accountList = accountDB.list();
        transaction.commit();
        return accountList;
    }

    static void insertAccount(DataBaseAccountTable account, DataBaseMembers member, DataBaseAddress address, Integer id) {
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
    
    static List<DataBaseAddress> newMemberNumber(){
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query memberDB = (Query) session.createQuery("Select u.addressID from DataBaseAddress AS u where u.addressID = (select max(t.addressID) from DataBaseAddress AS t)");
        @SuppressWarnings("unchecked")
        List<DataBaseAddress> memberList = memberDB.list();
        transaction.commit();
        return memberList;
    }

    static DataBaseMembers showMemberByID(Integer account) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select m from DataBaseMembers as m where m.id = :mId");
        accountDB.setParameter("mId", account);
        DataBaseMembers theAccount = (DataBaseMembers) accountDB.uniqueResult();
        transaction.commit();
        return theAccount;
    }

    static DataBaseAddress AddressByMemberNumber(DataBaseAddress theMember) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select a from DataBaseAddress as a where a.addressID = :aId");
        accountDB.setParameter("aId", theMember.getAddressID());
        DataBaseAddress theAddress = (DataBaseAddress) accountDB.uniqueResult();
        transaction.commit();
        return theAddress;
    }

    static DataBaseAccountTable accountByMemberNumber(DataBaseMembers theMember) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query accountDB = (Query) session.createQuery("Select m from DataBaseAccountTable as m where m.memberMapping = :mId");
        accountDB.setParameter("mId", theMember);
        DataBaseAccountTable theAccount = (DataBaseAccountTable) accountDB.uniqueResult();
        transaction.commit();
        return theAccount;
    }


    static void updateTheAccount(DataBaseAccountTable theAccount) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query accountDB = session.createQuery("Select u from DataBaseAccountTable as u where u.id = :uId");
	accountDB.setParameter("uId", theAccount.getAccountID() );
        session.merge(theAccount);
        transaction.commit();
    }

    static void updateTheMember(DataBaseMembers theMember) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query memberDB = session.createQuery("Select m from DataBaseAccount as m where m.id = :mId");
	memberDB.setParameter("mId", theMember.getMemberID());
	session.merge(theMember);
        transaction.commit();
    }

    static void updateTheAddress(DataBaseAddress theAddress) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
	Query addressDB = session.createQuery("Select a from DataBaseAddress as a where a.id = :aId");
	addressDB.setParameter("aId", theAddress.getAddressID());
	session.merge(theAddress);
        transaction.commit();
    }

    static void deletMembersRecord(DataBaseMembers aMember) {
        Session session = DataBaseSF.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
//Address
        Query addressDB = (Query) session.createQuery("DELETE from DataBaseAddress AS a where a = :aId");
        addressDB.setParameter("aId", aMember.getAddressTableMapping());
//account
        Query accountDB = (Query) session.createQuery("DELETE from DataBaseAccountTable as m where m = :uId");
        accountDB.setParameter("uId", aMember.getMemberAccount());
//member
        Query memberDB = (Query) session.createQuery("DELETE from DataBaseAccount where memberID = :mId");
        memberDB.setParameter("mId", aMember.getMemberID());

        accountDB.executeUpdate();
        memberDB.executeUpdate();
        addressDB.executeUpdate();
        
        transaction.commit();
    }
}