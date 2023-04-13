package br.pucrs;

import java.util.Random;

import static java.lang.Math.max;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        /*Random rnd = new Random();
        long [] array = new long[1048576];
        for(int i = 0; i< array.length;i++){
            array[i] = rnd.nextInt(9999999);
        }
        for(int i = 0; i< array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
        long tempoInicial = System.currentTimeMillis();
        maxVal2(array,0,array.length - 1);
        for(int i =0; i< array.length;++i){
            System.out.print(array[i]+ " ");
        }
        System.out.println();
        System.out.println("o metodo executou em " + (System.currentTimeMillis() - tempoInicial));*/

        System.out.println(multiply(25, 10, 4));
    }

    public static void merge(int[] left_arr,int[] right_arr, int[] arr,int left_size, int right_size){

        int i=0,l=0,r = 0;
        //The while loops check the conditions for merging
        while(l<left_size && r<right_size){

            if(left_arr[l]<right_arr[r]){
                arr[i++] = left_arr[l++];
            }
            else{
                arr[i++] = right_arr[r++];
            }
        }
        while(l<left_size){
            arr[i++] = left_arr[l++];
        }
        while(r<right_size){
            arr[i++] = right_arr[r++];
        }
    }

    public static void mergeSort(int [] arr, int len){
        if (len < 2){return;}

        int mid = len / 2;
        int [] left_arr = new int[mid];
        int [] right_arr = new int[len-mid];

        //Dividing array into two and copying into two separate arrays
        int k = 0;
        for(int i = 0;i<len;++i){
            if(i<mid){
                left_arr[i] = arr[i];
            }
            else{
                right_arr[k] = arr[i];
                k = k+1;
            }
        }
        // Recursively calling the function to divide the subarrays further
        mergeSort(left_arr,mid);
        mergeSort(right_arr,len-mid);
        // Calling the merge method on each subdivision
        merge(left_arr,right_arr,arr,mid,len-mid);
    }

    public static long maxVal1(long A[], int n) {
        long max = A[0];
        for (int i = 1; i < n; i++) {
            if( A[i] > max )
                max = A[i];
        }
        return max;
    }

    public static long maxVal2(long A[], int init, int end) {
        if (end - init <= 1)
            return max(A[init], A[end]);
        else {
            int m = (init + end)/2;
            long v1 = maxVal2(A,init,m);
            long v2 = maxVal2(A,m+1,end);
            return max(v1,v2);
        }
    }

    public static long multiply(long x, long y, long n){
        int cont = 0;
        long m = 0;
        long a = 0;
        long b = 0;
        long c = 0;
        long d = 0;
        long e = 0;
        long f = 0;
        long g = 0;
        long h = 0;
        if(n == 1){
            cont++;
            return cont;//x * y;
        }
        else{
            m = n /2;

            a = (long) (x / Math.pow(2, m));
            b = (long) (x % Math.pow(2, m));
            c = (long) (y / Math.pow(2, m));
            d = (long) (y % Math.pow(2, m));
            e = multiply(a, c, m);
            cont++;
            f = multiply(b, d, m);
            cont++;
            g = multiply(b, c, m);
            cont++;
            h = multiply(a, d, m);
            cont++;
            //RETURN 2^(2m)*e + 2^m*(g + h) + f.
            return cont;//(long)(Math.pow(2, (2*m)*e) + Math.pow(2, m) * (g + h) + f);
        }

    }
}
