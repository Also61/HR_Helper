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



    public static void initDataProf() throws IOException, SQLException {
        String selectProfiles = "SELECT * FROM " + Constant.PROFILES_TABLE;
        try {
           Connection connection = DriverManager.getConnection(connectionString, Configs.dbUser, Configs.dbPass);
            Statement statement = connection.createStatement();

            ResultSet resSetProf = statement.executeQuery(selectProfiles);


            while (resSetProf.next()) {

                String Phone = resSetProf.getString(Constant.INTERVIEWS_PHONE);
                String SecondName = resSetProf.getString(Constant.PROFILES_SECONDNAME);
                String Name = resSetProf.getString(Constant.PROFILES_NAME);
                String MiddleName = resSetProf.getString(Constant.PROFILES_MIDDLENAME);
                String Position = resSetProf.getString(Constant.PROFILES_POSITION);
                String Adress = resSetProf.getString(Constant.PROFILES_ADRESS);
                String Citizenship = resSetProf.getString(Constant.PROFILES_CITIZENSHIP);
                String Skills = resSetProf.getString(Constant.PROFILES_SKILLS);
                String Education = resSetProf.getString(Constant.PROFILES_EDUCATION);
                String Passport = resSetProf.getString(Constant.PROFILES_PASSPORT);
                String Experience = resSetProf.getString(Constant.PROFILES_EXPERIENCE);
                String Other = resSetProf.getString(Constant.PROFILES_OTHER);

                Controller.profilesData.add(new Prof(Phone, SecondName, Name, MiddleName, Position, Adress, Citizenship,
                        Skills, Education, Passport, Experience, Other));


            }
            resSetProf.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public static void initDataInter() throws IOException, SQLException {
        String selectInterviews = "SELECT " + Constant.INTERVIEWS_ID + "," + Constant.INTERVIEWS_PHONE + ","+ "InterMonth"+ ","
         + Constant.INTERVIEWS_POSITION + ","+ Constant.INTERVIEWS_RESULT +  " FROM " + Constant.INTERVIEWS_TABLE;
        try {
           Connection connection = DriverManager.getConnection(connectionString, Configs.dbUser, Configs.dbPass);
            Statement statement = connection.createStatement();

            ResultSet resSetInter = statement.executeQuery(selectInterviews);




            while (resSetInter.next()){
                int interviewID = resSetInter.getInt(Constant.INTERVIEWS_ID);
                String phone = resSetInter.getString("Phone");
                String intMonth = resSetInter.getString("InterMonth");
                String position = resSetInter.getString(Constant.INTERVIEWS_POSITION);
                String result = resSetInter.getString(Constant.INTERVIEWS_RESULT);

                Controller.interviewsData.add(new Inter(interviewID,phone,intMonth,position,result));
            } resSetInter.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }



        }


