//Author: Bhanu Prakash Bade

//"Question.java" defines a 'Question' object, which holds the text of a question, its possible answers, and the correct answer.

package com.quizapp;

public class Question {
    private String question; // The quiz question text
    private String[] options; // The possible answers
    private int correctAnswer; // The index of the correct answer in the options array

    // Constructor that initializes a question with its text, options, and the correct answer
    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Returns the question text
    public String getQuestion() { 
        return question; 
    }

    // Returns the array of options
    public String[] getOptions() { 
        return options; 
    }

    // Returns the index of the correct answer
    public int getCorrectAnswer() { 
        return correctAnswer; 
    }
}
