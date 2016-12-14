/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsapp;

import javax.security.auth.login.Configuration;


@SuppressWarnings("depreciation")

/**
 *
 * @author mhodes
 */
public class DataBaseSF {

    private static final SessionFactory sessionFactory;

    static {
        Configuration config = new Configuration();
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        config.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:mysql://gabjames-org-mysql.gabjames.org:3306/cit360_team_e_skills_db");
        config.setProperty("hibernate.connection.username", "teameadmin");
        config.setProperty("hibernate.connection.password", "c!t360T3amE");
        config.setProperty("hibernate.connection.pool_size", "1");
        config.setProperty("hibernate.connection.autocommit", "true");
        config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
        config.setProperty("hibernate.show_sql", "false");
        config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
        config.setProperty("hibernate.current_session_context_class", "thread");

        config.addAnnotatedClass(DataBaseAccount.class);
        config.addAnnotatedClass(DataBaseAccountTable.class);
        config.addAnnotatedClass(DataBaseMembers.class);
        config.addAnnotatedClass(DataBaseAddress.class);
        config.addAnnotatedClass(DataBaseSkills.class);

        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private DataBaseSF(){
    }

}