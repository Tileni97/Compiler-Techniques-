import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizer3 {
    public static char t11;

    public static char t12;

    public static char t21;

    public static char t22;

    public static char t31;

    public static char t32;

    public static char t41;

    public static char t42;

    public static char a11;

    public static char a12;

    public static char strr;

    public static char strr3;

    public static String tt;

    public static String tt1;

    public static String tt2;

    public static String strr0;

    public static String str30;

    public static String str1;

    public static String str2;

    public static String str3;

    public static String mdiv;

    public static String ndiv;

    public static String mmult;

    public static String nmult;

    public static String mplus;

    public static String nplus;

    public static String mminus;

    public static String nminus;

    public static String space = " ";

    public static String ldiv1;

    public static String ldiv2;

    public static String ldiv3;

    public static String lmult1;

    public static String lmult2;

    public static String lmult3;

    public static String lplus1;

    public static String lplus2;

    public static String lplus3;

    public static String lminus1;

    public static String lminus2;

    public static String lminus3;

    public static int len2;

    public static int len3;

    public static int mult0 = 0;

    public static int mult1 = 0;

    public static int mult2 = 0;

    public static int jk;

    public static int icr = 0;

    public static int result1;

    public static int gt;

    public static int result11;

    public static void main(String[] args) {

        boolean r1 = false;
        boolean r3 = false;
        boolean r4 = false;
        boolean r5 = false;
        boolean r6 = false;
        boolean r8 = false;
        boolean r10 = false;
        boolean r11 = false;
        boolean r111 = false;
        int j = 0;
        boolean bmwC = false;
        boolean r15 = false;
        boolean r16 = false;
        boolean r17 = false;
        String plusk = "+";
        String divk = "/";
        String minusk = "-";
        String multk = "*";
        byte bmwA;
        int pp;
        int pp2, pp0;

        System.out.println("                        A MINI COMPILER PROJECT FOR CTE711S");
        for (int bmw = 1; bmw < 5000; bmw++) {

            String ninenine = "99";

            Scanner str = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("ENTER NEXT STRING  Num" + bmw);
            System.out.println("-Or Type 99 and press Enter to Quit:");
            str1 = str.nextLine();
            if (str1.contains(";"))
                str3 = str1.replace(';', ' ');
            try {
                Mobile calc = new Mobile();
                calc.processInput(str1);
            } catch (Exception var144) {
                System.out.println("Check your entering!");
            }
            System.out.println(" ");
            if (str1.isEmpty()) {
                j++;
                System.out.println("#" + j + " Error-Entering should not be empty!");
                r11 = true;
            }
            if (str1.contains(" ")) {
                j++;
                System.out.println("#" + j + " Spaces in between String will only show the result of arithmetic expression!");
                r111 = true;
            }
            if (str1.length() - 1 > 0) {
                strr = str1.charAt(str1.length() - 1);
                strr3 = str1.charAt(str1.length() - 2);
            }
            if (strr == '0') {
                r15 = true;
                j++;
                System.out.println("#" + j + " SYNTAX ERROR: Omitted semicolon (;) at the end of string");
            }
            if (strr == '+' || strr == '-' || strr == '*' || strr == '/' || strr3 == '+' || strr3 == '-' || strr3 == '*' || strr3 == '/') {
                r16 = true;
                j++;
                System.out.println("#" + j + " SYNTAX ERROR: A Number followed by semicolon (;) should end a string");
            }
            if (str1.equals(ninenine))
                System.exit(0);
            String strr0 = " ";
            String strr1 = " ";
            String zero0 = "0";
            String excla1 = "!";
            String dollar1 = "$";
            String perc1 = "%";
            String appasand = "&";
            String appasand2 = "&&";
            int len1 = str1.length();

            for (pp = 0; pp < len1; pp++) {

                if (str1.charAt(pp) == '_' || str1.charAt(pp) == '_'  || str1.charAt(pp) == '!' || str1.charAt(pp) == '#' || str1.charAt(pp) == ':' || str1.charAt(pp) == '.' || str1.charAt(pp) == '!' || str1.charAt(pp) == '$' || str1.charAt(pp) == '%' || str1.charAt(pp) == '&' || str1.charAt(pp) == '^' || str1.charAt(pp) == '?' || str1.charAt(pp) == '#' || str1.charAt(pp) == '@' || str1.charAt(pp) == '`' || str1.charAt(pp) == '<' || str1.charAt(pp) == '>' || str1.charAt(pp) == '{' || str1.charAt(pp) == '}' || str1.charAt(pp) == '(' || str1.charAt(pp) == ')' || str1.charAt(pp) == '|' || str1.charAt(pp) == '=' || str1.charAt(pp) == '"') {
                    r8 = true;
                    j++;
                    System.out.println("#" + j + " Semantic error: Use of Special Characters ie &, &&, $, %, !, etc, not permitted");
                }
                if (pp + 1 == len1) {
                    pp2 = len1 - 1;
                } else {
                    pp2 = pp + 1;
                }
                if (str1.charAt(pp) == '/' && str1.charAt(pp2) == '/') {
                    r6 = true;
                    j++;
                    System.out.println("#" + j + " SEMANTIC ERROR- Double front slash is a comment statement & not executed by Compiler!");
                }
                if (pp + 1 == len1) {
                    pp0 = len1 - 1;
                } else {
                    pp0 = pp + 1;
                }
                if ((Character.isDigit(str1.charAt(pp)) && Character.isDigit(str1.charAt(pp0))) || (str1.charAt(pp) == '*' && str1.charAt(pp0) == '-') || (str1.charAt(pp) == '*' && str1.charAt(pp0) == '+') || (str1.charAt(pp) == '*' && str1.charAt(pp0) == '/') || (str1.charAt(pp) == '-' && str1.charAt(pp0) == '+') || (str1.charAt(pp) == '+' && str1.charAt(pp0) == '/') || (str1.charAt(pp) == '+' && str1.charAt(pp0) == '*') || (str1.charAt(pp) == '/' && str1.charAt(pp0) == '*') || (str1.charAt(pp) == '*' && str1.charAt(pp0) == '+') || (str1.charAt(pp) == '-' && str1.charAt(pp0) == '*') || (str1.charAt(pp) == '/' && str1.charAt(pp0) == '+') || (str1.charAt(pp) == '/' && str1.charAt(pp0) == '-') || (str1.charAt(pp) == '-' && str1.charAt(pp0) == '-') || (str1.charAt(pp) == '+' && str1.charAt(pp0) == '+') || (str1.charAt(pp) == '*' && str1.charAt(pp0) == '*') || (str1.charAt(pp) == '1' && str1.charAt(pp0) == '1') || (str1.charAt(pp) == '2' && str1.charAt(pp0) == '2') || (str1.charAt(pp) == '3' && str1.charAt(pp0) == '3') || (str1.charAt(pp) == '4' && str1.charAt(pp0) == '4') || (str1.charAt(pp) == '5' && str1.charAt(pp0) == '5') || (str1.charAt(pp) == '6' && str1.charAt(pp0) == '6') || (str1.charAt(pp) == '7' && str1.charAt(pp0) == '7') || (str1.charAt(pp) == '8' && str1.charAt(pp0) == '8') || (str1.charAt(pp) == '9' && str1.charAt(pp0) == '9')) {
                    r10 = true;
                    j++;
                    System.out.println("#" + j + " SEMANTIC ERROR- two operators (*,-,+,/) or numbers (0,1,..9) cannot be written together! Moreso semicolon (;) is needed at the end of each line");
                }
                if (str1.charAt(pp) == '/' && str1.charAt(pp0) == '0') {
                    r17 = true;
                    j++;
                    System.out.println("#" + j + " SEMANTIC ERROR- Division by zero (0) not permitted");
                }
                if ((str1.charAt(pp) < 'a' || str1.charAt(pp) > 'z') && (str1.charAt(pp) < 'A' || str1.charAt(pp) > 'Z')) {
                    r5 = true;
                } else {
                    r4 = true;
                    j++;
                    System.out.println("#" + j + " SYNTAX ERROR: Alphabets a-z or A-Z not allowed. String should be Nos 0,1,2..9 & operators +,-,*,/");
                }
                if (len1 < 3) {
                    j++;
                    System.out.println("#" + j + " SEMANTIC ERROR: Input String should be more that 2 characters!");
                    r1 = true;
                }
                String myStr = Character.toString(str1.charAt(pp));
                strr0 = strr0.concat(myStr).concat(strr1);
            }
            boolean plusb = str1.contains(plusk);
            boolean divb = str1.contains(divk);
            boolean minusb = str1.contains(minusk);
            boolean multb = str1.contains(multk);
            if (!plusb && !divb && !minusb && !multb) {
                j++;
                System.out.println("#" + j + " Error-Invalid String! There is no operator in the String ( ie +, /, -, *,)");
                r3 = true;
            } else {
                String str1 = "0";
            }
            if (!r1 && !r3 && !r4 && !r6 && !r8 && !r10 && !r11 && !r111 && !r15 && !r16 && !r17) {
                bmwA = 2;
            } else {
                bmwA = 1;
                System.out.println("CONCLUSION-->Wrong expression: " + str1 + "  No Derivation done! PLS RE-ENTER A VALID STRING");
            }
            if (bmwA == 2) {
                str1 = strr0;
                StringTokenizer s = new StringTokenizer(str1, " ");
                StringTokenizer st = new StringTokenizer(str1, " ");
                StringTokenizer st1 = new StringTokenizer(str1, " ");
                new StringTokenizer(str1, " ");
                System.out.println("");
                CharSequence seq = ";";
                boolean bool = str1.contains(seq);
                System.out.println("  STAGE 1: LEXICAL ANALYSIS  ");
                System.out.println("SYMBOL  COMPRISING ATTRIBUTES AND TOKENS:");
                System.out.println("");
                String replace1 = " ";
                String replace3 = " ";
                String replace7c = " ";
                String replace14a = " ";
                String replace5 = " ";
                String replace7 = " ";
                String replace9 = " ";
                String replace13b = " ";
                String replace13d = " ";
                String replace11 = " ";
                String replace13 = " ";
                String replace16 = " ";
                String replace18 = " ";
                String replace20 = " ";
                String replace22 = " ";
                String replace23 = " ";
                String replace25 = " ";
                String replace27 = " ";
                String k0 = " ";
                String k1 = " ";
                String k2 = " ";
                String k3 = " ";
                String k4 = " ";
                String k5 = " ";
                String k6 = " ";
                String k7 = " ";
                String k8 = " ";
                String k9 = " ";
                String E0 = " ";
                String E1 = " ";
                String E2 = " ";
                String E3 = " ";
                String E4 = " ";
                String E5 = " ";
                String E6 = " ";
                String E7 = " ";
                String E8 = " ";
                String E9 = " ";
                String zero = "0";
                String one = "1";
                String two = "2";
                String three = "3";
                String four = "4";
                String five = "5";
                String six = "6";
                String seven = "7";
                String eight = "8";
                String nine = "9";
                while (s.hasMoreTokens()) {
                    String name0 = (String) s.nextElement();
                    if (name0.equals(zero)) {
                        E0 = name0;
                        k0 = "E0";
                    }
                    if (name0.equals(one)) {
                        E1 = name0;
                        k1 = "E1";
                    }
                    if (name0.equals(two)) {
                        E2 = name0;
                        k2 = "E2";
                    }
                    if (name0.equals(three)) {
                        E3 = name0;
                        k3 = "E3";
                    }
                    if (name0.equals(four)) {
                        E4 = name0;
                        k4 = "E4";
                    }
                    if (name0.equals(five)) {
                        E5 = name0;
                        k5 = "E5";
                    }
                    if (name0.equals(six)) {
                        E6 = name0;
                        k6 = "E6";
                    }
                    if (name0.equals(seven)) {
                        E7 = name0;
                        k7 = "E7";
                    }
                    if (name0.equals(eight)) {
                        E8 = name0;
                        k8 = "E8";
                    }
                    if (name0.equals(nine)) {
                        E9 = name0;
                        k9 = "E9";
                    }
                }
                int i = 0;
                boolean p = false;
                boolean p0 = false;
                boolean p1 = false;
                boolean p2 = false;
                boolean p3 = false;
                boolean p4 = false;
                boolean p8 = false;
                String ttype1 = " ";
                String ttype2 = " ";
                String ttype3 = " ";
                String ttype4 = " ";
                String ttype5 = " ";
                String ttype8 = " ";
                String semicolon = ";";
                String equal1 = "=";
                String E = "E";
                String minus = "-";
                String div = "/";
                String plus = "+";
                String mult = "*";
                String EQ = "=";
                String main1 = "main";
                String inte = "int";
                String openBracket = "(";
                String closeBracket = ")";
                String openBraces = "{";
                String closeBraces = "}";
                String multdiv = "*/";
                String adddiv = "+/";
                String subdiv = "-/";
                String addmult = "+*";
                String submult = "-*";
                String divmult = "/*";
                String subadd = "-+";
                String divadd = "/+";
                String multadd = "*+";
                String divsub = "+-";
                String multsub = "*-";
                String addsub = "+-";
                String slashzero = "/0";
                if (!bool)
                    p = true;
                while (true) {
                    if (!st.hasMoreTokens()) {
                        System.out.println("Total number of Tokens: " + st1.countTokens());
                        System.out.println("GIVEN THE GRAMMAR: E=E1 | E=E1*E2 | E=E1+E2 | E=digit | E={0,1,2,3,4,5,6,7,8,9}");
                        System.out.println(" ");
                        System.out.println("  STAGE2:  SYNTAX ANALYSIS-Parser ");
                        System.out.println("GET A DERIVATION FOR : " + str1);
                        String str1 = "";
                        str1 = str1.replace(E0, k0);
                        String str11 = str1.replace(E1, k1);
                        String str22 = str11.replace(E2, k2);
                        String str33 = str22.replace(E3, k3);
                        String str44 = str33.replace(E4, k4);
                        String str55 = str44.replace(E5, k5);
                        String str66 = str55.replace(E6, k6);
                        String str77 = str66.replace(E7, k7);
                        String str88 = str77.replace(E8, k8);
                        String str99 = str88.replace(E9, k9);
                        System.out.println(str99);
                        if (E0.equals(zero)) {
                            String replace28 = str99.replace("E0", "digit0");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E1.equals(one)) {
                            String replace28 = str99.replace("E1", "digit1");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E2.equals(two)) {
                            String replace28 = str99.replace("E2", "digit2");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E3.equals(three)) {
                            String replace28 = str99.replace("E3", "digit3");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E4.equals(four)) {
                            String replace28 = str99.replace("E4", "digit4");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E5.equals(five)) {
                            String replace28 = str99.replace("E5", "digit5");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E6.equals(six)) {
                            String replace28 = str99.replace("E6", "digit6");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E7.equals(seven)) {
                            String replace28 = str99.replace("E7", "digit7");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E8.equals(eight)) {
                            String replace28 = str99.replace("E8", "digit8");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E9.equals(nine)) {
                            String replace28 = str99.replace("E9", "digit9");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E0.equals(zero)) {
                            String replace28 = str99.replace("digit0", "0");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E1.equals(one)) {
                            String replace28 = str99.replace("digit1", "1");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E2.equals(two)) {
                            String replace28 = str99.replace("digit2", "2");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E3.equals(three)) {
                            String replace28 = str99.replace("digit3", "3");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E4.equals(four)) {
                            String replace28 = str99.replace("digit4", "4");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E5.equals(five)) {
                            String replace28 = str99.replace("digit5", "5");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E6.equals(six)) {
                            String replace28 = str99.replace("digit6", "6");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E7.equals(seven)) {
                            String replace28 = str99.replace("digit7", "7");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E8.equals(eight)) {
                            String replace28 = str99.replace("digit8", "8");
                            System.out.println(replace28);
                            str99 = replace28;
                        }
                        if (E9.equals(nine)) {
                            String replace28 = str99.replace("digit9", "9");
                            System.out.println(replace28);
                        }
                        System.out.println(" ");
                        System.out.println(" STAGE3: SEMANTIC ANALYSIS ");
                        if (p1) {
                            j++;
                            System.out.println("#" + j + ttype2);
                        }
                        if (p3) {
                            j++;
                            System.out.println("#" + j + ttype4);
                        }
                        if (p4) {
                            j++;
                            System.out.println("#" + j + ttype5);
                        }
                        if (!p1 && !p2 && !p3 && !p4) {
                            System.out.println("CONCLUSION-->This expression: " + str1 + " is Syntactically and Sematically correct");
                            icr = 1;
                        }
                        if (p1 || p2 || p3 || p4)
                            System.out.println("CONCLUSION-->This expression: " + str1 + " is Not Syntactically and/or Sematically correct. PLS RE-ENTER A VALID STRING!");
                        if (icr == 0) {
                            System.out.println("THERE ARE SYNTAX AND SEMANTIC ERRORS IN YOUR STRING! PLS REENTER A VALID STRING");
                            System.out.println("INTERMEDIATE CODE REPRESENTATION CANNOT BE DONE");
                            System.exit(0);
                        }
                        len3 = str3.length();
                        System.out.println(" ");
                        System.out.println(" STAGE4: INTERMEDIATE CODE REPRESENTATION (ICR) ");
                        System.out.println("THE STRING  ENTERED IS : " + str3);
                        System.out.println("The ICR is as follows:");
                        for (pp = 0; pp < len3; pp++) {
                            mult1 = 0;
                            mult2 = 0;
                            result1 = 0;
                            for (pp = 0; pp < len3; pp++) {
                                if (str3.charAt(pp) == '/') {
                                    t11 = str3.charAt(pp - 1);
                                    t12 = str3.charAt(pp + 1);
                                    j++;
                                    System.out.println("t" + j + "= " + t11 + str3.charAt(pp) + t12);
                                    ldiv1 = "LDA " + str3.charAt(pp + 1);
                                    ldiv2 = "DIV " + str3.charAt(pp - 1);
                                    ldiv3 = "STR t" + j;
                                    mdiv = "DIV t" + j + ", " + str3.charAt(pp + 1) + ", " + str3.charAt(pp - 1);
                                    ndiv = "001 011 11 " + Integer.toBinaryString(j);
                                }
                            }
                            for (pp = 0; pp < len3; pp++) {
                                mult1 = 0;
                                mult2 = 0;
                                if (str3.charAt(pp) == '*') {
                                    t21 = str3.charAt(pp - 1);
                                    t22 = str3.charAt(pp + 1);
                                    if (t21 == t11) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t21 == t12) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t21 == t31) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t21 == t32) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t21 == t41) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t21 == t42) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t22 == t11) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t22 == t12) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t22 == t31) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t22 == t32) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t22 == t41) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t22 == t42) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (mult2 == 2 && mult1 == 0) {
                                        j++;
                                        System.out.println("t" + j + "= " + t21 + str3.charAt(pp) + tt2);
                                        mmult = "MUL t" + j + ", " + t21 + ", " + tt2;
                                        lmult1 = "LDA " + t21;
                                        lmult2 = "MUL " + tt2;
                                        lmult3 = "STR t" + j;
                                    }
                                    if (mult1 == 1 && mult2 == 2) {
                                        j++;
                                        jk = j - 2;
                                        tt1 = "t" + jk;
                                        System.out.println("t" + j + "= " + tt1 + str3.charAt(pp) + tt2);
                                        mmult = "MUL t" + j + ", " + tt1 + ", " + tt2;
                                        lmult1 = "LDA " + tt1;
                                        lmult2 = "MUL " + tt2;
                                        lmult3 = "STR t" + j;
                                    }
                                    if (mult1 == 1 && mult2 == 0) {
                                        j++;
                                        System.out.println("t" + j + "= " + tt1 + str3.charAt(pp) + t22);
                                        mmult = "MUL t" + j + ", " + tt1 + ", " + t22;
                                        lmult1 = "LDA " + tt1;
                                        lmult2 = "MUL " + t22;
                                        lmult3 = "STR t" + j;
                                    }
                                    if (mult1 == 0 && mult2 == 0) {
                                        j++;
                                        System.out.println("t" + j + "= " + t21 + str3.charAt(pp) + t22);
                                        mmult = "MUL t" + j + ", " + t21 + ", " + t22;
                                        lmult1 = "LDA " + t21;
                                        lmult2 = "MUL " + t22;
                                        lmult3 = "STR t" + j;
                                    }
                                    nmult = "001 010 10 " + Integer.toBinaryString(j);
                                }
                            }
                            for (pp = 0; pp < len3; pp++) {
                                mult1 = 0;
                                mult2 = 0;
                                if (str3.charAt(pp) == '+') {
                                    t31 = str3.charAt(pp - 1);
                                    t32 = str3.charAt(pp + 1);
                                    if (t31 == t11) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t31 == t12) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t31 == t21) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t31 == t22) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t31 == t41) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t31 == t42) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t32 == t11) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t32 == t12) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t32 == t21) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t32 == t22) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t32 == t41) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t32 == t42) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (mult2 == 2 && mult1 == 0) {
                                        j++;
                                        System.out.println("t" + j + "= " + t31 + str3.charAt(pp) + tt2);
                                        mplus = "ADD t" + j + ", " + t31 + ", " + tt2;
                                        lplus1 = "LDA " + t31;
                                        lplus2 = "ADD " + tt2;
                                        lplus3 = "STR t" + j;
                                    }
                                    if (mult1 == 1 && mult2 == 2) {
                                        j++;
                                        jk = j - 2;
                                        tt1 = "t" + jk;
                                        System.out.println("t" + j + "= " + tt1 + str3.charAt(pp) + tt2);
                                        mplus = "ADD t" + j + ", " + tt1 + ", " + tt2;
                                        lplus1 = "LDA " + tt1;
                                        lplus2 = "ADD " + tt2;
                                        lplus3 = "STR t" + j;
                                    }
                                    if (mult1 == 1 && mult2 == 0) {
                                        j++;
                                        System.out.println("t" + j + "= " + tt1 + str3.charAt(pp) + t32);
                                        mplus = "ADD t" + j + ", " + tt1 + ", " + t32;
                                        lplus1 = "LDA " + tt1;
                                        lplus2 = "ADD " + t32;
                                        lplus3 = "STR t" + j;
                                    }
                                    if (mult1 == 0 && mult2 == 0) {
                                        j++;
                                        System.out.println("t" + j + "= " + t31 + str3.charAt(pp) + t32);
                                        mplus = "ADD t" + j + ", " + t31 + ", " + t32;
                                        lplus1 = "LDA " + t31;
                                        lplus2 = "ADD " + t32;
                                        lplus3 = "STR t" + j;
                                    }
                                    nplus = "001 010 11 " + Integer.toBinaryString(j);
                                }
                            }
                            for (pp = 0; pp < len3; pp++) {
                                if (str3.charAt(pp) == '-') {
                                    mult1 = 0;
                                    mult2 = 0;
                                    t41 = str3.charAt(pp - 1);
                                    t42 = str3.charAt(pp + 1);
                                    if (t41 == t11) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t41 == t12) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t41 == t21) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t41 == t22) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t41 == t31) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t41 == t32) {
                                        tt1 = "t" + j;
                                        mult1 = 1;
                                    }
                                    if (t42 == t11) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t42 == t12) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t42 == t21) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t42 == t22) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t42 == t31) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (t42 == t32) {
                                        tt2 = "t" + j;
                                        mult2 = 2;
                                    }
                                    if (mult2 == 2 && mult1 == 0) {
                                        j++;
                                        System.out.println("t" + j + "= " + t41 + str3.charAt(pp) + tt2);
                                        mminus = "SUB t" + j + ", " + t41 + ", " + tt2;
                                        lminus1 = "LDA " + t41;
                                        lminus2 = "SUB " + tt2;
                                        lminus3 = "STR t" + j;
                                    }
                                    if (mult1 == 1 && mult2 == 2) {
                                        j++;
                                        jk = j - 2;
                                        tt1 = "t" + jk;
                                        System.out.println("t" + j + "= " + tt1 + str3.charAt(pp) + tt2);
                                        mminus = "SUB t" + j + ", " + tt1 + ", " + tt2;
                                        lminus1 = "LDA " + tt1;
                                        lminus2 = "SUB " + tt2;
                                        lminus3 = "STR t" + j;
                                    }
                                    if (mult1 == 1 && mult2 == 0) {
                                        j++;
                                        System.out.println("t" + j + "= " + tt1 + str3.charAt(pp) + t42);
                                        mminus = "SUB t" + j + ", " + tt1 + ", " + t42;
                                        lminus1 = "LDA " + tt1;
                                        lminus2 = "SUB " + t42;
                                        lminus3 = "STR t" + j;
                                    }
                                    if (mult1 == 0 && mult2 == 0) {
                                        j++;
                                        System.out.println("t" + j + "= " + t41 + str3.charAt(pp) + t42);
                                        mminus = "SUB t" + j + ", " + t41 + ", " + t42;
                                        lminus1 = "LDA " + t41;
                                        lminus2 = "SUB " + t42;
                                        lminus3 = "STR t" + j;
                                    }
                                    nminus = "001 011 01 " + Integer.toBinaryString(j);
                                }
                            }
                        }
                        System.out.println("CONCLUSION-->The expression was correctly generated in ICR");
                        System.out.println(" ");
                        System.out.println("  STAGE 5: CODE GENERATION  ");
                        if (str3.contains("/"))
                            System.out.println(ldiv1);
                        System.out.println(ldiv2);
                        System.out.println(ldiv3);
                        if (str3.contains("*"))
                            System.out.println(lmult1);
                        System.out.println(lmult2);
                        System.out.println(lmult3);
                        if (str3.contains("+"))
                            System.out.println(lplus1);
                        System.out.println(lplus2);
                        System.out.println(lplus3);
                        if (str3.contains("-"))
                            System.out.println(lminus1);
                        System.out.println(lminus2);
                        System.out.println(lminus3);
                        System.out.println(" ");
                        System.out.println("  STAGE 6: CODE OPTIMISATION  ");
                        if (str3.contains("/"))
                            System.out.println(mdiv);
                        if (str3.contains("*"))
                            System.out.println(mmult);
                        if (str3.contains("+"))
                            System.out.println(mplus);
                        if (str3.contains("-"))
                            System.out.println(mminus);
                        System.out.println(" ");
                        System.out.println("   STAGE 7: TARGET MACHINE CODE ");
                        if (str3.contains("/"))
                            System.out.println(ndiv);
                        if (str3.contains("*"))
                            System.out.println(nmult);
                        if (str3.contains("+"))
                            System.out.println(nplus);
                        if (str3.contains("-"))
                            System.out.println(nminus);
                        System.out.println(" ");
                        System.out.println(" END OF COMPILATION ");
                        break;
                    }
                    i++;
                    String name1 = (String) st.nextElement();
                    if (name1.equals(EQ) || name1.equals(openBracket) || name1.equals(closeBracket) || name1.equals(openBraces) || name1.equals(closeBraces))
                        ttype1 = "Symbol";
                    if (name1.equals(zero) || name1.equals(E) || name1.equals(one) || name1.equals(two) || name1.equals(three) || name1.equals(four) || name1.equals(five) || name1.equals(six) || name1.equals(seven) || name1.equals(seven) || name1.equals(eight) || name1.equals(nine))
                        ttype1 = "identifier";
                    if (name1.equals(div) || name1.equals(minus) || name1.equals(plus) || name1.equals(mult))
                        ttype1 = "Operator";
                    if (name1.equals(semicolon) || name1.equals(equal1)) {
                        p8 = true;
                        ttype1 = "symbol";
                    }
                    if (name1.equals(main1) || name1.equals(inte))
                        ttype1 = "keywords";
                    if (name1.equals(multdiv) || name1.equals(adddiv) || name1.equals(subdiv) || name1.equals(addmult) || name1.equals(submult) || name1.equals(divmult) || name1.equals(subadd) || name1.equals(divadd) || name1.equals(multadd) || name1.equals(divsub) || name1.equals(multsub) || name1.equals(addsub)) {
                        p1 = true;
                        ttype2 = "Semantic error: Use of two operators together ie */, +*, *-, +s, etc, not permitted";
                    }
                    if (name1.equals(slashzero)) {
                        p3 = true;
                        ttype4 = " Semantic error: division by zero ie 6/0, not permitted";
                    }
                    if (p) {
                        p4 = true;
                        ttype5 = " Syntax Error: every line must end with a semicolon (;), not permitted";
                    }
                    System.out.println("TOKEN NUM IS: " + i + " " + name1 + " " + ttype1);
                }
            }
            System.out.println(" THE ORIGINAL INPUT STRING IS: " + str1);
        }
    }
}

