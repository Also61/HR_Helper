import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


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
    void initialize() {
        //Подключение к базе данных

        DataBaseHandler dbHandler = new DataBaseHandler();

        loadInterview.setOnAction(event -> {

                    try {


                        //Загрузка в БД данных анкеты


                        Interviews.addingInterview(Integer.parseInt(addInterPhone.getText()), addInterInterDate.getText(),
                                addInterPosition.getText(), addInterInterResult.getText());
                    } catch (Exception e) {

                        Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setTitle("Ошибка!");  //warning box title
                        a.setHeaderText("Проверьте валидность введенных данных");
                        a.showAndWait();
                    }
                }

        );


    }
}



