package com.springproject.SpringTriviaApp.controller;

// public class TriviaController {
    
// }

// package com.example.triviaapp.controller;

import com.springproject.SpringTriviaApp.entity.Trivia;
import com.springproject.SpringTriviaApp.service.TriviaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/trivia")
public class TriviaController {

    @Autowired
    private TriviaService triviaService;

    @PostMapping("/start")
    public ResponseEntity<Map<String, Object>> startTrivia() {
        Trivia trivia = triviaService.startTrivia();
        List<String> shuffledAnswers = triviaService.getShuffledAnswers(trivia, null);

        return ResponseEntity.ok(Map.of(
            "triviaId", trivia.getTriviaId(),
            "question", trivia.getQuestion(),
            "possibleAnswers", shuffledAnswers
        ));
    }

    @PutMapping("/reply/{triviaId}")
    public ResponseEntity<Map<String, String>> replyToTrivia(
        @PathVariable Long triviaId,
        @RequestBody Map<String, String> answerMap) {

        String result = triviaService.checkAnswer(triviaId, answerMap.get("answer"));

        switch (result) {
            case "right!":
                return ResponseEntity.ok(Map.of("result", result));
            case "Max attempts reached!":
                return ResponseEntity.status(403).body(Map.of("result", result));
            case "No such question!":
                return ResponseEntity.status(404).body(Map.of("result", result));
            default:
                return ResponseEntity.badRequest().body(Map.of("result", result));
        }
    }
}

