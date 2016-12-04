/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skillsapp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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

        config.addAnnotatedClass(DB_account.class);
        config.addAnnotatedClass(DataBaseUserTable.class);
        config.addAnnotatedClass(DB_member_table.class);
        config.addAnnotatedClass(DB_address_table.class);
        config.addAnnotatedClass(DB_skills_table.class);

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
