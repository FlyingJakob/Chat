package StripedPandaStudios.Chat.Chat.controllers;

import StripedPandaStudios.Chat.Chat.Models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
public class AuthController {

    public User LoggedInUser;

    @GetMapping("/google-success")
    private String googleLoginSuccess(OAuth2AuthenticationToken token, HttpSession session) {

        User user = new User(token.getPrincipal().getAttribute("given_name"),token.getPrincipal().getName());
        LoggedInUser = user;
        session.setAttribute("username",user.getUsername());
        return "redirect:/";
    }


    public static User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
            return new User(oauthToken.getPrincipal().getAttribute("given_name"),oauthToken.getPrincipal().getName());
        }
        return null;
    }
}
