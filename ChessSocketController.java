package com.chess.socket;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChessSocketController {

    private final SimpMessagingTemplate template;

    public ChessSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/move/{room}")
    public void move(@DestinationVariable String room, String move) {
        template.convertAndSend("/topic/" + room, move);
    }
}
