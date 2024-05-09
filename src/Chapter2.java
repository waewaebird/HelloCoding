import java.util.Arrays;

public class Chapter2 {

    public static int findSmallest(int[] arr) {
        int smallest = arr[0]; //5
        int smallest_index = 0;
                                //5
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] < smallest) {
                smallest = arr[i];
                smallest_index = i;
            }
        }
        return smallest_index;
    }

    public static int[] selectionSort(int[] arr) {
        int[] newArr = new int[arr.length];
        int smallest;
        int i = 0;

        for(int num : arr) {
            smallest = findSmallest(arr);
            newArr[i] = arr[smallest];
            i++;

            int[] tempArr = new int[arr.length - 1];
            int tempIndex = 0;
            for(int j = 0 ; j < arr.length ; j++) {
                if(j == smallest) {
                    continue;
                }
                tempArr[tempIndex] = arr[j];
                tempIndex++;
            }
            arr = tempArr;
        }

        return newArr;
    }

    public static void main(String[] args) {
        int[] temp = {5,3,6,2,10,12,13,1};
        System.out.println(Arrays.toString(selectionSort(temp)));
    }
}
