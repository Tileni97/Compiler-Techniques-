# Mini Java Compiler

This project is a mini Java compiler developed by [Gideon S.V](https://github.com/Shikongo19), [Tangi H.S Petrus](https://github.com/Supertangi), and [C. T Hango](https://github.com/Tileni97). The compiler is designed to take Java source code as input and generate corresponding assembly code or bytecode as output.

## Key Features

- **Lexical Analysis:** The compiler identifies and categorizes tokens (keywords, identifiers, operators, etc.) in the Java source code.
- **Syntax Analysis:** The compiler checks the grammatical structure of the code to ensure it adheres to the rules of the Java language.
- **Semantic Analysis:** The compiler performs additional checks to ensure the code is logically sound, such as type checking and symbol table management.
- **Code Generation:** The compiler translates the analyzed code into lower-level assembly code or bytecode that can be executed by a machine or virtual machine.
- **Code Optimization:** The compiler may apply various techniques to improve the efficiency of the generated code, such as eliminating redundant instructions or optimizing register usage.

## Team Members

- **Gideon S.V:** Responsible for Semantic Analysis and Intermediate Code Representation (ICR).
- **Tangi H.S Petrus:** Responsible for Code Generation and Code Optimization.
- **C. T Hango:** Responsible for Syntax Analysis and Lexical Analysis.

## How to Use

1. **Input:** Provide the Java source code file as input to the compiler.
2. **Compilation:** The compiler will process the input code, performing lexical, syntax, and semantic analysis.
3. **Output:** If the code is valid, the compiler will generate the corresponding assembly code or bytecode. If there are errors, the compiler will report them.

## Disclaimer

This is a mini compiler and may not support all features of the full Java language. It is intended for educational purposes and as a demonstration of compiler construction principles.
