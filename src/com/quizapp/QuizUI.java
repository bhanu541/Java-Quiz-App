//Author: Bhanu Prakash Bade

//"QuizUI.java" is responsible for managing the user interface (UI) of the Java Quiz Application.
//It handles displaying the quiz options, starting a quiz, managing the quiz timer, and submitting the quiz answers.

package com.quizapp;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizUI {
    private JFrame frame; // Main window of the application
    private JLabel timerLabel; // Label to display the remaining time
    private Timer timer; // Timer for counting down the quiz time
    private int timeRemaining = 300; // Total time in seconds (5 minutes)
    private JRadioButton[][] optionButtons; // Array to store the option buttons for each question
    private QuizManager quizManager; // Manages the quiz logic

    // Constructor to set up the UI and display the quiz options
    public QuizUI() {
        frame = new JFrame("Java Quiz Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.setResizable(true); // Allow the window to be resized
        showQuizOptions(); // Display the main menu with quiz options
        frame.setVisible(true);
    }

    // Displays the main menu with quiz options
    private void showQuizOptions() {
        stopTimer(); // Stop any running timer when returning to the main menu

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Arrange buttons vertically

        // Create buttons for the quizzes and add them to the panel
        JButton oopQuizButton = createQuizButton("Java OOPs Quiz", () -> startQuiz(QuizQuestions.getOopQuestions()));
        JButton exceptionQuizButton = createQuizButton("Java Exception Handling Quiz", () -> startQuiz(QuizQuestions.getExceptionHandlingQuestions()));

        addComponentsToPanel(panel, oopQuizButton, exceptionQuizButton); // Add buttons to the panel

        frame.getContentPane().removeAll(); // Clear the previous screen
        frame.add(panel, BorderLayout.CENTER); // Add the panel to the center of the frame
        frame.revalidate(); // Refresh the frame to apply changes
        frame.repaint(); // Repaint the frame
    }

    // Starts the selected quiz
    private void startQuiz(List<Question> questions) {
        stopTimer(); // Stop any existing timer before starting a new quiz

        // Check if there are questions available for the quiz
        if (questions == null || questions.isEmpty()) {
            showError("No questions available for this quiz."); // Show an error if no questions are available
            return;
        }

        quizManager = new QuizManager(questions); // Initialize the quiz manager
        frame.getContentPane().removeAll(); // Clear the previous screen

        JPanel mainPanel = createQuestionPanel(questions); // Create the panel with quiz questions
        setupTimerLabel(); // Set up the timer label

        // Add components to the frame
        JScrollPane scrollPane = new JScrollPane(mainPanel); // Make the question panel scrollable
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Set the scroll speed

        frame.add(timerLabel, BorderLayout.NORTH); // Add the timer label to the top of the frame
        frame.add(scrollPane, BorderLayout.CENTER); // Add the scroll pane to the center of the frame

        setupSubmitButton(); // Set up the submit button
        startTimer(); // Start the quiz timer

        frame.revalidate(); // Refresh the frame to apply changes
        frame.repaint(); // Repaint the frame
    }

    // Sets up the timer label at the top of the screen
    private void setupTimerLabel() {
        timerLabel = new JLabel("Time Left: 05:00", SwingConstants.CENTER); // Initialize the timer label
        timerLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Set the font size for the timer
        timerLabel.setForeground(Color.RED); // Set the color of the timer text
    }

    // Sets up the submit button at the bottom of the screen
    private void setupSubmitButton() {
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 16)); // Set the font size for the button
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button horizontally
        submitButton.addActionListener(e -> submitQuiz()); // Set the action to perform when the button is clicked

        JPanel submitPanel = new JPanel();
        submitPanel.add(submitButton); // Add the button to the panel
        frame.add(submitPanel, BorderLayout.SOUTH); // Add the panel to the bottom of the frame
    }

    // Creates the panel that contains all the quiz questions
    private JPanel createQuestionPanel(List<Question> questions) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Arrange questions vertically
        optionButtons = new JRadioButton[questions.size()][]; // Initialize the array to store option buttons

        // Loop through each question and add it to the panel
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            JPanel questionPanel = new JPanel();
            questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS)); // Arrange question and options vertically
            questionPanel.setAlignmentX(Component.LEFT_ALIGNMENT); // Align the panel to the left

            JLabel questionLabel = new JLabel((i + 1) + ". " + q.getQuestion()); // Create a label for the question
            questionLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Set the font size for the question
            questionPanel.add(questionLabel); // Add the question label to the panel

            String[] options = q.getOptions(); // Get the options for the question
            optionButtons[i] = new JRadioButton[options.length]; // Initialize the array for the options
            ButtonGroup group = new ButtonGroup(); // Group the options so only one can be selected

            // Loop through each option and add it to the panel
            for (int j = 0; j < options.length; j++) {
                JRadioButton button = createOptionButton(options[j]); // Create a radio button for each option
                group.add(button); // Add the button to the group
                questionPanel.add(button); // Add the button to the panel
                optionButtons[i][j] = button; // Store the button in the array
            }

            mainPanel.add(questionPanel); // Add the question panel to the main panel
            mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add space between questions
        }

        return mainPanel; // Return the main panel containing all the questions
    }

    // Helper method to create a radio button for an option
    private JRadioButton createOptionButton(String option) {
        JRadioButton button = new JRadioButton(option);
        button.setFont(new Font("Arial", Font.PLAIN, 14)); // Set the font size for the option
        return button;
    }

    // Helper method to create a quiz button
    private JButton createQuizButton(String text, Runnable action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 16)); // Set the font size for the button
        button.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button horizontally
        button.setMaximumSize(new Dimension(300, 50)); // Set the maximum button size
        button.addActionListener(e -> action.run()); // Set the action to perform when the button is clicked
        return button;
    }

    // Helper method to add multiple buttons to a panel
    private void addComponentsToPanel(JPanel panel, JButton... buttons) {
        panel.add(Box.createVerticalGlue()); // Add space above the buttons
        for (JButton button : buttons) {
            panel.add(button); // Add each button to the panel
            panel.add(Box.createRigidArea(new Dimension(0, 20))); // Add space between buttons
        }
        panel.add(Box.createVerticalGlue()); // Add space below the buttons
    }

    // Starts the timer for the quiz
    private void startTimer() {
        timer = new Timer(); // Initialize the timer
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeRemaining--; // Decrease the remaining time by 1 second
                updateTimerLabel(); // Update the timer label

                // If time runs out, submit the quiz automatically
                if (timeRemaining <= 0) {
                    timer.cancel(); // Stop the timer
                    SwingUtilities.invokeLater(() -> submitQuiz()); // Submit the quiz
                }
            }
        }, 1000, 1000); // Update the timer every second
    }

    // Updates the timer label with the remaining time
    private void updateTimerLabel() {
        int minutes = timeRemaining / 60; // Calculate minutes left
        int seconds = timeRemaining % 60; // Calculate seconds left
        timerLabel.setText(String.format("Time Left: %02d:%02d", minutes, seconds)); // Update the timer label
    }

    // Stops the timer if it's running
    private void stopTimer() {
        if (timer != null) {
            timer.cancel(); // Stop the timer
            timer = null; // Reset the timer variable
        }
    }

    // Submits the quiz and checks the answers
    private void submitQuiz() {
        // Check if all questions have been answered
        if (!quizManager.allQuestionsAnswered(optionButtons)) {
            showError("Please answer all questions before submitting."); // Show a warning if not all questions are answered
            return; // Stop the submission process
        }

        int score = quizManager.calculateScore(optionButtons); // Calculate the score
        JOptionPane.showMessageDialog(frame, "Quiz Completed! Your Score: " + score + "/" + quizManager.getTotalQuestions()); // Show the user's score
        showQuizOptions(); // Return to the main menu
    }

    // Shows an error message in a dialog box
    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE); // Display the error message
    }
}
