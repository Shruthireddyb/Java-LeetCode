class RotateArray {
    public void rotate(int[] n, int k) {
      if(n.length==0)return;
        k%=n.length;
        int s=n.length;
        reverse(n,0,s-1);
        reverse(n,0,k-1);
        reverse(n,k,s-1);
    }
    public void reverse(int[] n,int start,int end){
        while(start<end){
            int temp=n[start];
            n[start]=n[end];
            n[end]=temp;
            start++;
            end--;
        }
      }
        public static void main(String[] args){
          RotateArray s = new RotateArray();
        int[] n = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        s.rotate(n, k);
        for(int num : n) System.out.print(num + " ");
    }
}