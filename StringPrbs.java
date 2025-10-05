import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class StringSolutions {
    public void reverseString(List<Character> s) {
        int left = 0;
        int right = s.size() - 1;
        char temp;

        while (left < right) {
            temp = s.get(right);
            s.set(right, s.get(left));
            s.set(left, temp);

            left++;
            right--;
        }

        for (char c : s) {
            System.out.println(c);
        }
    }
}

public class StringPrbs {
    public static void main(String[] args) {
        StringSolutions solution = new StringSolutions();
        List<Character> s = new ArrayList<>(Arrays.asList('h', 'e', 'l', 'l', 'o'));
        solution.reverseString(s);
    }
}