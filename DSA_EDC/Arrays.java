public class Arrays {
    
    public static void main(String s[]){
        char[] vowels={'a','e','i','o','u'};
        int[] numbers={12,55,85,69,47,0};

        
        int ele=100;
        int pos=4;
        
        for(int i=numbers.length-1;i>=pos;i--){
            numbers[i]=numbers[i-1];
        }
        numbers[pos-1]=ele;
        
        System.out.println(java.util.Arrays.toString(numbers));
    }
}

// System.out.println(vowels);
// vowels[0]='c';
// System.out.println(vowels);
// System.out.println(vowels.length);