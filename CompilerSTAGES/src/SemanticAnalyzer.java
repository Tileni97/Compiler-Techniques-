import java.util.ArrayList;

class SemanticAnalyzer {
    private static final String OPERATORS = "+-*/";

    public static boolean semanticAnalysis(ArrayList<String> parseTree) {
        // Loop through the parse tree to perform semantic analysis
        for (String node : parseTree) {
            if (isOperator(node)) {
                // Check if two operators are combined
                if (node.length() > 1) {
                    System.out.println("Syntax error: Two operators cannot be combined: " + node);
                    return false;
                }
            } else if (!isKeyword(node) && !isIdentifier(node)) {
                // Check if the node is neither a keyword nor an identifier
                //System.out.println("Syntax error: Invalid token: " + node);
                return false;
            }
        }

        return true;
    }

    // Check if a token is an operator
    private static boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    // Check if a token is a keyword
    private static boolean isKeyword(String token) {
        for (String keyword : Compiler.KEYWORDS) {
            if (keyword.equals(token)) {
                return true;
            }
        }
        return false;
    }

    // Check if a token is an identifier
    private static boolean isIdentifier(String token) {
        return LexicalAnalyzer.isIdentifier(token);
    }
}
