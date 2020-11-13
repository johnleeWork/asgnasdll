/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.dto;

/**
 *
 * @author macbook
 */
public class UserErrorDTO {

    private String userIDError;
    private String passwordError;
    private String fullNameError;
    private String genderError;
    private String emailError;
    private String confirmError;

    public UserErrorDTO() {
    }

    public UserErrorDTO(String userIDError, String passwordError, String fullNameError, String genderError, String emailError, String confirmError) {
        this.userIDError = userIDError;
        this.passwordError = passwordError;
        this.fullNameError = fullNameError;
        this.genderError = genderError;
        this.emailError = emailError;
        this.confirmError = confirmError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getGenderError() {
        return genderError;
    }

    public void setGenderError(String genderError) {
        this.genderError = genderError;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    
   

}
