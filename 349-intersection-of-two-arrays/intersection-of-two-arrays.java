import java.util.Arrays;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        int count = 0;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {

                    boolean found = false;

                    for (int k = 0; k < count; k++) {
                        if (result[k] == nums1[i]) {
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        result[count] = nums1[i];
                        count++;
                    }

                    break;
                }
            }
        }

        return Arrays.copyOf(result, count);
    }
}