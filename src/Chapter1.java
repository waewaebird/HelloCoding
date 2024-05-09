public class Chapter1 {
    public static Integer binarySearch(int[] arr, int item) {
        int low = 0;
        int high = arr.length - 1;


        while (low <= high) {
            int mid = Math.round((high + low) / 2);
            int guess = arr[mid];

            if(guess == item) {
                return mid;
            }
            if(guess > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,7,9};
        System.out.println(binarySearch(arr ,7));
    }
}
