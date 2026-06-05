package com.chess.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Random;

@RestController
@RequestMapping("/game")
public class GameController {

    String[] aiMoves = {"e2e4","d2d4","g1f3","c2c4"};

    @PostMapping("/move")
    public String move(@RequestParam String move) {
        String ai = aiMoves[new Random().nextInt(aiMoves.length)];
        return "User: " + move + " | AI: " + ai;
    }

    @GetMapping("/stats")
    public String stats() {
        return "Wins:5 Losses:3 Accuracy:70%";
    }
}
