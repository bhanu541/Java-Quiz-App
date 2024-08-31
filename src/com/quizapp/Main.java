//Author: Bhanu Prakash Bade

//"Main.java" starts Quiz Application by creating a GUI'

package com.quizapp;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Starts the app on a correct thread for Swing framework
        SwingUtilities.invokeLater(QuizUI::new);
    }
}
