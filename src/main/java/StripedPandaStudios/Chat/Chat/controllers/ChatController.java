package StripedPandaStudios.Chat.Chat.controllers;

import StripedPandaStudios.Chat.Chat.Models.Message;
import StripedPandaStudios.Chat.Chat.Models.User;
import StripedPandaStudios.Chat.Chat.repositories.MessageRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private AuthController authController;

    @GetMapping("/")
    private String getHome(Model model, Principal principal){

        List<Message> messages = messageRepository.findAll();

        Collections.reverse(messages);

        model.addAttribute("messages", messages);
        model.addAttribute("username", AuthController.getCurrentUser().getUsername());
        model.addAttribute("id", principal.getName());
        return "home";
    }
    @PostMapping("/sendMessage")
    public String sendMessage(@RequestParam("message") String messageText, RedirectAttributes redirectAttributes, Principal principal, HttpSession session) {
        Message newMessage = new Message();
        newMessage.setText(messageText);
        newMessage.setSender(AuthController.getCurrentUser().getUsername(),AuthController.getCurrentUser().getId());



        messageRepository.save(newMessage);


        //redirectAttributes.addFlashAttribute("success", "Message sent successfully!");
        return "redirect:/";
    }


}
