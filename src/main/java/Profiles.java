import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Profiles {

    // Метод выполняющий проверку валидности заполнения полей и вызывающий метод добавления в БД
    public static void checkingBeforeAddingProfile(String phone, String secondName, String name, String middleName,
                                     String position, String adress, String citizenship, String skills,
                                     String education, String passport, String experience, String other)
    {

         phone = phone.trim();
         passport = passport.trim();
        if  (secondName.length() == 0 && phone.length() == 0 && name.length() == 0 && adress.length() == 0 && citizenship.length() == 0 &&
                position.length() == 0 && passport.length() == 0 && education.length() == 0 && skills.length() == 0){
            Alert fillFields = new Alert(Alert.AlertType.ERROR);
            fillFields.setTitle("Ошибка!");  //warning box title
            fillFields.setHeaderText("Заполните все обязательные поля!");
            fillFields.showAndWait();
        }

        else if (passport.length() != 10) {
            Alert wrongPassportLenght = new Alert(Alert.AlertType.ERROR);
            wrongPassportLenght.setTitle("Ошибка!");  //warning box title
            wrongPassportLenght.setHeaderText("В поле <<Паспорт>> должно быть введено 10 цифр (Серия и номер)");
            wrongPassportLenght.showAndWait();

        }

        else if (phone.length() != 11) {
            Alert wrongPhoneLenght = new Alert(Alert.AlertType.ERROR);
            wrongPhoneLenght.setTitle("Ошибка!");  //warning box title
            wrongPhoneLenght.setHeaderText("В поле <<Телефон>> должно быть введено 11 цифр номера (с 8ркой)");
            wrongPhoneLenght.showAndWait();
        }
        else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Данные загружены");
            a.showAndWait();

            addingProfile(phone, secondName, name,
                    middleName, position, adress,
                    citizenship, skills, education,
                    passport, experience, other);
        }
    }


    //Метод содержащий запрос на вставление данных в таблицу анкет
    public static void addingProfile(String phone, String secondName, String name, String middleName,
                                     String position, String adress, String citizenship, String skills,
                                     String education, String passport, String experience, String other)
    {
        String insert = "INSERT INTO " + Constant.PROFILES_TABLE + "(" + Constant.PROFILES_PHONE + ","
                + Constant.PROFILES_SECONDNAME + "," + Constant.PROFILES_NAME + ","  + Constant.PROFILES_MIDDLENAME + ","
                + Constant.PROFILES_POSITION + ","  + Constant.PROFILES_ADRESS + ","  + Constant.PROFILES_CITIZENSHIP + ","
                + Constant.PROFILES_SKILLS + "," + Constant.PROFILES_EDUCATION + ","  + Constant.PROFILES_PASSPORT + ","
                + Constant.PROFILES_EXPERIENCE + ","  + Constant.PROFILES_OTHER + ")" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";


        try {
            PreparedStatement prSt = DataBaseHandler.getDbConnection().prepareStatement(insert);
            prSt.setLong(1, Long.parseLong(phone));
            prSt.setString(2,secondName);
            prSt.setString(3,name);
            prSt.setString(4,middleName);
            prSt.setString(5,position);
            prSt.setString(6,adress);
            prSt.setString(7,citizenship);
            prSt.setString(8,skills);
            prSt.setString(9,education);
            prSt.setLong(10, Long.parseLong(passport));
            prSt.setString(11,experience);
            prSt.setString(12,other);


            prSt.executeUpdate();
        } catch (SQLException e) {

        }
        catch (ClassNotFoundException e) {
        }
    }



    }



