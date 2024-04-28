class CodeGenerator {
    public static String generateCode(String icg) {
        StringBuilder codeBuilder = new StringBuilder();

        // Split the intermediate code into individual instructions
        String[] instructions = icg.split("\n");

        for (String instruction : instructions) {
            String[] parts = instruction.split("=");
            if (parts.length != 2) {
                System.out.println("Syntax error: Invalid intermediate code instruction: " + instruction);
                return null;
            }
            String destRegister = parts[0].trim();
            String expression = parts[1].trim();

            // Handle different types of expressions
            if (expression.contains("+")) {
                String[] operands = expression.split("\\+");
                codeBuilder.append("LDA ").append(operands[0].trim()).append("\n");
                codeBuilder.append("ADD ").append(operands[1].trim()).append("\n");
                codeBuilder.append("STA ").append(destRegister).append("\n");
            } else if (expression.contains("-")) {
                String[] operands = expression.split("-");
                codeBuilder.append("LDA ").append(operands[0].trim()).append("\n");
                codeBuilder.append("SUB ").append(operands[1].trim()).append("\n");
                codeBuilder.append("STA ").append(destRegister).append("\n");
            } else if (expression.contains("*")) {
                String[] operands = expression.split("\\*");
                codeBuilder.append("LDA ").append(operands[0].trim()).append("\n");
                codeBuilder.append("MUL ").append(operands[1].trim()).append("\n");
                codeBuilder.append("STA ").append(destRegister).append("\n");
            } else if (expression.contains("/")) {
                String[] operands = expression.split("/");
                codeBuilder.append("LDA ").append(operands[0].trim()).append("\n");
                codeBuilder.append("DIV ").append(operands[1].trim()).append("\n");
                codeBuilder.append("STA ").append(destRegister).append("\n");
            } else {
                // Handle other types of expressions or operands as needed
                System.out.println("Syntax error: Invalid intermediate code expression: " + expression);
                return null;
            }
        }

        return codeBuilder.toString();
    }
}
