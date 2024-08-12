
package com.springproject.SpringTriviaApp.entity;

import javax.persistence.*;

@Entity
@Table(name = "trivia")
public class Trivia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long triviaId;

    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String correctAnswer;

    @Column(nullable = false)
    private int answerAttempts = 0;

    // Getter for answerAttempts
    public int getAnswerAttempts() {
        return answerAttempts;
    }

    // Setter for answerAttempts
    public void setAnswerAttempts(int answerAttempts) {
        this.answerAttempts = answerAttempts;
    }

    // Other getters and setters
    public Long getTriviaId() {
        return triviaId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}


// package com.springproject.SpringTriviaApp.entity;

// import javax.persistence.*;

// @Entity
// @Table(name = "trivia")
// public class Trivia {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long triviaId;

//     @Column(nullable = false)
//     private String question;

//     @Column(nullable = false)
//     private String correctAnswer;

//     @Column(nullable = false)
//     private int answerAttempts = 0;

//     // Getter for triviaId
//     public Long getTriviaId() {
//         return triviaId;
//     }

//        // Setter for answerAttempts
//        public void setAnswerAttempts(int answerAttempts) {
//         this.answerAttempts = answerAttempts;
//     }


//     // Getter for answerAttempts
//     // public int getAnswerAttempts() {
//     //     return answerAttempts;
//     // }

//     public String getQuestion() {
//         return question;
//     }

//     public void setQuestion(String question) {
//         this.question = question;
//     }

//     public String getCorrectAnswer() {
//         return correctAnswer;
//     }

//     public void setCorrectAnswer(String correctAnswer) {
//         this.correctAnswer = correctAnswer;
//     }

//     public void setAnswerAttempts(int i) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'setAnswerAttempts'");
//     }

// }
