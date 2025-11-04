import java.util.*;

import DSA_EDC.Arrays;

public class QuickSort
{

	public static void swap(int A[],int i,int j)
	{
		int temp=A[i];
		A[i]=A[j];
		A[j]=temp;
	}
	
	public static int partition(int l,int h,int A[])
	{
		int pivot=A[l];
		int i=l;
		int j=h;
		while(i<j)
		{
			while(i<=(h-1) && A[i]<=pivot) i++;
			while(j>=l && A[j]>pivot) j--;
			
			if(i<j)
				swap(A,i,j);
		}
		swap(A,l,j);
		return j;
		
	}
	
	public static void quickSort(int A[],int l,int h)
	{
		if(l<h)
		{
			int PivotId=partition(l,h,A);
			quickSort(A,l,PivotId-1);
			quickSort(A,PivotId+1,h);
		} 	
	}
	
	public static void main(String args[])
	{
		 int A[]=new int[10];
		 Scanner sc=new Scanner(System.in);
		 for(int i=0;i<A.length;i++)
		 {
		 	A[i]=sc.nextInt();
		 }
		 System.out.println(Arrays.toString(A));
		 quickSort(A,0,A.length-1);
		 System.out.println(Arrays.toString(A));
	}
}


