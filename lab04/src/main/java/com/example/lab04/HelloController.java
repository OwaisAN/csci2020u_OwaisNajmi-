package com.example.lab04;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private Label usernameLabel;
    @FXML
    private TextField usernameField;

    @FXML
    private Label passwordLabel;
    @FXML
    private PasswordField passwordField;

    @FXML
    private Label fullNameLabel;
    @FXML
    private TextField fullNameField;

    @FXML
    private Label emailLabel;
    @FXML
    private TextField emailField;

    @FXML
    private Label phoneNumberLabel;
    @FXML
    private TextField phoneNumberField;

    @FXML
    private Label dateBirthLabel;
    @FXML
    private DatePicker dateBirthField;



    @FXML
    protected void handleRegisterButton() {
        System.out.println("Full Name: " + fullNameField.getText());
        System.out.println("E-mail: " + emailField.getText());
        System.out.println("Phone #: " + phoneNumberField.getText());
        System.out.println("Date of Birth: " + dateBirthField.getValue() + "\n");

//        usernameLabel.setText("Hello " + usernameField.getText());
        usernameField.clear();
        passwordField.clear();
        emailField.clear();
        phoneNumberField.clear();
        fullNameField.clear();
        dateBirthField.setValue(null);

    }
}