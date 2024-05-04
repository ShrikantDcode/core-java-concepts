package problemsolving;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50, 70, 80, 90}; //array should be sorted to use binary search

        int key = 71;
        //program to search if key is present in arr
        int first = 0, last = arr.length -1;
        int mid = (first+last)/2;
        while(first <= last) {
            if(arr[mid] <= key){
                if(arr[mid] == key) { System.out.println(key+" is present in array"); }
                first = mid +1;
            } else {
                last = mid -1;
            }
            mid = (first+last)/2;

        }
    }
}
