import java.util.ArrayList;

class IntermediateCodeGenerator {
    public static String intermediateCodeGeneration(ArrayList<String> parseTree) {
        // Check if parse tree is null or empty
        if (parseTree == null || parseTree.isEmpty()) {
            System.out.println("Error: Parse tree is null or empty.");
            return null;
        }

        // Initialize intermediate code
        StringBuilder icg = new StringBuilder();

        // Generate intermediate code using BEDMAS priority sequence
        generateIntermediateCode(parseTree, icg);

        return icg.toString();
    }

    private static void generateIntermediateCode(ArrayList<String> parseTree, StringBuilder icg) {
        // Initialize temporary variables counter
        int tempCount = 1;

        // Perform BEDMAS priority sequence
        for (int i = 0; i < parseTree.size(); i++) {
            String node = parseTree.get(i);

            // Check for operators and perform BEDMAS prioritization
            if (node.equals("*") || node.equals("/")) {
                // Generate intermediate code for the expression
                String leftOperand = parseTree.get(i - 1);
                String rightOperand = parseTree.get(i + 1);
                String tempVariable = "T" + tempCount++;
                icg.append(tempVariable).append(" = ").append(leftOperand).append(" ").append(node).append(" ").append(rightOperand).append("\n");

                // Replace the expression with the temporary variable in the parse tree
                parseTree.set(i - 1, tempVariable);
                parseTree.remove(i); // Remove operator
                parseTree.remove(i); // Remove right operand

                // Adjust index after removing elements
                i--;
            }
        }

        // Generate intermediate code for remaining expressions
        for (int i = 0; i < parseTree.size(); i++) {
            String node = parseTree.get(i);
            // Check for addition and subtraction operators
            if (node.equals("+") || node.equals("-")) {
                // Generate intermediate code for the expression
                String leftOperand = parseTree.get(i - 1);
                String rightOperand = parseTree.get(i + 1);
                String tempVariable = "T" + tempCount++;
                icg.append(tempVariable).append(" = ").append(leftOperand).append(" ").append(node).append(" ").append(rightOperand).append("\n");

                // Replace the expression with the temporary variable in the parse tree
                parseTree.set(i - 1, tempVariable);
                parseTree.remove(i); // Remove operator
                parseTree.remove(i); // Remove right operand

                // Adjust index after removing elements
                i--;
            }
        }
    }
}
