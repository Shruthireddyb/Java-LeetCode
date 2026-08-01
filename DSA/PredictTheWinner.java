import java.util.Arrays;
public class PredictTheWinner {
  public boolean predictTheWinner(int[] nm) {
        int n=nm.length;
        int[] dp=Arrays.copyOf(nm,n);
        for(int diff=1;diff<n;++diff){
            for(int left=0;left<n-diff;++left){
                int right=left+diff;
                dp[left]=Math.max(nm[left]-dp[left+1],nm[right]-dp[left]);
            }
        }
        return dp[0]>=0;
    }
}
