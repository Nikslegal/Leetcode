class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;

        int maxdiff = -1;

        for(int i = 0; i<n;i++){
            for(int j = i+1; j<n; j++){

                if(nums[j]>nums[i]){
                    int diff = Math.abs(nums[i]-nums[j]);
                   if(diff > maxdiff){
                    maxdiff = diff;
                }
                }
            }
        }
        System.out.print(" " +maxdiff);
        return maxdiff;
    }
}