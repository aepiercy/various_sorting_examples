import java.util.Arrays;

/**
 * Note that every sorting algorithm takes in an argument k. The sorting 
 * algorithm should sort the array from index 0 to k. This argument could
 * be useful for some of your sorts.
 *
 * Class containing all the sorting algorithms from 61B to date.
 *
 * You may add any number instance variables and instance methods
 * to your Sorting Algorithm classes.
 *
 * You may also override the empty no-argument constructor, but please
 * only use the no-argument constructor for each of the Sorting
 * Algorithms, as that is what will be used for testing.
 *
 * Feel free to use any resources out there to write each sort,
 * including existing implementations on the web or from DSIJ.
 *
 * All implementations except Counting Sort adopted from Algorithms,
 * a textbook by Kevin Wayne and Bob Sedgewick. Their code does not
 * obey our style conventions.
 */
public class MySortingAlgorithms {

    /**
     * Java's Sorting Algorithm. Java uses Quicksort for ints.
     */
    public static class JavaSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            Arrays.sort(array, 0, k);
        }

        @Override
        public String toString() {
            return "Built-In Sort (uses quicksort for ints)";
        }
    }

    /** Insertion sorts the provided data. */
    public static class InsertionSort implements SortingAlgorithm {
        @Override
        //{0,  24,  13,  560, 2, 2, 1324, 5}
        //[0]  [1]  [2]  [3] [4][5] [6]  [7]

        //(0,  2,  2,  5, 13, 24, 560, 1324}
        //[0] [1] [2] [3] [4] [5] [6]  [7]
        public void sort(int[] array, int k) {
            int[] newArr = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                if(i < k && i != 0) {
                    newArr[i] = array[i];
                    for (int j = i; j > 0; j--) {
                        if (array[i] < newArr[j - 1]) {
                            int initialLeft = newArr[j - 1];
                            newArr[j - 1] = newArr[j];
                            newArr[j] = initialLeft;
                        }
                    }
                }
                else {
                    newArr[i] = array[i];
                }
            }

            for (int x = 0; x < array.length; x++) {
                array[x] = newArr[x];
            }
            /*for (int i = k - 1; i > 0; i--) {
                for (int j = i; j > 0; j--) {
                    if (array[i] <= array[j - 1]) {
                        int initialLeft = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = initialLeft;
                    }
                }
            }
            */

            /*
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k - i; j++) {
                    if (array[i + j] < array[i]) {
                        int initialSmall = array[i];
                        int newSmall = array[i + j];
                        array[i] = newSmall;
                        array[i + j] = initialSmall;
                    }
                }
            }

             */
        }

        @Override
        public String toString() {
            return "Insertion Sort";
        }
        //for (int j = 0; j < k - i; j++) {

        //}
         /*   int[] newArray = new int[array.length];
            newArray[0] = array[0];
            int newArrLength = 1;
            int valueToInsert;
            for (int i = 0; i < k; i++){
                valueToInsert = array[i];
                for(int j = 0; j < newArrLength; j++) {
                    if(newArray[j] > valueToInsert) {
                        int saveValue = newArray[j];
                        newArray[j] = valueToInsert;
                        newArrLength++;
                        newArray = shift(newArray, j, saveValue,newArrLength - j - 1);
                    }
                }
            }
            for (int y = k; y < array.length; y++){
                newArray[y] = array[k];
            }


        private int[] shift(int[] arrayToShift, int shiftStartIndex, int savedVal, int howManyShift){
            int shiftValue = 0;
            for(int x = 1; x <= howManyShift; x++) {
                shiftValue = arrayToShift[shiftStartIndex + x];
                arrayToShift[shiftStartIndex + x] = savedVal;
                savedVal = shiftValue;
            }
            return arrayToShift;
        }


            int[] newArray = new int[array.length];
            newArray[0] = array[0];
            for (int i = 0; i < array.length; i++){
                if(i < k){
                    for(int j = 0; j < i; j++) {
                        if(newArray[j] > newArray[i]) {
                            int saveValue = newArray[j];
                            newArray[j] = newArray[i];
                            for(int x = 1; x <= i - j; x++) {
                                int shiftValue = newArray[j + x];
                                newArray[j + x] = saveValue;
                                saveValue = shiftValue;
                            }
                        }
                    }

                }
                else {
                    newArray[i] = array[i];
                }
            }
            for(int y = 0; y < array.length; y++) {
                array[y] = newArray[y];
            }
            //array = newArray;
            */
        //for loop to go through newArrayindeces 0 through i, int j
        //check to see if newArray[j] < newArray[i], then call shift to shift over value
        // on the key of j so shift over starting at newArray[j] would shift to newArray[j+1]
        // passed in newArray[i] as insertInt
      //  private void shift(int[] arrayToShift, int shiftStartIndex, int insertInt){
       //     int saveValue = arrayToShift[shiftStartIndex];
      //      arrayToShift[shiftStartIndex] = insertInt;
     //       for(int x = shiftStartindex; )
     //   }

        //if(newArr){
        //     int check = 0;
        //     int originalInt = array[i];
        //    int originalIndexTrack = i;
        //    int shiftInt = array[i + 1];
        //    while (check < i) {
        //        array[originalIndexTrack + 1] = originalInt;
        //        originalIndexTrack++;
        //      originalInt = shiftInt;
        //       check++;
        //    }
        //}
    }

    /**
     * Selection Sort for small K should be more efficient
     * than for larger K. You do not need to use a heap,
     * though if you want an extra challenge, feel free to
     * implement a heap based selection sort (i.e. heapsort).
     */
    public static class SelectionSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k - i; j++) {
                    if (array[i + j] < array[i]) {
                        int initialSmall = array[i];
                        int newSmall = array[i + j];
                        array[i] = newSmall;
                        array[i + j] = initialSmall;
                    }
                }
            }

        }

        @Override
        public String toString() {
            return "Selection Sort";
        }
    }

    /** Your mergesort implementation. An iterative merge
      * method is easier to write than a recursive merge method.
      * Note: I'm only talking about the merge operation here,
      * not the entire algorithm, which is easier to do recursively.
      */
    public static class MergeSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            int midArr = k / 2;

            int firstPart[] = new int[midArr];
            int secondPart[] = new int[k - midArr];

            for(int i = 0; i < midArr; i++){
                firstPart[i] = array[i];
            }

            for(int j = midArr; j < k; j++){
                secondPart[j - midArr] = array[j];
            }

            sort(firstPart, midArr);
            sort(secondPart, secondPart.length - 1);
            mergeArray(array, midArr, k);
        }

        private void mergeArray(int[] array, int midArr, int endIndex) {
            int[] medium = new int[(endIndex) + 1]; //indeces +1 to adjust for size

            int count = 0;
            int midCount = midArr + 1;
            int countIndex = 0;

            while(count <= midArr && midCount <= endIndex) {
                if(array[count] <= array[midCount]) {
                    medium[countIndex] = array[count];
                    count++;
                    countIndex++;
                } else {
                    medium[countIndex] = array[midCount];
                    countIndex++;
                    midCount++;
                }
            }

            while (count <= midArr) {
                medium[countIndex] = array[count];
                count++;
                countIndex++;
            }

            while (count <= endIndex) {
                medium[countIndex] = array[midCount];
                midCount++;
                countIndex++;
            }

            for(int i = 0; i <= endIndex; i++) {
                array[i] = medium[i];
            }
        }
           /* if( k < 2) {
                return;
            }
            //int midArr = kFixArray.length / 2;
            int midArr = (k - 1) / 2 + 1;

            //int firstPart[] = new int[kFixArray.length - midArr];
            int firstPart[] = new int[midArr];
            int secondPart[] = new int[k - midArr];
            int offset = firstPart.length % 2;

           // for(int i = 0; i < midArr; i++){
                //firstPart[i] = kFixArray[i];
                //secondPart[i] = kFixArray[i + midArr + offset];
            //    firstPart[i] = array[i];
            //    secondPart[i] = array[i + midArr + offset];
           // }
            for(int i = 0; i < midArr; i++){
                firstPart[i] = array[i];
            }

            for(int j = midArr; j < k; j++){
                secondPart[j - midArr] = array[j];
            }

            sort(firstPart, midArr);
            sort(secondPart, k - midArr);

            mergeArray(array, firstPart, secondPart, k - midArr, midArr);


        }


        private void mergeArray(int[] array, int[] firstArray, int[] secondArray, int firstLength, int secondLength) {
            int indexCounter = 0;
            int i = 0;
            int j = 0;
            while(i < firstLength && j < secondLength) {
                if (firstArray[i] <= secondArray[j]) {
                    array[indexCounter] = firstArray[i];
                    indexCounter++;
                    i++;
                } else {
                    array[indexCounter] = secondArray[j];
                    indexCounter++;
                    j++;
                }
            }

            while(i < firstLength) {
                array[indexCounter] = firstArray[i];
                indexCounter++;
                i++;
            }

            while(j < secondLength) {
                array[indexCounter] = secondArray[j];
                indexCounter++;
                j++;
            }
        }

            */
        //int kFixArray[] = new int[k];
        //for(int x = 0; x < k; x++) {
        //  kFixArray[x] = array[x];
        //}
       // private void actualSort(int sortArray[], int lLength, int rLength) {

        //}

        // may want to add additional methods

        @Override
        public String toString() {
            return "Merge Sort";
        }
    }

    /**
     * Your Counting Sort implementation.
     * You should create a count array that is the
     * same size as the value of the max digit in the array.
     */
    public static class CountingSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            // FIXME: to be implemented
        }

        // may want to add additional methods

        @Override
        public String toString() {
            return "Counting Sort";
        }
    }

    /** Your Heapsort implementation.
     */
    public static class HeapSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            // FIXME
        }

        @Override
        public String toString() {
            return "Heap Sort";
        }
    }

    /** Your Quicksort implementation.
     */
    public static class QuickSort implements SortingAlgorithm {
        @Override
        public void sort(int[] array, int k) {
            // FIXME
        }

        @Override
        public String toString() {
            return "Quicksort";
        }
    }

    /* For radix sorts, treat the integers as strings of x-bit numbers.  For
     * example, if you take x to be 2, then the least significant digit of
     * 25 (= 11001 in binary) would be 1 (01), the next least would be 2 (10)
     * and the third least would be 1.  The rest would be 0.  You can even take
     * x to be 1 and sort one bit at a time.  It might be interesting to see
     * how the times compare for various values of x. */

    /**
     * LSD Sort implementation.
     */
    public static class LSDSort implements SortingAlgorithm {
        @Override
        public void sort(int[] a, int k) {
            // FIXME
        }

        @Override
        public String toString() {
            return "LSD Sort";
        }
    }

    /**
     * MSD Sort implementation.
     */
    public static class MSDSort implements SortingAlgorithm {
        @Override
        public void sort(int[] a, int k) {
            // FIXME
        }

        @Override
        public String toString() {
            return "MSD Sort";
        }
    }

    /** Exchange A[I] and A[J]. */
    private static void swap(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
