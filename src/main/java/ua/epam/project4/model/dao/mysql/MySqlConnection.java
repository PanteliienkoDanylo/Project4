package ua.epam.project4.model.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySqlConnection {

    public static final String PROP_FILE_PATH = "db.properties";
    public static final String PROP_FILE_DB_URL = "db.url";
    public static final String PROP_FILE_DB_USER = "db.user";
    public static final String PROP_FILE_DB_PASS = "db.pass";
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    private static MySqlConnection instance;

    private Connection connection;

    private MySqlConnection(){
        Properties dbProp = new Properties();
        try {
            dbProp.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROP_FILE_PATH));
            Class.forName(JDBC_DRIVER).newInstance();
            connection = DriverManager.getConnection(dbProp.getProperty(PROP_FILE_DB_URL),
                    dbProp.getProperty(PROP_FILE_DB_USER),
                    dbProp.getProperty(PROP_FILE_DB_PASS));

        } catch (Exception ex){
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public static MySqlConnection getInstance(){
        if(instance == null){
            instance = new MySqlConnection();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }


}
