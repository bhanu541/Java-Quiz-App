# Java Quiz Application

This is a simple Java Quiz Application with a graphical user interface (GUI). The application allows users to take quizzes.

## Project Directory Structure


- **bin/**: This folder will contain the compiled `.class` files after you run the `javac` command.
- **src/**: This folder contains the source code for the application.
  - **Main.java**: The entry point of the application, where the program starts.
  - **Question.java**: A class that represents a single quiz question.
  - **QuizManager.java**: A class that handles the logic of the quiz, such as checking answers and calculating scores.
  - **QuizQuestions.java**: A class that contains the questions for the quiz.
  - **QuizUI.java**: A class that handles the user interface, including displaying the quiz, handling user input, and managing the quiz timer.

## Commands to Compile and Run the Project

### 1. Open Terminal in the `QuizApp` Directory

- Navigate to the `QuizApp` directory. If you're not already there, you can navigate to it using the following command:
	* cd path/to/QuizApp1

### 2. Compile the Java Files

- Compile all the Java files in the src/com/quizapp/ directory and place the compiled class files in the bin directory
	* javac -d bin/ src/com/quizapp/*.java

### 3. Run the Application

- Run the application using the java command, specifying the bin directory as the classpath:
	* java -cp bin com.quizapp.Main

### How to Use the Application

* Starting the Application: After running the java command, the Java Quiz Application will launch.
* Selecting a Quiz: On the main menu, choose a quiz by clicking on either "Java OOPs Quiz" or "Java Exception Handling Quiz".
* Taking the Quiz: Answer all the questions within the given time. The timer is displayed at the top.
* Submitting the Quiz: Click the "Submit" button once you have answered all the questions. The application will display your score.
* Taking Another Quiz: After submitting your quiz, you can return to the main menu to select another quiz.

## Additional Notes

* Ensure that you have Java installed on your system before trying to compile and run the project.
