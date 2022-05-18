package redo;

public class 可获得的最大点数_1423 {
  public static void main(String[] args) {
    可获得的最大点数_1423 s = new 可获得的最大点数_1423();
    s.maxScore(new int[]{1,1000,1},
    1);
  }

  public int maxScore(int[] cardPoints, int k) {
    int windowLen = cardPoints.length - k;

    int cardPointsSum = 0;
    for(int c : cardPoints) {
      cardPointsSum += c;
    }
    if(windowLen == 0) return cardPointsSum;
    int min = cardPointsSum, windowSum = 0,  r = 0;

    while(r < windowLen) {
      windowSum += cardPoints[r++];
    }
    min = Math.min(min, windowSum);

    while(r < cardPoints.length) {
      windowSum = windowSum + cardPoints[r] - cardPoints[r - windowLen];
      min = Math.min(min, windowSum);
      r++;
    }
    return min == 0 ? 0 : cardPointsSum - min;
  }

}
