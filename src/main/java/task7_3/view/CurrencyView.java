package task7_3.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import task7_3.controller.CurrencyController;
import task7_3.dao.CurrencyDao;
import task7_3.entity.CurrencyModel;

public class CurrencyView extends Application {

    private CurrencyController controller;

    private BorderPane layout;
    private VBox left;
    private VBox right;
    private BorderPane center;
    private VBox centerButtons;

    private ToggleGroup toggleGroupLeft;

    private ToggleGroup toggleGroupRight;

    private TextField textLeft;
    private TextField textRight;
    private Button convertButton;
    private Button addButton;
    private Label errorLabel;




//7.3
    Stage newStage;
    VBox vbox;

    Label abbreviationLabel;
    Label nameLabel;
    Label rateLabel;

    public TextField abbreviationTextField;
    public TextField nameTextField;
    public TextField rateTextField;


    public void start(Stage stage) {

        //INITIALIZING VARIABLES
        layout = new BorderPane();
        left = new VBox();
        right = new VBox();
        center = new BorderPane();
        centerButtons = new VBox();

        toggleGroupLeft = new ToggleGroup();

        toggleGroupRight = new ToggleGroup();

        textLeft = new TextField();
        textRight = new TextField();
        convertButton = new Button("Convert");
        addButton = new Button("Add a new currency");
        errorLabel = new Label();

        left.setAlignment(Pos.CENTER);
        right.setAlignment(Pos.CENTER);

        //CENTER
        center.setLeft(textLeft);
        textLeft.setAlignment(Pos.CENTER);

        center.setRight(textRight);
        textRight.setAlignment(Pos.BOTTOM_CENTER);

        centerButtons.getChildren().add(convertButton);
        centerButtons.getChildren().add(addButton);
        center.setCenter(centerButtons);
        center.setBottom(errorLabel);

        convertButton.setOnAction(calue ->{
            controller.convert();
        });

//7.3
        addButton.setOnAction(calue ->{
            newStage = new Stage();
            vbox = new VBox();

            abbreviationLabel = new Label("Abbreviation");
            nameLabel = new Label("Name");
            rateLabel = new Label("Rate");

            abbreviationTextField = new TextField();
            nameTextField = new TextField();
            rateTextField = new TextField();

            addButton = new Button("Add a new currency");

            addButton.setOnAction(event -> {
                controller.add();
            });

            vbox.getChildren().add(abbreviationLabel);
            vbox.getChildren().add(abbreviationTextField);
            vbox.getChildren().add(nameLabel);
            vbox.getChildren().add(nameTextField);
            vbox.getChildren().add(rateLabel);
            vbox.getChildren().add(rateTextField);
            vbox.getChildren().add(addButton);

            Scene scene = new Scene(vbox, 400, 400);
            stage.setTitle("Adder");
            newStage.setScene(scene);
            newStage.showAndWait();
        });





        for(CurrencyModel i : controller.currensies){
            addCurrency(i);
        }



        //SETTING UP THE STUFF
        layout.setLeft(left);
        layout.setRight(right);
        layout.setCenter(center);

        Scene scene = new Scene(layout, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Converter");
        stage.show();

        //System.out.println("Converter started");
        //System.out.println(controller.view.controller.view.controller.view.controller.view.controller.view.controller.view.controller.view.controller.view.controller.view.controller.view.controller.view.controller.view.controller.view);
    }

    public void init(){
        this.controller = new CurrencyController(this, new CurrencyDao());
    }

    public String getValue(){
        return textLeft.getText();
    }

    public Object radioLeft(){
        toggleGroupLeft.getSelectedToggle().getUserData();
        return ((RadioButton) toggleGroupLeft.getSelectedToggle()).getUserData();
    }

    public Object radioRight(){
        toggleGroupRight.getSelectedToggle().getUserData();
        return ((RadioButton) toggleGroupRight.getSelectedToggle()).getUserData();
    }

    public void setCOnverted(String value){
        textRight.setText(value);
    }

    public void setErrorLabel(String value){
        errorLabel.setText(value);
    }

    public void addCurrency(CurrencyModel value){

        //left
        RadioButton newCurrencyLeft;
        newCurrencyLeft = new RadioButton(value.getAbbreviation());
        newCurrencyLeft.setUserData(value.getConversion_rate());
        newCurrencyLeft.setToggleGroup(toggleGroupLeft);
        left.getChildren().add(newCurrencyLeft);

        //right
        RadioButton newCurrencyRight;
        newCurrencyRight = new RadioButton(value.getAbbreviation());
        newCurrencyRight.setUserData(value.getConversion_rate());
        newCurrencyRight.setToggleGroup(toggleGroupRight);
        right.getChildren().add(newCurrencyRight);
    }
}