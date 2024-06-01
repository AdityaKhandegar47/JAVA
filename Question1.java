import java.util.Scanner;

class ArraySwapper {
    public void Swap(char[] a ,  char[] b , int size){
        char[] temp = new char[size];
        //  System.arraycopy(array 1, position from array 1, array 2, position from array 2, array 1 length);
        // copying array 1 to array 2 
        System.arraycopy(a, 0, temp, 0, size);
        System.arraycopy(b, 0, a, 0, size);
        System.arraycopy(temp, 0, b, 0, size);

        }
    
}
class Arithmetic {
    public char[] Addition(char[] c1, char[] c2, int length) {
        int size = length + 1;
        char[] sum = new char[size];
        int carry = 0;
        for (int i = 0; i < length; i++) {
            int digit1 = c1[i] - '0';
            int digit2 = c2[i] - '0';
            int digSum = digit1 + digit2 + carry;
            sum[i] = (char) ((digSum % 10) + '0');
            carry = digSum / 10;
        }
        // Adding final carry
        if (carry > 0) {
            sum[length] = (char) (carry + '0');
        } else {
            sum[length] = '0';
        }
        // Remove leading zero if not needed
        if (sum[length] == '0') {
            size--;
        }
        char[] finalSum = new char[size];
        for (int i = 0; i < size; i++) {
            finalSum[i] = sum[size - i - 1];
        }
        return finalSum;
    }
    public char[] Subtraction(char[] c1, char[] c2, int length){
        int size = length;
        char[] diff = new char[size];
        int borrow = 0;
        for(int i = 0; i<size;i++){
            int dig1 = c1[i] - '0';
            int dig2 = c2[i] - '0';
            int digDiff = dig1 - dig2 - borrow;
            if(digDiff < 0){
                digDiff += 10;
                borrow = 1;
            }
            else borrow = 0;

            diff[i] = (char)(digDiff + '0');
        }

             // Remove leading zeros
        int Index = length - 1;

        while (Index >= 0 && diff[Index] == '0') {
            Index--;
        }

        char[] finalDiff = new char[Index + 1];
        for (int i = 0; i <= Index; i++) {
            finalDiff[i] = diff[Index - i];
        }
        return finalDiff;
    }
}
public class Question1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number 1: ");
        String s1 = input.nextLine();

        System.out.println("Enter the number 2: ");
        String s2 = input.nextLine();

        int length1 = s1.length();
        int length2 = s2.length();
        int maxlength;
        if( length1 >= length2 ){
            maxlength = length1;
        }
        else{
            maxlength = length2;
        }

        char[] arr1 = new char[maxlength];
        char[] arr2 = new char[maxlength];

        // Initialize arrays to '0'
        for (int i = 0; i < maxlength; i++) {
            arr1[i] = '0';
            arr2[i] = '0';
        }
        if(length2 > length1){
            ArraySwapper S = new ArraySwapper();
            S.Swap(arr1, arr2, maxlength);
        }
        // Fill arr1 with s1 reversed
        for (int i = 0; i < length1; i++) {
            arr1[i] = s1.charAt(length1 - i - 1);
        }

        // Fill arr2 with s2 reversed
        for (int i = 0; i < length2; i++) {
            arr2[i] = s2.charAt(length2 - i - 1);
        }

        // Checking the arrays
            // using string class constructor

        System.out.println("arr1: " + new String(arr1));
        System.out.println("arr2: " + new String(arr2));

        Arithmetic ari = new Arithmetic();
        char[] Sum = ari.Addition(arr1, arr2, maxlength);
        char[] Difference = ari.Subtraction(arr1, arr2, maxlength);
        System.out.println("Sum: " + new String(Sum));
        System.out.println("Difference: " + new String(Difference));

        input.close();
    }
}
