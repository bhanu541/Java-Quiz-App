//Author: Bhanu Prakash Bade

//"QuizManager.java" manages the quiz logic. It handles checking whether all questions have been answered,
//calculating the user's score, and keeping track of the total number of questions in the quiz.

package com.quizapp;

import javax.swing.*;
import java.util.List;

public class QuizManager {
    private List<Question> questions; // List of all questions in the quiz
    private int score; // The user's current score

    // Constructor that initializes the quiz with a list of questions
    public QuizManager(List<Question> questions) {
        this.questions = questions;
        this.score = 0; // Start with a score of 0
    }

    // Checks if all questions have been answered
    public boolean allQuestionsAnswered(JRadioButton[][] optionButtons) {
        // Loop through each question
        for (int i = 0; i < questions.size(); i++) {
            boolean answered = false;

            // Loop through the options for the current question
            for (int j = 0; j < optionButtons[i].length; j++) {
                if (optionButtons[i][j].isSelected()) {
                    answered = true; // Mark the question as answered if any option is selected
                    break; // Stop checking further options for this question
                }
            }

            if (!answered) {
                return false; // Return false if any question is not answered
            }
        }

        return true; // Return true if all questions are answered
    }

    // Calculates the user's score based on the selected answers
    public int calculateScore(JRadioButton[][] optionButtons) {
        // Loop through each question
        for (int i = 0; i < questions.size(); i++) {
            // Loop through the options for the current question
            for (int j = 0; j < optionButtons[i].length; j++) {
                if (optionButtons[i][j].isSelected() && questions.get(i).getCorrectAnswer() == j) {
                    score++; // Increment the score if the selected answer is correct
                }
            }
        }

        return score; // Return the final score
    }

    // Returns the total number of questions in the quiz
    public int getTotalQuestions() {
        return questions.size(); // Return the size of the questions list
    }
}