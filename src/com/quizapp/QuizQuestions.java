//Author: Bhanu Prakash Bade

//"QuizQuestions.java" acts as a database of questions. Returns the questions for different quizzes.

package com.quizapp;

import java.util.List;

public class QuizQuestions {
    // Returns a list of questions for the Java OOPs Quiz
    public static List<Question> getOopQuestions() {
        return List.of(
            new Question("Method overriding is combination of inheritance and polymorphism?", new String[]{"False", "True"}, 1),
            new Question("What is it called where object has its own lifecycle and child object cannot belong to another parent object?", new String[]{"Composition", "Association", "Encapsulation", "Aggregation"}, 0),
            new Question("Which of the following is a type of polymorphism in Java?", new String[]{"Multilevel polymorphism", "Multiple polymorphism", "Compile time polymorphism", "Execution time polymorphism"}, 2),
            new Question("Which concept of Java is achieved by combining methods and attribute into a class?", new String[]{"Abstraction", "Encapsulation", "Polymorphism", "Inheritance"}, 1),
            new Question("What is it called where child object gets killed if parent object is killed?", new String[]{"Composition", "Aggregation", "Encapsulation", "Association"}, 0),
            new Question("When does method overloading is determined?", new String[]{"At execution time", "At coding time", "At compile time", "At run time"}, 2),
            new Question("What is it called if an object has its own lifecycle and there is no owner?", new String[]{"Encapsulation", "Association", "Composition", "Aggregation"}, 1),
            new Question("Which of the following is not OOPS concept in Java?", new String[]{"Encapsulation", "Polymorphism", "Compilation", "Inheritance"}, 2),
            new Question("When Overloading does not occur?", new String[]{"More than one method with same name but different method signature and different number or type of parameters", "More than one method with same name, same number of parameters and type but different signature", "More than one method with same name, same signature, same number of parameters but different type", "More than one method with same name, same signature but different number of signature"}, 1),
            new Question("Which concept of Java is a way of converting real world objects in terms of class?", new String[]{"Encapsulation", "Polymorphism", "Abstraction", "Inheritance"}, 2)
        );
    }
    // Returns a list of questions for the Java Exception Handling Quiz
    public static List<Question> getExceptionHandlingQuestions() {
        return List.of(
            new Question("Which part of code gets executed whether exception is caught or not?", new String[]{"throw", "try", "catch", "finally"}, 3),
            new Question("Which of the following handles the exception when a catch is not used?", new String[]{"java run time system", "default handler", "finally", "throw handler"}, 1),
            new Question("Which of the following should be true of the object thrown by a thrown statement?", new String[]{"Should be assignable to Exception type", "Should be assignable to Error type", "Should be assignable to Throwable type", "Should be assignable to String type"}, 2),
            new Question("Which of the following keywords is used for throwing exception manually?", new String[]{"catch", "try", "finally", "throw"}, 3),
            new Question("Which of the following keyword is used by a calling function to handle exception thrown by a called function?", new String[]{"throws", "catch", "throw", "try"}, 0),
            new Question("Which of the following is a super class of all exception type classes?", new String[]{"Throwable", "RuntimeExceptions", "Catchable", "String"}, 0),
            new Question("Which of the following operators is used to generate instance of an exception which can be thrown using throw?", new String[]{"new", "thrown", "alloc", "malloc"}, 0),
            new Question("At runtime, error is recoverable.", new String[]{"True", "False"}, 1),
            new Question("Which of the following classes can catch all exceptions which cannot be caught?", new String[]{"RuntimeException", "ParentException", "Error", "Exception"}, 3),
            new Question("Which of these handles the exception when no catch is used?", new String[]{"Java run time system", "finally", "throw handler", "Default handler"}, 0)
        );
    }
}
