package mediasoft.javacourse.coursework;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mediasoft.javacourse.coursework.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

    public static ObservableList<Inter> interviewsData = FXCollections.observableArrayList();

    @FXML
    private TableView<Inter> interviewTable;


    @FXML
    private TableColumn<Inter, Integer> IntID;

    @FXML
    private TableColumn<Inter, Integer> intPhone;

    @FXML
    private TableColumn<Inter, String> intResult;

    @FXML
    private TableColumn<Inter, String> intPosition;

    @FXML
    private TableColumn<Inter, String> InterMonth;


    
    @FXML
    private ImageView LoadOrRefresh;

    @FXML
    private Button searchButton;

    @FXML
    private TextField search;


    @FXML
    void initialize() throws IOException, SQLException {
//Открытие окна с формой заполнения данных о собеседовании
        addProfiles.setOnAction(event -> {
            addProfiles.getScene().getWindow().getOnHidden();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../../../../resources/AddProfilePage.fxml"));

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
            loader.setLocation(getClass().getResource("../../../../resources/AddInterviewPage.fxml"));

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




        LoadOrRefresh.setOnMouseClicked(event -> {
            profilesData.clear();
            profilesTable.getItems();// Очистка коллекции отображаемой в таблице Анкет

            try {
                Profiles.initDataProf(); //Метод записывающий все значения из бд в ObservableList
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }


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


            interviewsData.clear();// Очистка коллекции отображаемой в таблице собеседований

            try {
                Interviews.initDataInter();//Метод записывающий все значения из бд в ObservableList
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            IntID.setCellValueFactory(new PropertyValueFactory<Inter, Integer>(Constant.INTERVIEWS_ID));
            intPhone.setCellValueFactory(new PropertyValueFactory<Inter, Integer>(Constant.INTERVIEWS_PHONE));
            InterMonth.setCellValueFactory(new PropertyValueFactory<Inter, String>(Constant.INTERVIEWS_INTERMONTH));
            intPosition.setCellValueFactory(new PropertyValueFactory<Inter, String>(Constant.INTERVIEWS_POSITION));
            intResult.setCellValueFactory(new PropertyValueFactory<Inter, String>(Constant.INTERVIEWS_RESULT));

            interviewTable.setItems(interviewsData); //Вывод из ObservableList в Tableview

        });

searchButton.setOnAction(event -> {

    profilesData.clear();
    profilesTable.getItems();// Очистка коллекции отображаемой в таблице Анкет
String pos = search.getText();
    try {
        Profiles.initDataProfSearch(pos); //Метод записывающий все значения из бд в ObservableList
    } catch (IOException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }


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




});



    }



}

