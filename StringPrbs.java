import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Pair {
    int freq;
    char ele;

    Pair(int freq, char ele) {
        this.freq = freq;
        this.ele = ele;
    }
}

class StringSolutions {
    // Sum of Array Elements

    public  int sum(int arr[], int n) {
      int elementsSum = 0;

      for (int idx = 0; idx < n; idx++) {
        elementsSum += arr[idx];
      }

      return elementsSum;
    }

    // Count Odd Numbers in an Array

    public int countOdd(int[] arr, int n) {
       int count = 0;

       for (int idx = 0; idx < n; idx++) {
        if (arr[idx] % 2 == 1) {
            count += 1;
        }
       }

       return count;
    }

    // Check if Array is Sorted

    public boolean arraySortedOrNot(int[] arr, int n) {
        for (int idx = 0; idx <= n - 2; idx++) {
            if (!(arr[idx] <= arr[idx + 1])) {
                return false;
            }
        }
        return true;
    }

    // Reverse an array

    public int[] reverseArray(int[] arr, int n) {
        // Brute

        // int[] tempArray = new int[n];

        // for (int idx = n - 1; idx >= 0; idx--) {
        // tempArray[n - 1 - idx] = arr[idx];
        // }

        // for (int idx = 0; idx < n; idx++) {
        // arr[idx] = tempArray[idx];
        // }

        // return arr;

        // Optimal

        int left = 0;
        int right = n - 1;
        int temp;

        while (right > left) {
            temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }

        return arr;
    }

    // Reverse String

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

    // Palindrome Check string

    public boolean palindromeCheck(String s) {
        // int lastIdx = s.length() - 1;
        // StringBuilder reverse = new StringBuilder();

        // while (lastIdx >= 0) {
        // reverse.append(s.charAt(lastIdx));
        // lastIdx--;
        // }

        // return s.equals(reverse.toString());

        // Approach 2

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Largest Odd Number in a String

    public String largestOddNumberString(String s) {
        int n = s.length();
        int endIdx = -1;
        for (int idx = n - 1; idx >= 0; idx--) {
            if ((s.charAt(idx) - '0') % 2 == 1) {
                endIdx = idx;
                break;
            }
        }
        if (endIdx == -1) {
            return "";
        }

        int startIdx = 0;
        for (startIdx = 0; startIdx < n; startIdx++) {
            if (s.charAt(startIdx) != '0') {
                break;
            }
        }

        return s.substring(startIdx, endIdx + 1);
    }

    // Isomorphic Strings

    public boolean isomorphicString(String s, String t) {
        int[] mapS = new int[256], mapT = new int[256];

        for (int idx = 0; idx < s.length(); idx++) {
            if (mapS[s.charAt(idx)] != mapT[t.charAt(idx)])
                return false;

            mapS[s.charAt(idx)] = idx + 1;
            mapT[t.charAt(idx)] = idx + 1;
        }

        return true;
    }

    // Rotate String

    public boolean rortateString(String s, String goal) {
        // Brute

        if (s.length() != goal.length()) {
            return false;
        }

        if (s.length() == 1) {
            return s.equals(goal);
        }

        int shifts = s.length();
        while (shifts > 0) {
            s = s.substring(1) + s.charAt(0);
            if (s.equals(goal)) {
                return true;
            }
            shifts--;
        }

        return false;

        // Optimimal

        // return s.length() == goal.length() && (s + s).contains(goal);
    }

    // Valid Anagram

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freqS = new int[26], freqT = new int[26];
        for (int idx = 0; idx < s.length(); idx++) {
            freqS[s.charAt(idx) - 'a']++;
            freqT[t.charAt(idx) - 'a']++;
        }

        for (int charIdx = 0; charIdx < freqS.length; charIdx++) {
            if (freqS[charIdx] != freqT[charIdx]) {
                return false;
            }
        }

        return true;
    }
    // Sort Characters By Frequency

    public List<Character> sortByFrequency(String s) {
        Pair[] hash = new Pair[26];

        for (int idx = 0; idx < hash.length; idx++) {
            hash[idx] = new Pair(0, (char) (idx + 'a'));
        }

        for (int idx = 0; idx < s.length(); idx++) {
            hash[s.charAt(idx) - 'a'].freq++;
        }

        Arrays.sort(hash, (p1, p2) -> {
            if (p1.freq != p2.freq)
                return p2.freq - p1.freq;
            return p1.ele - p2.ele;
        });

        List<Character> result = new ArrayList<>();
        for (int idx = 0; idx < hash.length; idx++) {
            if (hash[idx].freq == 0) {
                break;
            }
            result.add(hash[idx].ele);
        }

        return result;
    }
}

public class StringPrbs {
    public static void main(String[] args) {
        StringSolutions solution = new StringSolutions();
        // solution.reverseString(new ArrayList<>(Arrays.asList('h', 'e', 'l', 'l',
        // 'o')));
        // System.out.println(solution.isomorphicString("ab", "aa"));
        System.out.println(solution.sortByFrequency("bbccddaaa"));
    }
}