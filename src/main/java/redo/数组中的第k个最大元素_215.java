package redo;

public class 数组中的第k个最大元素_215 {
  public int findKthLargest(int[] nums, int k) {
    int[] ini = new int[k];
    for (int i = 0; i < k; i++) {
      ini[i] = nums[i];
    }
    MinHeap minHeap = new MinHeap(ini);
    for (int i = k; i < nums.length; i++) {
      minHeap.add(nums[i]);
    }
    return minHeap.getMin();
  }

  static class MinHeap{
    private int[] data; // 大小为n  固定顺序排列

    public MinHeap(final int[] data) {
      this.data = data;
      for(int i = ((data.length - 1) >> 1); i >= 0 ; i--) {
        heapifyDown(i);
      }
    }

    private void heapifyDown(int i){
      int r = (i + 1) << 1;
      int l = r - 1;
      int min = i;
      if(r < data.length && data[min] > data[r]) min = r;
      if(l < data.length && data[min] > data[l]) min = l;
      if(min != i) {
        swap(data, min, i);
        heapifyDown(min);
      }
    }

    private void swap(int[] data, int i, int j) {
      int tmp = data[i];
      data[i] = data[j];
      data[j] = tmp;
    }

    public void add(int i) {
      if(i > data[0]) {
        data[0] = i;
        heapifyDown(0);
      }
    }

    public int getMin() {
      return data[0];
    }
  }
}
