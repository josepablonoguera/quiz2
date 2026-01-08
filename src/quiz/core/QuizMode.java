package quiz.core;

public enum QuizMode {
    OPTION_A(1),
    OPTION_B(2),
    AUTOGRADER(3),
    EXIT(0);

    private final int choice;

    QuizMode(int choice) {
        this.choice = choice;
    }

    public int getChoice() {
        return choice;
    }

    public static QuizMode fromChoice(int choice) {
        for (QuizMode mode : values()) {
            if (mode.choice == choice) {
                return mode;
            }
        }
        return EXIT;
    }
}
