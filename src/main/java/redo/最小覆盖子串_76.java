package redo;

public class 最小覆盖子串_76 {
  public String minWindow(String s, String t) {
    int minLen = s.length() + 1, minL = -1;
    int[] tcnt = new int['z' - 'A' + 1];
    int[] windowcnt = new int['z' - 'A' + 1];
    for(char c : t.toCharArray()) {
      tcnt[c - 'A'] ++;
    }
    int l = 0, r = 0, sLen = s.length();
    while(r < sLen) {
      int wcIndex = s.charAt(r) - 'A';
      windowcnt[wcIndex] ++;
      while(containsAll(tcnt, windowcnt)) {
        int len = r - l + 1;
        if(minLen > len) {
          minLen = len;
          minL = l;
        }
        windowcnt[s.charAt(l ++) - 'A'] --;
      }
      r ++;
    }
    if(minLen == s.length() + 1) return "";
    return s.substring(minL, minLen + minL);
  }

  private boolean containsAll(int[] t, int[] s) {
    for(int i = 0; i < t.length; i++) {
      if(t[i] != 0 && t[i] > s[i]){
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    最小覆盖子串_76 s = new 最小覆盖子串_76();
    s.minWindow( "a",  "a");
  }
}
