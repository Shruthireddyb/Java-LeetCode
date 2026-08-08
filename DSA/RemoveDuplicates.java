public class RemoveDuplicates {
  public int removeDuplicates(int[] n) {
        int j=1;
        for(int i=0;i<n.length-1;i++){
            if(n[i]!=n[i+1]){
                n[j]=n[i+1];
                j++;
            }
        }
        return j;
    }
}
