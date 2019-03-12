import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Profiles {



    //Метод содержащий запрос на вставление данных в таблицу анкет
    public static void addingProfile(Integer phone, String secondName, String name, String middleName,
                                     String position, String adress, String citizenship, String skills,
                                     String education, Integer passport, String experience, String other)
    {
        String insert = "INSERT INTO " + Constant.PROFILES_TABLE + "(" + Constant.PROFILES_PHONE + ","
                + Constant.PROFILES_SECONDNAME + "," + Constant.PROFILES_NAME + ","  + Constant.PROFILES_MIDDLENAME + ","
                + Constant.PROFILES_POSITION + ","  + Constant.PROFILES_ADRESS + ","  + Constant.PROFILES_CITIZENSHIP + ","
                + Constant.PROFILES_SKILLS + "," + Constant.PROFILES_EDUCATION + ","  + Constant.PROFILES_PASSPORT + ","
                + Constant.PROFILES_EXPERIENCE + ","  + Constant.PROFILES_OTHER + ")" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";


        try {
            PreparedStatement prSt = DataBaseHandler.getDbConnection().prepareStatement(insert);
            prSt.setInt(1,phone);
            prSt.setString(2,secondName);
            prSt.setString(3,name);
            prSt.setString(4,middleName);
            prSt.setString(5,position);
            prSt.setString(6,adress);
            prSt.setString(7,citizenship);
            prSt.setString(8,skills);
            prSt.setString(9,education);
            prSt.setInt(10,passport);
            prSt.setString(11,experience);
            prSt.setString(12,other);


            prSt.executeUpdate();
        } catch (SQLException e) {

        }
        catch (ClassNotFoundException e) {
        }
    }



    }



