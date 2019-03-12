import javafx.scene.control.Alert;

import java.io.IOException;
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

    static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(connectionString, Configs.dbUser, Configs.dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void initData() throws IOException, SQLException {
        String select = "SELECT * FROM " + Constant.PROFILES_TABLE;
        try {
            Statement statement = connection.createStatement();
            /* IDEA Ругается на эту строчку во время компиляции если использовать метод getDbConnection(),
             из-за чего приходится обьявлять дополнительно статическое подключение к БД и использовать его */
            ResultSet resSetProf = statement.executeQuery(select);


            while (resSetProf.next()) {

                int Phone = resSetProf.getInt(Constant.INTERVIEWS_PHONE);
                String SecondName = resSetProf.getString(Constant.PROFILES_SECONDNAME);
                String Name = resSetProf.getString(Constant.PROFILES_NAME);
                String MiddleName = resSetProf.getString(Constant.PROFILES_MIDDLENAME);
                String Position = resSetProf.getString(Constant.PROFILES_POSITION);
                String Adress = resSetProf.getString(Constant.PROFILES_ADRESS);
                String Citizenship = resSetProf.getString(Constant.PROFILES_CITIZENSHIP);
                String Skills = resSetProf.getString(Constant.PROFILES_SKILLS);
                String Education = resSetProf.getString(Constant.PROFILES_EDUCATION);
                int Passport = resSetProf.getInt(Constant.PROFILES_PASSPORT);
                String Experience = resSetProf.getString(Constant.PROFILES_EXPERIENCE);
                String Other = resSetProf.getString(Constant.PROFILES_OTHER);

                Controller.profilesData.add(new Prof(Phone, SecondName, Name, MiddleName, Position, Adress, Citizenship, Skills, Education, Passport, Experience, Other));


            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }



        }


