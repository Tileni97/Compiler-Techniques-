import java.util.ArrayList;
import java.util.List;

class SyntaxAnalyzer {
    private static int ruleCounter = 1;

    public static ArrayList<String> syntaxAnalysis(List<Token> tokens) {
        // List to store the parse tree
        ArrayList<String> parseTree = new ArrayList<>();
        int index = 0;

        // Initial rule
        parseTree.add("E");
        parseTree.add("\t\t\tR" + ruleCounter);
        ruleCounter++;

        // Loop through the tokens to construct the parse tree
        while (index < tokens.size()) {
            Token token = tokens.get(index);
            // Add the token value to the parse tree
            parseTree.add(token.getValue());
            index++;
            if (index < tokens.size()) {
                // Append the production rule used
                parseTree.add("\t\t\tR" + ruleCounter);
                ruleCounter++;
            }
        }

        // Append the final string indicating the completion of the derivation
        parseTree.add("The final string");

        return parseTree;
    }

    // Method to reset the rule counter (for testing)
    public static void resetRuleCounter() {
        ruleCounter = 1;
    }

    // Method to print the parse tree (for debugging)
    public static void printParseTree(ArrayList<String> parseTree) {
        for (String node : parseTree) {
            System.out.println(node);
        }
    }
}
