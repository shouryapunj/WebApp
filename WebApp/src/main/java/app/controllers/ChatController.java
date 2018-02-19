package app.controllers;

import app.dto.ChatMessage;
import app.dto.ChatUser;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class ChatController {

    @RequestMapping(value = "/webAppChat", method = RequestMethod.GET)
    public String openChat() {
        return "webAppChat";
    }

    @MessageMapping("/msg")
    @SendTo("/chat/online")
    public ChatMessage message(ChatUser chatUser, StompHeaderAccessor stompHeaderAccessor) throws Exception {
        String user = stompHeaderAccessor.getUser().getName();
        String userAndMessage = user + " >> " + chatUser.getName();
        String msg = "[ " + new Date().toString() +" ]  " + userAndMessage;
//        String msg = userAndMessage + "     @ " + new Date().toString();
//        String msg = String.format("%-50s%-50s\n", userAndMessage, (new Date()).toString());
        Thread.sleep(1000); //simulated delay
        return new ChatMessage(msg);
    }
}
