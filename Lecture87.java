import java.util.Stack;

public class Lecture87 {
    public void redundantBrances(String str) {
        int answer = 0;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (isOperator(ch) || isOpeningBrancket(ch)) {
                st.push(ch);
            }

            if (ch == ')') {
                if (st.peek() == '(') {
                    answer++;
                } else {
                    st.pop();
                }
                st.pop();
                // while(!st.empty() && st.peek()=='('){

                // }
            }
        }
        return answer;
    }

    public static boolean isOperator(Character ch) {
        return ch == '*' || ch == '+' || ch == '/' || ch == '-';
    }

    public static boolean isOpeningBrancket(Character ch) {
        return ch == '{' || ch == '[' || ch == '(';
    }
}
