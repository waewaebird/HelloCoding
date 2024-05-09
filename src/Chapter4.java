import java.util.Arrays;

public class Chapter4 {
    public static int sum(int[] arr) {
        int total = 0;
        for(int i : arr) {
            total += i;
        }
        return total;
    }

    public static void recursion(int val, int[] arr) {
        int total = 0;
        if(arr.length < 1) {
            System.out.println(val);
        } else {
            total = val+arr[0];
            int[] newArr = new int[arr.length-1];
            System.arraycopy(arr, 1, newArr, 0, arr.length-1);
            recursion(total, newArr);
        }
    }

    public static int[] quicksort(int[] arr) {
        if(arr.length < 2) {
            return arr;
        } else {
            int pivot = arr[0];

            int[] tempArr = new int[arr.length-1];
            System.arraycopy(arr, 1, tempArr, 0, arr.length-1);

            int[] less = Arrays.stream(tempArr).filter(num -> num <= pivot).toArray();
            int[] more = Arrays.stream(tempArr).filter(num -> num > pivot).toArray();

            int[] templess = quicksort(less);
            int[] tempmore = quicksort(more);

            int[] combinedArr = new int[templess.length+tempmore.length+1];
            System.arraycopy(templess, 0, combinedArr, 0,templess.length);
            combinedArr[templess.length] = pivot;
            System.arraycopy(tempmore, 0, combinedArr, templess.length+1, tempmore.length);

            return combinedArr;
        }
    }

    public static void printItems(int[] arr) {
        for(int num : arr) {
            System.out.println(num);
        }
    }

    public static void printItems2(int[] arr) throws InterruptedException {
        for(int num : arr) {
            Thread.sleep(1000);
            System.out.println(num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //int[] temp = {10,5,5,5,203,301,23,23,5,6,7,5,4,3465,1};
        //recursion(0, temp);
        //System.out.println(Arrays.toString(quicksort(temp)));

        //int[] temp = {10,5,5,5,203,301,23,23,5,6,7,5,4,3465,1};
        //printItems(temp);

        int[] temp = {10,5,5,5,203,301,23,23,5,6,7,5,4,3465,1};
        printItems2(temp);
    }
}
