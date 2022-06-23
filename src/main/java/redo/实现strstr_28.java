package redo;

public class 实现strstr_28 {
  public static void main(String[] args) {
    实现strstr_28 s = new 实现strstr_28();
    s.strStr("hello",
        "ll");
  }

  /**
   * https://www.zhihu.com/question/21923021/answer/281346746
   */
  public int kmp(String a, String b) {

    char[] aa = a.toCharArray();
    char[] ab = b.toCharArray();
    int[] next = new int[ab.length];
    // 自身后面部分 匹配自身前缀
    next[0] = -1;
    int i = 0, j = -1;
    while (i < ab.length - 1) { // -1 防止越界
      if(j == -1 || ab[i] == ab[j]) {
        i++; j++;
        next[i] = j;// i无论如何不会回退  最多就是next[1] = 0;
      } else {
        j = next[j]; // j回退到前一个相同前后缀的位置
      }

    }
    i = 0; j = 0;
    while(i < aa.length && j < ab.length) {
      if(j == -1 || aa[i] == ab[j]) {
        i++; j++;
      } else {
        j = next[j];// 回退到j = 0时 下一次会都后移
      }
    }
    if(j == ab.length) return i - j;
    return -1;
  }






  // hash滑动窗口法
  public int strStr(String haystack, String needle) {
    int l = needle.length(), r = haystack.length() - 1,win = needle.length();
    int targetHash = 0, winHash = 0;
    for(int i = 0; i< needle.length(); i++) {
      winHash += haystack.charAt(i) - 'a';
      targetHash += needle.charAt(i) - 'a';
    }
    if(winHash == targetHash && equals(haystack, needle, 0)) {
      return 0;
    }
    for(int i = l; i <= r; i++) {
      winHash += (haystack.charAt(i) - 'a');
      winHash -= (haystack.charAt(i - win) - 'a');
      if(winHash == targetHash && equals(haystack, needle, i - win + 1)) {
        return i - win + 1;
      }
    }
    return -1;
  }

  private boolean equals(String haystack, String needle, int l) {
    for(int i = 0; i < needle.length(); i++) {
      if(haystack.charAt(l + i) != needle.charAt(i)) return false;
    }
    return true;
  }
}
