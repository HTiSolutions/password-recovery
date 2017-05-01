package com.htisolutions.services;

import com.htisolutions.entities.SecurityQuestion;
import com.htisolutions.entities.SecurityQuestionDao;
import com.htisolutions.entities.User;
import com.htisolutions.entities.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private UserDao userDao;
    private SecurityQuestionDao securityQuestionDao;

    @Autowired
    RegisterService(UserDao userDao, SecurityQuestionDao securityQuestionDao) {
        this.userDao = userDao;
        this.securityQuestionDao = securityQuestionDao;
    }

    public Boolean validRegister(String firstName, String lastName, String nickname, String registerPassword, String confirmPassword , Long questionId, String answer, String confirmAnswer){
        if (registerPassword.equals(confirmPassword) && userDao.findByNickname(nickname) == null && (answer.equals(confirmAnswer))) {
            try {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String hashedPassword = passwordEncoder.encode(registerPassword);
                String hashedAnswer = passwordEncoder.encode(answer);
                User user = new User(firstName, lastName, nickname, hashedPassword, questionId, hashedAnswer);
                userDao.save(user);
                return true;
            }
            catch (Exception ex) {
            }
        }
        return false;
    }

    public Iterable<SecurityQuestion> getOptions(){
        return securityQuestionDao.findAll();
    }
}
