package mediasoft.javacourse.coursework;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;


import java.net.URL;
import java.util.ResourceBundle;

public class AddInterviewPageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addInterPosition;

    @FXML
    private TextField addInterInterResult;

    @FXML
    private TextField addInterPhone;

    @FXML
    private Button loadInterview;

    @FXML
    private TextField addInterInterDate;


    @FXML
    private ImageView AddInterInfoButton;


    @FXML
    void initialize() {

        AddInterInfoButton.setOnMouseClicked(event -> {
                Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Внимение");  //warning box title
        info.setHeaderText("Добавлять информацию по собеседованию можно только если кандидат прошел анкетирование.");
        info.showAndWait();
        }
        );

        //Подключение к базе данных

        DataBaseHandler dbHandler = new DataBaseHandler();

        loadInterview.setOnAction(event -> {

                    try {


                        //Загрузка в БД данных анкеты


                        Interviews.addingInterview(addInterPhone.getText(), addInterInterDate.getText(),
                                addInterPosition.getText(), addInterInterResult.getText());
                    } catch (Exception e) {

                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Ошибка!");  //warning box title
                        a.setHeaderText("Полльзователь с данным номером не проходил анкетирования или заполнены не все поля");
                        a.showAndWait();
                    }

                }

        );


    }
}



