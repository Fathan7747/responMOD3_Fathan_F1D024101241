public class Main {
    public static void main(String[] args) {

        Method list = new Method();

        // Generate 100 data random
        for (int i = 0; i < 100; i++) {
            int value = (int)(Math.random() * 100) + 1;  // 1 - 100
            list.addLast(value);
        }

        //   BEFORE SORTING
        System.out.println("Linked List sebelum sorting:");
        list.printList();


        Method listSelection = list.copyList();
        Method listInsertion = list.copyList();

        //   SELECTION SORT
        long start1 = System.nanoTime();
        listSelection.selectionSort();
        long end1 = System.nanoTime();
        double selectionTime = (end1 - start1) / 1e9; 

        
        //   INSERTION SORT
        long start2 = System.nanoTime();
        listInsertion.insertionSort();
        long end2 = System.nanoTime();
        double insertionTime = (end2 - start2) / 1e9; 


        System.out.println("\nWaktu eksekusi Selection Sort: " 
                            + format(selectionTime) + " detik");
        System.out.println("Waktu eksekusi Insertion Sort: " 
                            + format(insertionTime) + " detik");


       
        //   PRINT RESULT AFTER SORT
        System.out.println("\nLinked List setelah Sorting:");
        listInsertion.printList();   

       
       
        //   SEARCHING
        int target = 50;

        long startLS = System.nanoTime();
        int linIndex = listInsertion.linearSearch(target);
        long endLS = System.nanoTime();
        double linearTime = (endLS - startLS) / 1e9;

        System.out.println("\nWaktu eksekusi Linear Search: " 
                           + format(linearTime) + " detik");
        System.out.println("Linear Search -> Target: " + target + 
                           " ada di indeks: " + linIndex);

        long startBS = System.nanoTime();
        int binIndex = listInsertion.binarySearch(target);
        long endBS = System.nanoTime();
        double binaryTime = (endBS - startBS) / 1e9;

        System.out.println("\nWaktu eksekusi Binary Search: " 
                           + format(binaryTime) + " detik");
        System.out.println("Binary Search -> Target: " + target + 
                           " ada di indeks: " + binIndex);
    }

    public static String format(double value) {
        return String.format("%.10f", value); 
    }

}
