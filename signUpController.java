package com.example.demo2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class signUpController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField emailField;
    @FXML
    private Label firstNamePrompt;
    @FXML
    private Label surnamePrompt;
    @FXML
    private Label emailPrompt; // to display text if email is invalid (do not contain "@")
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label passwordPrompt;
    @FXML
    private PasswordField confirm_passwordField;
    @FXML
    private Label confirm_passwordPrompt;
    @FXML
    private Button signUpButton;
    @FXML
    private Label successLabel;

    public void getUserInfo(){
        validateEmail();
        validatePassword();
        validateConfirmPassword();
        validateFirstName();
        validateSurname();
        //successSignUp();

        if (successSignUp()) {
            System.out.println("First Name: " + firstNameField.getText());
            System.out.println("Surname: " + surnameField.getText());
            System.out.println("Email: " + emailField.getText());
            System.out.println("Password: " + passwordField.getText());
            System.out.println("Confirmed Password: " + confirm_passwordField.getText());
        } else
            System.out.println("Registration Incomplete");
    }

    // set methods
    public String getFirstName(){
        return firstNameField.getText();
    }
    public String getSurname(){
        return surnameField.getText();
    }
    // validate emailField
    public String getEmail(){
        return emailField.getText();
    }
    public void validateEmail(){
        if(getEmail().isBlank()){
            emailPrompt.setText("Email Field is Empty!!");
        } else if (!(getEmail().contains("@"))){
            emailPrompt.setText("Invalid Email");
        }

        if(getEmail().contains("@")){
            emailPrompt.setText("");
        }

    }

    public String getPassword(){
        return passwordField.getText();
    }
    public String getConfirmPassword(){
        return confirm_passwordField.getText();
    }
    public void validatePassword(){
        // check if password field is empty
        if(getPassword().isBlank()){
            passwordPrompt.setText("Password Field is Empty !");
        }
        // first check if password length is not less than 8
        else if(getPassword().length() < 8){
            passwordPrompt.setText("Password should be minimum of 8 characters");
        } else if (getPassword().length() >= 8) {
            passwordPrompt.setText("");
        }
    }
    public void validateConfirmPassword(){
        if(getConfirmPassword().isBlank()){
            confirm_passwordPrompt.setText("Password Field is Empty !");
        }
        // first check if password length is not less than 8 and password are equal
        else if (getConfirmPassword().equals(getPassword())) {
            confirm_passwordPrompt.setText("");
        }
        else if(!(getPassword().equals(getConfirmPassword()))){
            confirm_passwordPrompt.setText("Password Mismatch");
        }

    }

    public void validateFirstName(){
        if(getFirstName().isBlank()){
            firstNamePrompt.setText("Please Enter your first name!");
        } else if (!(getFirstName().isEmpty())) {
            firstNamePrompt.setText("");
        }
    }

    public void validateSurname(){
        if(getSurname().isBlank()){
            surnamePrompt.setText("Please Enter your surname!");
        } else if (!(getSurname().isEmpty())) {
            surnamePrompt.setText("");
        }
    }

    public boolean successSignUp(){
        // check if all fields are not empty
        if((!(getFirstName().isBlank()) && !(getSurname().isBlank())) && ((!getEmail().isBlank()) && (getEmail().contains("@")))
        && getPassword().equals(getConfirmPassword())){
            // set successful signup message
            successLabel.setText("SIGN UP COMPLETE !");
        } else {
            successLabel.setText("");
            return false;
        }
        return true;
    }
}
