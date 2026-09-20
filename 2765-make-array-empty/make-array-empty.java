import java.util.*;

class Solution {
    public long countOperationsToEmptyArray(int[] nums) {

        int n = nums.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        FenwickTree bit = new FenwickTree(n);

        for (int i = 0; i < n; i++) {
            bit.add(i, 1);
        }

        long operations = 0;
        int previousIndex = 0;

        for (int i = 0; i < n; i++) {

            int currentIndex = arr[i][1];

            if (currentIndex >= previousIndex) {

                operations += bit.sum(currentIndex + 1)
                            - bit.sum(previousIndex);

            } else {

                operations += bit.sum(n)
                            - bit.sum(previousIndex);

                operations += bit.sum(currentIndex + 1);
            }

            bit.add(currentIndex, -1);

            previousIndex = currentIndex;
        }

        return operations;
    }

    static class FenwickTree {

        int[] tree;

        FenwickTree(int n) {
            tree = new int[n + 1];
        }

        void add(int index, int value) {
            index++;

            while (index < tree.length) {
                tree[index] += value;
                index += index & -index;
            }
        }

        int sum(int index) {

            int result = 0;

            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }

            return result;
        }
    }
}