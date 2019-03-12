import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddProfilePageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addProflieEducation;

    @FXML
    private Button addProflieLoadProfile;

    @FXML
    private TextField addProfliePhone;

    @FXML
    private TextField addProflieOther;

    @FXML
    private TextField addProflieMiddleName;

    @FXML
    private TextField addProflieExperience;

    @FXML
    private TextField addProfliePosition;

    @FXML
    private TextField addProflieFirstName;

    @FXML
    private TextField addProfliePassport;

    @FXML
    private TextField addProflieSecondName;

    @FXML
    private TextField addProflieCitezenship;

    @FXML
    private TextField addProflieAdress;

    @FXML
    private TextField addProflieSkills;

    @FXML
    void initialize() {

        //Подключение к базе данных
        DataBaseHandler dbHandler = new DataBaseHandler();

        addProflieLoadProfile.setOnAction(event -> {
            try {


                //Загрузка в БД данных анкеты
                Profiles.addingProfile(Integer.parseInt(addProfliePhone.getText()), addProflieSecondName.getText(), addProflieFirstName.getText(),
                        addProflieMiddleName.getText(), addProfliePosition.getText(), addProflieAdress.getText(),
                        addProflieCitezenship.getText(), addProflieSkills.getText(), addProflieEducation.getText(),
                        Integer.parseInt(addProfliePassport.getText()), addProflieExperience.getText(), addProflieOther.getText());
            }
            catch (Exception e)
            {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Ошибка!");  //warning box title
                a.setHeaderText("Проверьте валидность введенных данных");
                a.showAndWait();
            }
        });

    }
}
