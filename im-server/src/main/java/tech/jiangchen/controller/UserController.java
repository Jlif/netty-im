package tech.jiangchen.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tech.jiangchen.config.Constants;
import tech.jiangchen.entity.User;
import tech.jiangchen.exceptions.InvalidUserInfoException;
import tech.jiangchen.exceptions.UserNotExistException;
import tech.jiangchen.service.UserService;
import tech.jiangchen.vo.MessageContactVO;

import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(path = "/")
    public String welcomePage(@RequestParam(name = "username", required = false)
                              String username, HttpSession session) {
        if (session.getAttribute(Constants.SESSION_KEY) != null) {
            return "index";
        } else {
            return "login";
        }
    }

    @RequestMapping(path = "/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        try {
            User loginUser = userService.login(email, password);
            model.addAttribute("loginUser", loginUser);
            session.setAttribute(Constants.SESSION_KEY, loginUser);

            List<User> otherUsers = userService.getAllUsersExcept(loginUser);
            model.addAttribute("otherUsers", otherUsers);

            MessageContactVO contactVO = userService.getContacts(loginUser);
            model.addAttribute("contactVO", contactVO);
            return "index";

        } catch (UserNotExistException e1) {
            model.addAttribute("errormsg", email + ": 该用户不存在！");
            return "login";
        } catch (InvalidUserInfoException e2) {
            model.addAttribute("errormsg", "密码输入错误！");
            return "login";
        }
    }

    @RequestMapping(path = "/ws")
    public String ws(Model model, HttpSession session) {
        User loginUser = (User) session.getAttribute(Constants.SESSION_KEY);
        model.addAttribute("loginUser", loginUser);
        List<User> otherUsers = userService.getAllUsersExcept(loginUser);
        model.addAttribute("otherUsers", otherUsers);

        MessageContactVO contactVO = userService.getContacts(loginUser);
        model.addAttribute("contactVO", contactVO);
        return "index_ws";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(Constants.SESSION_KEY);
        return "redirect:/";
    }

}