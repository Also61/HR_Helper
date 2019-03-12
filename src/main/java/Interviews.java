import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Interviews {

    //Метод содержащий запрос на вставление данных в таблицу собеседований
    public static void addingInterview(Integer phone, String interMonth,
                                       String position, String result){
        String insert = "INSERT INTO " + Constant.INTERVIEWS_TABLE + "(" + Constant.INTERVIEWS_PHONE+ ","
                + Constant.INTERVIEWS_INTERMONTH + "," + Constant.INTERVIEWS_POSITION + ","  + Constant.INTERVIEWS_RESULT + ")" +
                "VALUES(?,?,?,?)";

        try {
            PreparedStatement prSt = DataBaseHandler.getDbConnection().prepareStatement(insert);
            prSt.setInt(1,phone);
            prSt.setString(2,interMonth);
            prSt.setString(3,position);
            prSt.setString(4,result);

            prSt.executeUpdate();
        }
        catch (SQLException e) {

            e.printStackTrace();

        }
        catch (ClassNotFoundException e) {

            e.printStackTrace();




        }
    }


}
