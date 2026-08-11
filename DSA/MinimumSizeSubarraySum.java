class MinimumSizeSubarraySum{
  public int minSubArrayLen(int s, int[] num) {
        int result=Integer.MAX_VALUE;
        int left=0;
        int val_sum=0;
        for(int i=0;i<num.length;i++){
            val_sum+=num[i];
            while(val_sum>=s){
                result=Math.min(result,i+1-left);
                val_sum-=num[left];
                left++;
            }
        }
        return (result!=Integer.MAX_VALUE) ? result:0;
    }
}