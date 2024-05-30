public class array{
    public static void main(String a[]){

    //ways to define an array
        int arr1[] = new int[5];
        for(int i = 0;i<5;i++){
            arr1[i] = i + 5; 
        }

        int arr2[] = {1,2,3,4,5};

        for(int i = 0;i<5;i++){
            System.out.println(arr1[i]);
        }
        for(int i = 0;i<5;i++){
            System.out.println(arr2[i]);
        }

    }
}