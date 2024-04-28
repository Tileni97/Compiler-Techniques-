import java.util.ArrayList;

class BinaryCodeGenerator {
    public static String generateBinaryCode(String optimizedCode) {
        // Split the optimized code into individual lines
        String[] lines = optimizedCode.split("\n");
        StringBuilder binaryCodeBuilder = new StringBuilder();

        // Loop through each line and convert the first letter of each string to binary
        for (String line : lines) {
            String[] tokens = line.split(" "); // Split each line into tokens
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    char firstLetter = token.charAt(0); // Get the first letter of the token
                    String binaryRepresentation = getBinaryRepresentation(firstLetter); // Get binary representation
                    binaryCodeBuilder.append(binaryRepresentation).append(" "); // Append to binary code with space separator
                }
            }
        }

        // Remove trailing space and return the binary code
        return binaryCodeBuilder.toString().trim();
    }

    // Method to get the binary representation of a letter
    private static String getBinaryRepresentation(char letter) {
        // Define the binary representations of each letter
        switch (letter) {
            case 'A': return "01000001";
            case 'B': return "01000010";
            case 'C': return "01000011";
            case 'D': return "01000100";
            case 'E': return "01000101";
            case 'F': return "01000110";
            case 'G': return "01000111";
            case 'H': return "01001000";
            case 'I': return "01001001";
            case 'J': return "01001010";
            case 'K': return "01001011";
            case 'L': return "01001100";
            case 'M': return "01001101";
            case 'N': return "01001110";
            case 'O': return "01001111";
            case 'P': return "01010000";
            case 'Q': return "01010001";
            case 'R': return "01010010";
            case 'S': return "01010011";
            case 'T': return "01010100";
            case 'U': return "01010101";
            case 'V': return "01010110";
            case 'W': return "01010111";
            case 'X': return "01011000";
            case 'Y': return "01011001";
            case 'Z': return "01011010";
            case 'a': return "01100001";
            case 'b': return "01100010";
            case 'c': return "01100011";
            case 'd': return "01100100";
            case 'e': return "01100101";
            case 'f': return "01100110";
            case 'g': return "01100111";
            case 'h': return "01101000";
            case 'i': return "01101001";
            case 'j': return "01101010";
            case 'k': return "01101011";
            case 'l': return "01101100";
            case 'm': return "01101101";
            case 'n': return "01101110";
            case 'o': return "01101111";
            case 'p': return "01110000";
            case 'q': return "01110001";
            case 'r': return "01110010";
            case 's': return "01110011";
            case 't': return "01110100";
            case 'u': return "01110101";
            case 'v': return "01110110";
            case 'w': return "01110111";
            case 'x': return "01111000";
            case 'y': return "01111001";
            case 'z': return "01111010";
            default: return ""; // Return empty string for unknown characters
        }
    }
}
