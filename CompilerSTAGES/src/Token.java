enum TokenType {
    KEYWORD, IDENTIFIER, OPERATOR
}

class Token {
    private final TokenType type;
    private final String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    // Getter method to retrieve the value of the token
    public String getValue() {
        return value;
    }

    // Getter method to retrieve the type of the token
    public TokenType getType() {
        return type;
    }
}
