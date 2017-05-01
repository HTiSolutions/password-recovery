package com.htisolutions.viewModels;


import com.htisolutions.entities.SecurityQuestion;

public class RegisterViewModel {
    private String firstName;
    private String lastName;
    private String registerNickname;
    private String registerPassword;
    private String confirmPassword;
    private String answer;
    private String confirmAnswer;
    private Iterable<SecurityQuestion> securityQuestions;
    private long questionId;

    public Iterable <SecurityQuestion> getSecurityQuestion(){return securityQuestions;}

    public long getQuestionId(){return questionId;}

    public String getAnswer(){return answer;}

    public String getConfirmAnswer(){return confirmAnswer;}

    public void setSecurityQuestions(Iterable <SecurityQuestion> securityQuestions){this.securityQuestions = securityQuestions;}

    public void setAnswer(String answer){this.answer = answer;}

    public void setQuestionId(long questionId){this.questionId = questionId;}

    public void setConfirmAnswer(String confirmAnswer){this.confirmAnswer = confirmAnswer;}

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRegisterNickname() {
        return registerNickname;
    }

    public String getRegisterPassword() {
        return registerPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRegisterNickname(String registerNickname) {
        this.registerNickname = registerNickname;
    }

    public void setRegisterPassword(String registerPassword) {
        this.registerPassword = registerPassword;
    }

}
