import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sun.java2d.cmm.Profile;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;
import java.util.ResourceBundle;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addProfiles;

    @FXML
    private Button addInterview;


    @FXML
    private Tab profTab;

    public static ObservableList<Prof> profilesData = FXCollections.observableArrayList();

    @FXML
    private TableView<Prof> profilesTable;

    @FXML
    private TableColumn<Prof, Integer> profPhone;


    @FXML
    private TableColumn<Prof, String> secName;

    @FXML
    private TableColumn<Prof, String> other;

    @FXML
    private TableColumn<Prof, String> citezen;


    @FXML
    private TableColumn<Prof, String> midName;

    @FXML
    private TableColumn<Prof, String> adress;

    @FXML
    private TableColumn<Prof, String> skill;

    @FXML
    private TableColumn<Prof, String> edu;

    @FXML
    private TableColumn<Prof, String> name;

    @FXML
    private TableColumn<Prof, String> position;

    @FXML
    private TableColumn<Prof, String> exp;

    @FXML
    private TableColumn<Prof, Integer> passport;


    @FXML
    private Tab intTab;

    @FXML
    private TableView<?> interviewTable;


    @FXML
    private TableColumn<?, ?> IntID;

    @FXML
    private TableColumn<?, ?> intPhone;

    @FXML
    private TableColumn<?, ?> intResult;

    @FXML
    private TableColumn<?, ?> intPosition;

    @FXML
    private TableColumn<?, ?> IntMonth;


    @FXML
    void initialize() throws IOException, SQLException {
        addProfiles.setOnAction(event -> {
            addProfiles.getScene().getWindow().getOnHidden();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AddProfilePage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

//Открытие окна с формой заполнения данных о собеседовании
        addInterview.setOnAction(event -> {
            addInterview.getScene().getWindow().getOnHidden();


            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("AddInterviewPage.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

       DataBaseHandler.initData(); //Метод записывающий все значения из бд в ObservableList


        profPhone.setCellValueFactory(new PropertyValueFactory<Prof, Integer>(Constant.PROFILES_PHONE));
        secName.setCellValueFactory(new PropertyValueFactory<Prof, String>(Constant.PROFILES_SECONDNAME));
        name.setCellValueFactory(new PropertyValueFactory<Prof, String>(Constant.PROFILES_NAME));
        midName.setCellValueFactory(new PropertyValueFactory<Prof, String>(Constant.PROFILES_MIDDLENAME));
        position.setCellValueFactory(new PropertyValueFactory<Prof, String>(Constant.PROFILES_POSITION));
        adress.setCellValueFactory(new PropertyValueFactory<Prof, String>(Constant.PROFILES_ADRESS));
        citezen.setCellValueFactory(new PropertyValueFactory<Prof, String>(Constant.PROFILES_CITIZENSHIP));
        skill.setCellValueFactory(new PropertyValueFactory<Prof, String>(Constant.PROFILES_SKILLS));
        edu.setCellValueFactory(new PropertyValueFactory<Prof, String>(Constant.PROFILES_EDUCATION));
        passport.setCellValueFactory(new PropertyValueFactory<Prof, Integer>(Constant.PROFILES_PASSPORT));
        exp.setCellValueFactory(new PropertyValueFactory<Prof, String>(Constant.PROFILES_EXPERIENCE));
        other.setCellValueFactory(new PropertyValueFactory<Prof, String>(Constant.PROFILES_OTHER));


        profilesTable.setItems(profilesData); //Вывод из ObservableList в Tableview
    }



}

