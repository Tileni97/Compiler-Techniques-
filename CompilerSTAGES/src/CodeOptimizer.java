class CodeOptimizer {
    public static String optimizeCode(String codeGeneration) {
        // Check if the code generation result is null
        if (codeGeneration == null) {
            System.out.println("Error: Code generation failed. Cannot optimize null code.");
            return null;
        }

        StringBuilder optimizedCode = new StringBuilder();

        // Split the code into individual instructions
        String[] instructions = codeGeneration.split("\n");

        for (String instruction : instructions) {
            // Split each instruction into its components
            String[] parts = instruction.trim().split(" ");

            // Extract the operation and operands
            String operation = parts[0];
            String[] operands = new String[3];
            for (int i = 1; i < parts.length; i++) {
                operands[i - 1] = parts[i];
            }

            // Optimize the instruction format
            String optimizedInstruction = optimizeInstruction(operation, operands);
            optimizedCode.append(optimizedInstruction).append("\n");
        }

        return optimizedCode.toString().trim();
    }

    private static String optimizeInstruction(String operation, String[] operands) {
        // Perform optimization based on the operation
        switch (operation) {
            case "LDA":
                return "DIV " + operands[2] + ", " + operands[1] + ", " + operands[0];
            case "MUL":
                return "MUL " + operands[2] + ", " + operands[0] + ", " + operands[1];
            case "ADD":
                return "ADD " + operands[2] + ", " + operands[1] + ", " + operands[0];
            case "SUB":
                return "SUB " + operands[2] + ", " + operands[0] + ", " + operands[1];
            // Add cases for other operations if needed
            default:
                return operation + " " + String.join(", ", operands);
        }
    }
}
