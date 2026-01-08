package quiz.eval;

import java.util.ArrayList;
import java.util.List;
import quiz.a.BracketBalancer;
import quiz.b.SparseVector;
import quiz.b.SparseVectorOps;

public class AutoGrader {
    public GradeReport run() {
        List<TestCase> cases = new ArrayList<>();
        cases.add(new TestCase("Balanceo de brackets", this::testBracketBalancer));
        cases.add(new TestCase("Producto punto", this::testDotProduct));
        cases.add(new TestCase("Suma de vectores", this::testVectorSum));

        GradeReport report = new GradeReport();
        for (TestCase testCase : cases) {
            report.add(testCase.execute());
        }
        return report;
    }

    private boolean testBracketBalancer() {
        BracketBalancer balancer = new BracketBalancer();
        return balancer.isBalanced("(a[b]{c})") && !balancer.isBalanced("(a[b]{c}");
    }

    private boolean testDotProduct() {
        SparseVector a = new SparseVector(5);
        a.set(1, 2.0);
        a.set(3, 4.0);
        SparseVector b = new SparseVector(5);
        b.set(1, 3.0);
        b.set(2, 5.0);
        return SparseVectorOps.dot(a, b) == 6.0;
    }

    private boolean testVectorSum() {
        SparseVector a = new SparseVector(4);
        a.set(0, 1.0);
        a.set(2, 2.0);
        SparseVector b = new SparseVector(4);
        b.set(2, 3.0);
        b.set(3, 4.0);
        SparseVector result = SparseVectorOps.add(a, b);
        return result.get(0) == 1.0 && result.get(2) == 5.0 && result.get(3) == 4.0;
    }
}
