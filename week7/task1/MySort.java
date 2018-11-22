public class MySort {
    Sortable callback;

    public void setCallback(Sortable callback) {
        this.callback = callback;
    }

    public MySort(Sortable callback) {
        this.callback = callback;
    }

    public void sort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if(callback.greater(array[j], array[j + 1])){
                    int swap = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = swap;
                }
            }
        }
    }
}
