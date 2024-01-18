public class Main {

    // The normal recursive function of fibbonacci seq.
    public static int normalFibbonacciSequence(int n) {
        if (n <= 1) {
            return n;
        }
        return normalFibbonacciSequence(n - 1) + normalFibbonacciSequence(n - 2);
    }

    public static void printNormalFibbonacciSequence(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(normalFibbonacciSequence(i) + " ");
        }
    }

    // Dynamic programming used in order to decrease the time complexity to O(n)
    public static int findFibbonacci(int n, int[] dynamicResult) {
        if (dynamicResult[n] != -1) {
            return dynamicResult[n];
        }
        if (n <= 1) {
            return n;
        }
        dynamicResult[n] = findFibbonacci(n - 1, dynamicResult) + findFibbonacci(n - 2, dynamicResult);
        return dynamicResult[n];
    }

    public static void printFibbonacciSequence(int n) {
        int[] dynamicResult = new int[n];
        for (int i =0; i < n; i++) {
            dynamicResult[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(findFibbonacci(i, dynamicResult) + " ");
        }
    }

    // This is an optimized space version of fibbonacci sequence
    public static int printFibbonacciOptimized(int n) {
        int result = -1;
        int pre1 = 1;
        int pre2 = 0;
        System.out.print("0 1 ");
        for (int i = 2; i < n; i++) {
            result = pre1 + pre2;
            System.out.print(result + " ");
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        printFibbonacciSequence(35);
        long end = System.currentTimeMillis();
        System.out.println("\nThe time required for the algorithm to finish is: " + (end - start) + " Milliseconds\n");

        long startNormal = System.currentTimeMillis();
        printNormalFibbonacciSequence(35);
        long endNormal = System.currentTimeMillis();
        System.out.println("\nThe time required for the algorithm to finish is: " + (endNormal - startNormal) + " Milliseconds\n");

        long startOptimized = System.currentTimeMillis();
        printFibbonacciOptimized(35);
        long endOptimized = System.currentTimeMillis();
        System.out.println("\nThe time required for the algorithm to finish is: " + (endOptimized - startOptimized) + " Milliseconds\n");
    }
}