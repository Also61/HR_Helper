package mediasoft.javacourse.coursework;

import java.sql.*;

public class DataBaseHandler {
    //Создание подключения к БД
    static Connection dbConnection;

    static   String connectionString = "jdbc:mysql://" + Configs.dbHost
            + ":" + Configs.dbPort + "/" + Configs.dbName;

    public static Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + Configs.dbHost
                + ":" + Configs.dbPort + "/" + Configs.dbName;

        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, Configs.dbUser, Configs.dbPass);

        return dbConnection;
    }
    public static void closeDbConnection() throws SQLException {
        dbConnection.close();
    }
        }


