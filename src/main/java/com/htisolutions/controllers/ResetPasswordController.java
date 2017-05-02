package com.htisolutions.controllers;

import com.htisolutions.entities.User;
import com.htisolutions.services.ResetPasswordService;
import com.htisolutions.viewModels.resetPassword.ResetPasswordNicknameViewModel;
import com.htisolutions.viewModels.resetPassword.ResetPasswordPasswordViewModel;
import com.htisolutions.viewModels.resetPassword.ResetPasswordQuestionViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reset-password")
public class ResetPasswordController {

    private ResetPasswordService resetPasswordService;

    @Autowired
    ResetPasswordController(ResetPasswordService resetPasswordService){this.resetPasswordService = resetPasswordService;}

    @RequestMapping()
    public ModelAndView index() {
        ResetPasswordNicknameViewModel viewModel = new ResetPasswordNicknameViewModel();
        ModelAndView modelAndView = new ModelAndView("views/resetPassword/nickname", "enterNickname", viewModel);
        modelAndView.addObject("resetPasswordNicknameViewModel", viewModel);
        return modelAndView;
    }

    @RequestMapping(value="/nickname", method=RequestMethod.POST)
    public String enteredNickname(@ModelAttribute(value="resetPasswordNicknameViewModel") ResetPasswordNicknameViewModel resetPasswordNicknameViewModel) {
        String nickname = resetPasswordNicknameViewModel.getNickname();
        if (resetPasswordService.validName(nickname)) {
            return ("redirect:/reset-password/question");
        } else {
            return ("redirect:/reset-password?error");
        }
    }

    @RequestMapping(value="/question")
    public ModelAndView question() {
        if (resetPasswordService.canAnswerQuestion()) {
            ResetPasswordQuestionViewModel viewModel = new ResetPasswordQuestionViewModel();
            viewModel.setQuestion(resetPasswordService.getQuestion());
            ModelAndView modelAndView = new ModelAndView("views/resetPassword/question", "enterQuestion", viewModel);
            modelAndView.addObject("resetQuestionViewModel", viewModel);
            return modelAndView;
        }
        else{
            return index();
        }
    }

    @RequestMapping(value="/question-answered", method=RequestMethod.POST)
    public String questionAnswered(@ModelAttribute(value="resetQuestionViewModel") ResetPasswordQuestionViewModel resetPasswordQuestionViewModel) {
        String answer = resetPasswordQuestionViewModel.getAnswer();
        if (resetPasswordService.checkSecurityAnswer(answer)){
            return ("redirect:/reset-password/password");
        }
        else{
            return ("redirect:/reset-password/question?error");
        }
    }

    @RequestMapping(value="/password")
    public ModelAndView password() {
        if (resetPasswordService.canResetPassword()) {
            ResetPasswordPasswordViewModel resetPasswordPasswordViewModel = new ResetPasswordPasswordViewModel();
            ModelAndView modelAndView = new ModelAndView("views/resetPassword/password", "enterPassword", resetPasswordPasswordViewModel);
            modelAndView.addObject("resetPasswordPasswordViewModel", resetPasswordPasswordViewModel);
            return modelAndView;
        }else{
            return (question());
        }
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String finished(@ModelAttribute(value="resetPasswordPasswordViewModel") ResetPasswordPasswordViewModel resetPasswordPasswordViewModel) {
        String password = resetPasswordPasswordViewModel.getPassword();
        String confirmPassword = resetPasswordPasswordViewModel.getConfirmPassword();
        if (resetPasswordService.updatePassword(password, confirmPassword)) {
            resetPasswordService.clearProgress();
            return ("redirect:/login");
        } else {
            return ("redirect:/reset-password/password?error");
        }
    }
}
