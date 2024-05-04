package sorting;

public class QuickSort implements Sortable{

    @Override
    public int[] sort(int[] arr) {
        System.out.println("-------------Executing Quick sort-------------");
        boolean swapped = false;
        for(int i = 0; i< arr.length-1; i++){
            if(arr[i] < arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                swapped = true;
            }
        }

        if(swapped == true){
            sort(arr);
        }
        return arr;
    }
}
