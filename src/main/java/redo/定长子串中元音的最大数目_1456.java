package redo;

public class 定长子串中元音的最大数目_1456 {


  public static void main(String[] args) {
    定长子串中元音的最大数目_1456 s = new 定长子串中元音的最大数目_1456();
    s.maxVowels("abciiidef",
        3);
  }

  public int maxVowels(String s, int k) {
    char[] sc = s.toCharArray();
    int len = sc.length, r = 0, win = 0, max = 0;
    if(k > len) k = len;
    while(r < k) {
      if(isVowel(sc[r++])) {
        win++;
      }
    }
    max = win;
    // 如果 开始的时候k > len 这里就会有r = k = len 不会进入while
    while(r < len) {
      if(isVowel(sc[r - k])) {
        win--;
      }
      if(isVowel(sc[r++])) {
        win ++;
      }
      max = Math.max(max, win);
    }
    return max;
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i'|| c == 'o'|| c == 'u';
  }
}
