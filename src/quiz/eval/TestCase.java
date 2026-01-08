package quiz.eval;

public class TestCase {
    @FunctionalInterface
    public interface TestLogic {
        boolean run() throws Exception;
    }

    private final String name;
    private final TestLogic logic;

    public TestCase(String name, TestLogic logic) {
        this.name = name;
        this.logic = logic;
    }

    public String getName() {
        return name;
    }

    public TestResult execute() {
        try {
            boolean passed = logic.run();
            return new TestResult(name, passed, passed ? "OK" : "Resultado incorrecto");
        } catch (UnsupportedOperationException ex) {
            return new TestResult(name, false, "No implementado: " + ex.getMessage());
        } catch (Exception ex) {
            return new TestResult(name, false, "Error: " + ex.getMessage());
        }
    }

    public static class TestResult {
        private final String name;
        private final boolean passed;
        private final String message;

        public TestResult(String name, boolean passed, String message) {
            this.name = name;
            this.passed = passed;
            this.message = message;
        }

        public String getName() {
            return name;
        }

        public boolean isPassed() {
            return passed;
        }

        public String getMessage() {
            return message;
        }
    }
}
