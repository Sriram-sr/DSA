class RecursionSolutions {
    // Sum of First N Numbers
    public int sumOfNaturalNumbers(int N) {
        if (N == 0)
            return 0;

        return N + sumOfNaturalNumbers(N - 1);
    }

    // Factorial of a Given Number
    public long factorial(int n) {
        if (n <= 1)
            return 1;

        return (long) n * factorial(n - 1);
    }
}

public class RecursionPrbs {
    public static void main(String[] args) {
        RecursionSolutions solution = new RecursionSolutions();
        System.out.println(solution.factorial(3));
    }
}
