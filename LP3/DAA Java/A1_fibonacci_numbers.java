public class A1_fibonacci_numbers {
    public static int recursiveFibonacci(int n) {
        if (n <= 1) {
            return n;
        } 
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);    
    }

    public static void nonRecursiveFibonacci(int n) {
        int first = 0;
        int second = 1;
        System.out.print(first + " ");
        System.out.print(second + " ");
        while (n - 2 > 0) {
            int third = first + second;
            first = second;
            second = third;
            System.out.print(third + " ");
            n--;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.print("Recurssive:    ");
        for (int i = 0; i < n; i++) {
            System.out.print(recursiveFibonacci(i) + " ");
        }
        System.out.println();
        System.out.print("Non-Recursive: ");
        nonRecursiveFibonacci(n);
        System.out.println();
    }
}

