// check the hotest discussion

public class Solution {
  public void nextPermutation(int[] num) {

    int n = num.length;
    int index = n - 1; // turning point

    while(index > 0) {
      if (num[index - 1] < num[index]) {
        break;
      }
      index --;
    }

    if (index == 0) {
      reverseArray(num, 0, n - 1);
      return;
    }

    for (int i = n - 1; i >= index; i --) {
      if (num[i] > num[index - 1]) {
        swap(num, i, index - 1);
        reverseArray(num, index, n - 1);
        break;
      }
    }

  }

  public void swap(int[] arr, int a, int b) {
    int tmp;
    tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  public void reverseArray(int[] arr, int start, int end) {
    if (start > end) {
      return;
    }
    int tmp;
    for (int i = start; i <= (start + end) / 2; i ++) {
      swap(arr, i, start + end - i);
    }
  }
}
