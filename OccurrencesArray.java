// public class OccurrencesArray {
//     public static int noOfoccurences(int[] arr, int value) {
//         int count = 0;
//         for (int num : arr) {
//             if (num == value) {
//                 count++;
//             }
//         }
//         return count;
//     }
// }

// import java.util.Scanner;

// public class OccurrencesArray {
// public static void main(String[] args) {
// try (Scanner input = new Scanner(System.in)) {
// System.out.println("Welcome to Array Occurrences\n");

// System.out.print("Enter the number of elements: ");
// int size = input.nextInt();

// int[] numArr = new int[size];
// for (int i = 0; i < size; i++) {
// System.out.print("Please enter element " + (i + 1) + ": ");
// numArr[i] = input.nextInt();
// }

// System.out.print("Now enter the number you want to find: ");
// int num = input.nextInt();

// int occurrences = noOfOccurrences(numArr, num);
// System.out.println("Your element was found " + occurrences + " times in the
// array.");
// }
// }

// public static int noOfOccurrences(int[] numArr, int num) {
// int occ = 0;
// for (int j : numArr) {
// if (j == num) {
// occ++;
// }
// }
// return occ;
// }
// }

import java.util.Scanner;

public class OccurrencesArray {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Welcome to Array Occurences\n");
            int[] numArr = ArrayUtility.inputArray();
            System.out.print("Now enter the number you want to find: ");

            int num = input.nextInt();
            int occurrences = noOfoccurences(numArr, num);
            System.out.println("Your element was found " + occurrences + " times in the array");
        }
    }

    public static int noOfoccurences(int[] numArr, int num) {
        int occ = 0;
        int i = 0;
        while (i < numArr.length) {
            if (numArr[i] == num) {
                occ++;
            }
            i++;
        }
        return occ;
    }

}
