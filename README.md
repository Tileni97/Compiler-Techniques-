Mini-Compiler for V Language
This project focuses on developing a mini-compiler in Java for a simplified programming language called "V language." The compiler is designed to process input code and translate it into machine-executable code through various stages of compilation.

Key Features:

Lexical Analysis (Scanner): Identifies and categorizes tokens (keywords, identifiers, operators, symbols) in the input code.
Syntax Analysis (Parser): Checks the grammatical structure of the code based on the defined rules of the V language.
Semantic Analysis: Interprets the meaning of the code and checks for semantic errors (e.g., type mismatches, invalid operations).
Intermediate Code Representation (ICR): Generates a simplified intermediate representation of the code for further processing.
Code Generation (CG): Translates the intermediate code into target machine code (binary code).
Code Optimization (CO): Optionally improves the efficiency of the generated machine code.
Target Machine Code (TMC): The final binary code that can be executed by the machine.
Input Processing:

The compiler can process the input code in two ways:

Line by Line (Iteratively): Each line of code is processed sequentially.
All at Once: The entire code is processed as a whole.
Error Handling:

The compiler includes error handling mechanisms to detect and report various types of errors:

Lexical Errors: Invalid characters or tokens.
Syntax Errors: Incorrect grammar or structure.
Semantic Errors: Invalid operations or type mismatches.
V Language Rules:

The V language has specific rules regarding allowed keywords, identifiers, operators, symbols, and disallowed characters/combinations. These rules are strictly enforced by the compiler.

Note:

Only lines 6 and 7 of the provided sample code undergo all seven stages of compilation. The other lines are only checked for errors.

This project aims to provide a practical understanding of compiler construction and the various stages involved in translating a high-level programming language into machine-executable code.
