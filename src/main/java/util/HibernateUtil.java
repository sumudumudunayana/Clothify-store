package util;

import entity.CustomerEntity;
import entity.EmployeeEntity;
import entity.ItemEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory employeeSession = createEmployeeSession();

    private static SessionFactory createEmployeeSession() {
        StandardServiceRegistry build = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(build)
                .addAnnotatedClass(EmployeeEntity.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();
        return metadata.getSessionFactoryBuilder().build();
    }
    public static Session getEmployeeSession(){
        return employeeSession.openSession();
    }



    private static final SessionFactory itemSession=createItemSession();

    private static SessionFactory createItemSession() {
        StandardServiceRegistry build=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(build)
                .addAnnotatedClass(ItemEntity.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();
        return metadata.getSessionFactoryBuilder().build();
    }

    public static Session getItemSession(){
        return itemSession.openSession();
    }


    public static Session getOrderSession() {
        return null;
    }
}
