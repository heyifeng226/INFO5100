public class closestInteger {
    public static void main(String[]args) {
        closestInteger c=new closestInteger();
        int[]A={1,3,3,4};
        int answer1=c.closest(A,2);
        System.out.println(answer1);
        int[]B={0,1,5};
        int answer2=c.closest(B,7);
        System.out.println(answer2);
        //test null condition
        int[]C={};
        int answer3=c.closest(C,1);
        System.out.println(answer3);

    }
    public int closest(int[]A,int target){
        if(A==null||A.length==0){
            throw new NullPointerException("array A can not be null");
        }
        int start=0;
        int end=A.length-1;
        while(start+1<end){
            int middle=start+(end-start)/2;
            if(A[middle]==target){
                return middle;
            }else if(A[middle]<target){
                start=middle;
            }else{
                end=middle;
            }
        }
        if(Math.abs(A[start]-target)<=Math.abs(A[end]-target)){
            return start;
        }
        return end;
    }

}
