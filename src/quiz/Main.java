package quiz;

import quiz.a.BracketBalancer;
import quiz.b.SparseVector;
import quiz.core.QuizMode;
import quiz.eval.AutoGrader;
import quiz.eval.GradeReport;
import quiz.io.ConsoleIO;

public class Main {
    private final ConsoleIO io;

    public Main(ConsoleIO io) {
        this.io = io;
    }

    public static void main(String[] args) {
        Main app = new Main(new ConsoleIO());
        app.run();
    }

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = io.readInt("Seleccione una opcion: ");
            QuizMode mode = QuizMode.fromChoice(choice);
            switch (mode) {
                case OPTION_A:
                    runOptionA();
                    break;
                case OPTION_B:
                    runOptionB();
                    break;
                case AUTOGRADER:
                    runAutoGrader();
                    break;
                case EXIT:
                default:
                    running = false;
                    io.println("Hasta luego.");
                    break;
            }
        }
    }

    private void printMenu() {
        io.println("=== Menu ===");
        io.println("1) Resolver Opcion A");
        io.println("2) Resolver Opcion B");
        io.println("3) Autoevaluar (AutoGrader)");
        io.println("0) Salir");
    }

    private void runOptionA() {
        String line = io.readLine("Ingrese una linea con brackets: ");
        BracketBalancer balancer = new BracketBalancer();
        try {
            boolean ok = balancer.isBalanced(line);
            io.println("Resultado: " + (ok ? "Balanceado" : "No balanceado"));
        } catch (UnsupportedOperationException ex) {
            io.println("Esta opcion requiere implementacion del estudiante: " + ex.getMessage());
        }
    }

    private void runOptionB() {
        int dimension = io.readInt("Dimension del vector: ");
        SparseVector vector = new SparseVector(dimension);
        int entries = io.readInt("Cantidad de pares (indice, valor): ");
        for (int i = 0; i < entries; i++) {
            int index = io.readInt("Indice #" + (i + 1) + ": ");
            double value = io.readDouble("Valor #" + (i + 1) + ": ");
            vector.set(index, value);
        }
        io.println("Vector cargado:");
        io.println(vector.toString());
    }

    private void runAutoGrader() {
        AutoGrader grader = new AutoGrader();
        GradeReport report = grader.run();
        io.println(report.toString());
    }
}
