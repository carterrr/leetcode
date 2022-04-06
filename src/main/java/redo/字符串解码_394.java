
public class 字符串解码_394 {

}
class Solution {
    public String decodeString(String s) {
        // 碰到【 入栈字母  碰到 】出栈字母并计算
        Deque<String> cStack = new LinkedList<>();   // 存储的是[ 后  数字前的字符串  如  2[ab3[cd4[ef]]] 中的ab  cd  依次入栈  
        Deque<Integer> nStack = new LinkedList<>();  // 存储的是[ 前的数字  如上例中的 2 3 4
        char[] arr = s.toCharArray();
        // 难点  数字可能不止一位数
        int num = 0;
        String piece = "";
        for(char c : arr) {
            if ( c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                nStack.push(num);
                cStack.push(piece);
                num = 0;
                piece = "";
            } else if (c == ']') {
                String inner = piece;
                int cnt = nStack.pop() - 1;
                for(int i = 0 ; i < cnt; i ++) {
                    piece += inner;
                }
                piece = cStack.pop() + piece;
            } else {
                piece += c;
            }
        }
        return piece;
    }
}