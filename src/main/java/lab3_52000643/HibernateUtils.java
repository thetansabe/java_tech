package lab3_52000643;

import lab3_52000643.pojo.Manufacture;
import lab3_52000643.pojo.Phone;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtils {
    private static final SessionFactory FACTORY;
    private static String hostname = "127.0.0.1:3306";
    private static String dbname = "ProductManagement";

    private static String dbUserName = "root";
    private static String dbPassword = "1478963aMysql";

    private static String url = String.format("jdbc:mysql://%s/%s?useSSL=false", hostname, dbname);

    static {
        //create config
        Configuration conf = new Configuration();

        //set config properties
        Properties props = new Properties();

        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, url);
        props.put(Environment.USER, dbUserName);
        props.put(Environment.PASS, dbPassword);
        props.put(Environment.SHOW_SQL, "true");
        props.put(Environment.HBM2DDL_AUTO, "update");
        props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        props.put(Environment.GLOBALLY_QUOTED_IDENTIFIERS, "true");

        conf.setProperties(props);

        //Bao ton tai class Phone va Manufacture
        conf.addAnnotatedClass(Phone.class);
        conf.addAnnotatedClass(Manufacture.class);

        //create factory
        ServiceRegistry registry
                = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties())
                .build();

        FACTORY = conf.buildSessionFactory(registry);
    }

    public static SessionFactory getFactory(){
        return FACTORY;
    }

}
