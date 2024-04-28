import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LexicalAnalyzer {
    private static final String OPERATORS = "+-*/";
    private static final Pattern IDENTIFIER_PATTERN = Pattern.compile("^[a-zA-Z]+$");

    public static List<Token> lexicalAnalysis(String expression) {
        List<Token> tokens = new ArrayList<>();
        int index = 0;

        // Loop through the expression to tokenize it
        while (index < expression.length()) {
            char c = expression.charAt(index);

            // Ignore whitespace
            if (Character.isWhitespace(c)) {
                index++;
                continue;
            }

            // Check for operators
            if (OPERATORS.indexOf(c) != -1) {
                tokens.add(new Token(TokenType.OPERATOR, Character.toString(c)));
                index++;
            } else if (Character.isDigit(c)) {
                // Numbers are not allowed
                System.out.println("Syntax error: Numbers are not allowed.");
                return null;
            } else if (!Character.isLetter(c)) {
                // Any other character is not allowed
                System.out.println("Syntax error: Invalid character: " + c);
                return null;
            }
            else {
                // Tokenize identifiers
                int start = index;
                while (index < expression.length() && Character.isLetter(expression.charAt(index))) {
                    index++;
                }
                String word = expression.substring(start, index);
                if (isKeyword(word)) {
                    // Check if the word is a keyword
                    tokens.add(new Token(TokenType.KEYWORD, word));
                } else if (isIdentifier(word)) {
                    // Check if the word is a valid identifier
                    tokens.add(new Token(TokenType.IDENTIFIER, word));
                } else {
                    // Any other character is not allowed
                    System.out.println("Syntax error: Invalid character: " + word);
                    return null;
                }
            }
        }

        return tokens;
    }

    // Check if a word is a keyword
    private static boolean isKeyword(String word) {
        // Define the list of valid keywords
        String[] keywords = {"INTEGER", "ASSIGN", "READ", "WRITE", "START", "STOP"};
        for (String keyword : keywords) {
            if (keyword.equals(word)) {
                return true;
            }
        }
        return false;
    }

    // Check if a word is a valid identifier
    static boolean isIdentifier(String word) {
        return IDENTIFIER_PATTERN.matcher(word).matches() && word.length() == 1;
    }

    // Method to print tokens (for debugging)
    public static void printTokens(List<Token> tokens) {

        System.out.println("Stage 1: Compiler Techniques --> Lexical Analysis - Scanner");
        // Display input string if needed
        // System.out.println("Input String: " + inputString);

        System.out.println("Symbol Table comprising attributes and tokens:");
        if (tokens != null) {
            for (int i = 0; i < tokens.size(); i++) {
                Token token = tokens.get(i);
                System.out.println("TOKEN#" + (i + 1) + " " + token.getValue() + " " + getTokenType(token.getType()));
            }
            System.out.println("Total number of Tokens: " + tokens.size());
        } else {
            System.out.println("Syntax error: Invalid expression.");
        }
    }

    // Method to get the token type as a string
    private static String getTokenType(TokenType type) {
        switch (type) {
            case KEYWORD:
                return "Keyword";
            case IDENTIFIER:
                return "Identifier";
            case OPERATOR:
                return "Operator";
            default:
                return "Unknown";
        }
    }
}
