package quiz.eval;

import java.util.ArrayList;
import java.util.List;

public class GradeReport {
    private final List<TestCase.TestResult> results = new ArrayList<>();

    public void add(TestCase.TestResult result) {
        results.add(result);
    }

    public List<TestCase.TestResult> getResults() {
        return new ArrayList<>(results);
    }

    public int countPassed() {
        int passed = 0;
        for (TestCase.TestResult result : results) {
            if (result.isPassed()) {
                passed++;
            }
        }
        return passed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Reporte de Autoevaluacion ===\n");
        for (TestCase.TestResult result : results) {
            sb.append(result.isPassed() ? "[OK] " : "[FAIL] ")
                .append(result.getName())
                .append(" -> ")
                .append(result.getMessage())
                .append("\n");
        }
        sb.append("Resultado: ")
            .append(countPassed())
            .append("/")
            .append(results.size())
            .append(" pruebas pasaron.\n");
        return sb.toString();
    }
}
