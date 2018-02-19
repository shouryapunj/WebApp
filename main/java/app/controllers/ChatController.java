package app.controllers;

import app.dto.ChatMessage;
import app.dto.ChatUser;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {

    @RequestMapping(value = "/webAppChat", method = RequestMethod.GET)
    public String openChat() {
        return "webAppChat";
    }

//    @RequestMapping(value = "/webAppChat", method = RequestMethod.POST)
//    public void inChat() {
//
//    }

    @MessageMapping("/msg")
    @SendTo("/chat/online")
    public ChatMessage message(ChatUser chatUser) throws Exception {
        Thread.sleep(800);
        return new ChatMessage(chatUser.getName());
    }
}
