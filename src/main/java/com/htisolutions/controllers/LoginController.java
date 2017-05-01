package com.htisolutions.controllers;

import com.htisolutions.services.LoginService;
import com.htisolutions.viewModels.LoginViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    private LoginService loginService;

    @Autowired
    LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping()
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("views/login");
        LoginViewModel loginViewModel = new LoginViewModel();
        modelAndView.addObject("loginViewModel", loginViewModel);
        return modelAndView;
    }

    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public String index(@ModelAttribute(value="loginViewModel") LoginViewModel loginViewModel) {
        if(loginService.validLogin(loginViewModel.getName(), loginViewModel.getPassword())) {
            return ("redirect:/home");
        }else {
            return ("redirect:/login");
        }
    }

}
