/* ---------------- CHAR STACK ---------------- */
class CharStack {
    private char[] data;
    private int size;

    CharStack() {
        data = new char[10];
        size = 0;
    }

    public boolean empty() {
        return size == 0;
    }

    void push(char x) {
        if (size == data.length) {
            int newCapacity = data.length * 2;
            char[] newData = new char[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size] = x;
        size++;
    }

    char pop() {
        if (size == 0) return '\0';
        char topValue = data[size - 1];
        size--;
        return topValue;
    }

    char top() {
        if (size == 0) return '\0';
        return data[size - 1];
    }
}

/* --------------- MATCH HELPER --------------- */
class MatcherHelper {
    static boolean matches(char close, char open) {
        return (close == ')' && open == '(') ||
                (close == '}' && open == '{') ||
                (close == ']' && open == '[');
    }
}

/* ------- IS BALANCED PARENTHESES -------- */
class IsBalanacedParentheses {

    public static boolean isBalanacedParentheses(String s) {
        if (s == null) return false;

        CharStack stack = new CharStack();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Açılış karakterlerini stack'e koy
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            // Kapanış karakterleri
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.empty()) return false;  // Eşleşecek açılış yok

                char open = stack.pop();
                if (!MatcherHelper.matches(ch, open)) {
                    return false;
                }
            }

            // Geçersiz karakter varsa
            else {
                return false;
            }
        }

        // Stack boşsa dengeli
        return stack.empty();
    }
}