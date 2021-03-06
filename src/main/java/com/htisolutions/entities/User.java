package com.htisolutions.entities;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String forename;

    @NotNull
    private String surname;

    @NotNull
    private String nickname;

    @NotNull
    private String hashedPassword;

    private Long securityQuestionId;

    private String securityQuestionAnswer;

    public User() { }

    public User(Long id) {
        this.id = id;
    }

    public User(String forename, String surname, String nickname, String hashedPassword, Long securityQuestionId, String securityQuestionAnswer) {
        this.forename = forename;
        this.surname = surname;
        this.nickname = nickname;
        this.hashedPassword = hashedPassword;
        this.securityQuestionId = securityQuestionId;
        this.securityQuestionAnswer = securityQuestionAnswer;
    }

    public Long getId() {
        return this.id;
    }

    public String getForename() {
        return this.forename;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getHashedpassword() {
        return this.hashedPassword;
    }

    public Long getSecurityQuestionId(){return securityQuestionId;}

    public String getSecurityQuestionAnswer(){return securityQuestionAnswer;}

    public void setSecurityQuestionId(long securityQuestionId){this.securityQuestionId = securityQuestionId;}

    public void setSecurityQuestionAnswer(String securityQuestionAnswer){this.securityQuestionAnswer = securityQuestionAnswer;}

    public void setHashedPassword(String password){hashedPassword = password;}

    public String formatName() {
        return String.format("%s %s (%s)", forename, surname, nickname);
    }
}


