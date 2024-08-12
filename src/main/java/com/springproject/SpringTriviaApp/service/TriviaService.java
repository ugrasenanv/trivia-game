package com.springproject.SpringTriviaApp.service;



import com.springproject.SpringTriviaApp.entity.Trivia;
import com.springproject.SpringTriviaApp.repository.TriviaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TriviaService {

    @Autowired
    private TriviaRepository triviaRepository;

    private static final String TRIVIA_API_URL = "https://opentdb.com/api.php?amount=1";

    public Trivia startTrivia() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> response = restTemplate.getForObject(TRIVIA_API_URL, Map.class);

        Map<String, String> triviaData = (Map<String, String>) ((List<Object>) response.get("results")).get(0);

        Trivia trivia = new Trivia();
        trivia.setQuestion(triviaData.get("question"));
        trivia.setCorrectAnswer(triviaData.get("correct_answer"));
        triviaRepository.save(trivia);

        return trivia;
    }

    public List<String> getShuffledAnswers(Trivia trivia, Map<String, Object> triviaData) {
        List<String> answers = new ArrayList<>();
        answers.add(trivia.getCorrectAnswer());
        answers.addAll((List<String>) triviaData.get("incorrect_answers"));
        Collections.shuffle(answers);
        return answers;
    }

    public String checkAnswer(Long triviaId, String answer) {
        Optional<Trivia> triviaOpt = triviaRepository.findById(triviaId);
        if (!triviaOpt.isPresent()) {
            return "No such question!";
        }

        Trivia trivia = triviaOpt.get();
        if (trivia.getAnswerAttempts() >= 3) {
            return "Max attempts reached!";
        }

        if (trivia.getCorrectAnswer().equalsIgnoreCase(answer)) {
            triviaRepository.delete(trivia);
            return "right!";
        } else {
            trivia.setAnswerAttempts(trivia.getAnswerAttempts() + 1);
            triviaRepository.save(trivia);
            return "wrong!";
        }
    }
}
