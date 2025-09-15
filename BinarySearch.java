
import java.util.Arrays;

public class BinarySearch {

    static void bubbleSort(int A[] ){
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                if(A[i]>A[j]){
                    int temp=A[i];
                    A[i]=A[j];
                    A[j]=temp;
                }
            }
        }
    }

    static int binarySearch(int A[],int right,int left,int x){
        while(left<right){
            int mid=(left+right)/2;
            if(A[mid]==x){
                return mid;
            }else if (A[mid]>x) {
                right=mid-1;
            }else{
                left=mid+1;
            }

        }
        return -1;
    }

    public static void main(String args[]){

        int A[]={85,25,14,32,12,2,65,4,6,98};

        System.out.println("before sort");
        System.out.println(Arrays.toString(A));

        bubbleSort(A);

        System.out.println("after Sort");
        System.out.println(Arrays.toString(A));
        int x=14;
        int right=A.length-1;
        int left=0;
        int res=binarySearch(A,right,left,x);
        if(res == -1){
            System.out.println(x+" is not found.");
        }else{
            System.out.println(x+" is found.");
        }

    }
}
 