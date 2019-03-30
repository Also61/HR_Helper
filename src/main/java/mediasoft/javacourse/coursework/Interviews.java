package mediasoft.javacourse.coursework;

import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.*;

public class Interviews {

    //Метод содержащий запрос на вставление данных в таблицу собеседований


    public static void addingInterview(String phone, String interMonth,
                                       String position, String result) throws SQLException {
        String insert = "INSERT INTO " + Constant.INTERVIEWS_TABLE + "(" + Constant.INTERVIEWS_PHONE+ ","
                + Constant.INTERVIEWS_INTERMONTH + "," + Constant.INTERVIEWS_POSITION + ","  + Constant.INTERVIEWS_RESULT + ")" +
                "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = DataBaseHandler.getDbConnection().prepareStatement(insert);
            prSt.setString(1,phone);
            prSt.setString(2,interMonth);
            prSt.setString(3,position);
            prSt.setString(4,result);

            prSt.executeUpdate();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Данные загружены");
            a.showAndWait();
        }

        catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Ошибка!");  //warning box title
            a.setHeaderText("Полльзователь с данным номером не проходил анкетирования или заполнены не все поля");
            a.showAndWait();
        }

        DataBaseHandler.closeDbConnection();
    }


    public static void initDataInter() throws IOException, SQLException {
        String selectInterviews = "SELECT " + Constant.INTERVIEWS_ID + "," + Constant.INTERVIEWS_PHONE + ","+ "InterMonth"+ ","
                + Constant.INTERVIEWS_POSITION + ","+ Constant.INTERVIEWS_RESULT +  " FROM " + Constant.INTERVIEWS_TABLE;
        try {
            Connection connection = DriverManager.getConnection(DataBaseHandler.connectionString, Configs.dbUser, Configs.dbPass);
            Statement statement = connection.createStatement();

            ResultSet resSetInter = statement.executeQuery(selectInterviews);




            while (resSetInter.next()){
                int interviewID = resSetInter.getInt(Constant.INTERVIEWS_ID);
                String phone = resSetInter.getString("Phone");
                String intMonth = resSetInter.getString("InterMonth");
                String position = resSetInter.getString(Constant.INTERVIEWS_POSITION);
                String result = resSetInter.getString(Constant.INTERVIEWS_RESULT);

                Controller.interviewsData.add(new Inter(interviewID,phone,intMonth,position,result));
            }
            resSetInter.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


}
