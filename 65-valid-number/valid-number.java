
class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        boolean digitAfterExp = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= '0' && ch <= '9') {
                seenDigit = true;

                if (seenExp) {
                    digitAfterExp = true;
                }
            } 
            else if (ch == '+' || ch == '-') {
                // Sign is allowed only at the beginning
                // or immediately after e/E
                if (i > 0 && s.charAt(i - 1) != 'e'
                         && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } 
            else if (ch == '.') {
                // Dot cannot appear twice or after exponent
                if (seenDot || seenExp) {
                    return false;
                }
                seenDot = true;
            } 
            else if (ch == 'e' || ch == 'E') {
                // Exponent must follow a digit
                if (seenExp || !seenDigit) {
                    return false;
                }
                seenExp = true;
                digitAfterExp = false;
            } 
            else {
                return false;
            }
        }

        return seenDigit && digitAfterExp;
    }
}
