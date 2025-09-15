import java.util.Scanner;

public class LinearSearch{
    public static int search(int A[],int x){
        for(int i=0;i<A.length;i++){
            if(A[i]==x){
                return i;
            }
        }
        return -1;
    } 
    public static void main(String args[]){

        int A[]={24,65,25,85,9,45};
        Scanner sc=new Scanner(System.in);

        int x=sc.nextInt();
        int result=search(A,x);

        if(result== -1){
            System.out.println("element didnt found.");
        }else{
            System.out.println(x+" is found at index :"+result);
        }
    }
}
