import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Compiler {
    public static final String[] KEYWORDS = {"INTEGER", "ASSIGN", "READ", "WRITE", "START", "STOP"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = "";

        while (true) {
            System.out.print("Enter an expression or enter '99' to exit: ");
            expression = scanner.nextLine();

            if (expression.equals("99")) {
                break;
            }

            if (expression.endsWith(";")) {
                expression = expression.substring(0, expression.length() - 1);
            }

            List<Token> tokens = LexicalAnalyzer.lexicalAnalysis(expression);
            if (tokens == null) {
                continue; // Skip to next iteration if there was a syntax error
            }

            ArrayList<String> parseTree = SyntaxAnalyzer.syntaxAnalysis(tokens);
            if (parseTree == null) {
                continue; // Skip to next iteration if there was a syntax error
            }

            SemanticAnalyzer.semanticAnalysis(parseTree);
            String icg = IntermediateCodeGenerator.intermediateCodeGeneration(parseTree);
            String codeGeneration = CodeGenerator.generateCode(icg);
            String optimizedCode = CodeOptimizer.optimizeCode(codeGeneration);
            String binaryCode = BinaryCodeGenerator.generateBinaryCode(optimizedCode);


            LexicalAnalyzer.printTokens(tokens);

            System.out.println("\nStage 2: Syntax Analysis");
            SyntaxAnalyzer.printParseTree(parseTree);

            System.out.println("\nStage 3: Semantic Analysis");
            // Display semantic analysis conclusion
            System.out.println("CONCLUSION-->This expression: " + expression + " is Syntactically and Semantically correct.");

            System.out.println("\nStage 4: Intermediate Code Generation");
            System.out.println(icg);

            System.out.println("\nStage 5: Code Generation");
            System.out.println(codeGeneration);

            System.out.println("\nStage 6: Code Optimization");
            System.out.println(optimizedCode);

            System.out.println("\nStage 7: Target Machine Code");
            System.out.println(binaryCode);
        }
    }
}
