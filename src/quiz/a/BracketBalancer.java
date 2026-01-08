package quiz.a;

public class BracketBalancer {
    public static final class BalanceResult {
        public final boolean balanced;
        public final String message;
        public final int errorIndex;
        public final char expected;
        public final char found;

        public BalanceResult(boolean balanced, String message, int errorIndex, char expected, char found) {
            this.balanced = balanced;
            this.message = message;
            this.errorIndex = errorIndex;
            this.expected = expected;
            this.found = found;
        }
    }

    public static BalanceResult check(String expression) {
        if (expression == null) {
            return new BalanceResult(false, "expresión nula", -1, '\0', '\0');
        }

        Stack<Character> stack = new ArrayStack<>();

        // TODO_ESTUDIANTE: implementar
        for (int i = 0; i < expression.length(); i++) {
            char current = expression.charAt(i);
            if (isOpening(current)) {
                stack.push(current);
            } else if (isClosing(current)) {
                if (stack.isEmpty()) {
                    return new BalanceResult(false, "cierre sin apertura", i, matchingOpening(current), current);
                }
                char opening = stack.pop();
                if (!isMatchingPair(opening, current)) {
                    return new BalanceResult(false, "par no coincide", i, matchingClosing(opening), current);
                }
            }
        }
        if (!stack.isEmpty()) {
            char opening = stack.pop();
            return new BalanceResult(false, "falta cierre", expression.length(), matchingClosing(opening), '\0');
        }

        return new BalanceResult(true, "equilibrada", -1, '\0', '\0');
    }

    public boolean isBalanced(String input) {
        return check(input).balanced;
    }

    private static boolean isOpening(char value) {
        return value == '(' || value == '[' || value == '{';
    }

    private static boolean isClosing(char value) {
        return value == ')' || value == ']' || value == '}';
    }

    private static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')')
                || (opening == '[' && closing == ']')
                || (opening == '{' && closing == '}');
    }

    private static char matchingClosing(char opening) {
        switch (opening) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
            default:
                return '\0';
        }
    }

    private static char matchingOpening(char closing) {
        switch (closing) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                return '\0';
        }
    }
}
