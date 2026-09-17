class Solution {
    public boolean uniqueOccurrences(int[] arr) {

        int n = arr.length;
        int[] count = new int[n];

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {

                if(arr[i] == arr[j]) {
                    count[i]++;
                }
            }
        }

        for(int i = 0; i < n; i++) {

            for(int j = i + 1; j < n; j++) {

                if(arr[i] == arr[j]) {
                    continue;
                }

                if(count[i] == count[j]) {
                    return false;
                }
            }
        }

        return true;
    }
}