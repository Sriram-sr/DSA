import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Pair {
    int freq;
    char ele;

    Pair(int freq, char ele) {
        this.freq = freq;
        this.ele = ele;
    }
}

class WorkoutSolutions {
    public int mostFrequentElement(int[] nums) {
        // Brute

        // int max = nums[0];
        // for (int idx = 1; idx < nums.length; idx++) {
        // if (nums[idx] > max)
        // max = nums[idx];
        // }

        // int[] visited = new int[max + 1];
        // int maxFreq = -1, maxEle = 0;
        // int count;
        // for (int idx = 0; idx < nums.length; idx++) {
        // if (visited[nums[idx]] != 1) {
        // count = 0;
        // for (int subIdx = 0; subIdx < nums.length; subIdx++) {
        // if (nums[subIdx] == nums[idx]) {
        // count++;
        // }
        // }
        // if (count > maxFreq) {
        // maxEle = nums[idx];
        // maxFreq = count;
        // } else if (count == maxFreq && nums[idx] < maxEle) {
        // maxEle = nums[idx];
        // }
        // visited[nums[idx]] = 1;
        // }
        // }

        // return maxEle;

        // Optimal

        int max = nums[0];
        for (int idx = 1; idx < nums.length; idx++) {
            if (nums[idx] > max)
                max = nums[idx];
        }

        int[] hashArray = new int[max + 1];
        for (int idx = 0; idx < nums.length; idx++) {
            hashArray[nums[idx]]++;
        }

        int maxEle = 0, maxFreq = -1;
        for (int idx = 0; idx < hashArray.length; idx++) {
            if (hashArray[idx] != 0 && hashArray[idx] > maxFreq) {
                maxFreq = hashArray[idx];
                maxEle = idx;
            }
        }

        return maxEle;
    }

    public int sumHighestAndLowestFrequency(int[] nums) {
        int max = nums[0];
        for (int idx = 1; idx < nums.length; idx++) {
            if (nums[idx] > max)
                max = nums[idx];
        }

        int[] hashArray = new int[max + 1];
        for (int idx = 0; idx < nums.length; idx++) {
            hashArray[nums[idx]]++;
        }

        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        for (int idx = 0; idx < hashArray.length; idx++) {
            if (hashArray[idx] != 0 && hashArray[idx] > maxFreq) {
                maxFreq = hashArray[idx];
            }
            if (hashArray[idx] != 0 && hashArray[idx] < minFreq) {
                minFreq = hashArray[idx];
            }
        }

        return minFreq + maxFreq;
    }

    public String largeOddNum(String s) {
        int n = s.length();
        int lastIdx = -1, firstIdx = -1;
        for (int idx = n - 1; idx >= 0; idx--) {
            if ((s.charAt(idx) - '0') % 2 != 0) {
                lastIdx = idx;
                break;
            }
        }

        if (lastIdx == -1)
            return "";

        for (int idx = 0; idx < n; idx++) {
            if (s.charAt(idx) - '0' != 0) {
                firstIdx = idx;
                break;
            }
        }

        return s.substring(firstIdx, lastIdx + 1);
    }

    public boolean rotateString(String s, String goal) {
        String concatenatedStr = s + s;

        return concatenatedStr.contains(goal);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] hash = new int[26];

        for (int idx = 0; idx < s.length(); idx++) {
            hash[s.charAt(idx) - 'a'] = 1;
        }

        for (int idx = 0; idx < t.length(); idx++) {
            if (hash[t.charAt(idx) - 'a'] != 1)
                return false;
        }

        return true;
    }

    public List<Character> frequencySort(String s) {
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

        List<Character> ans = new ArrayList<>();

        for (int idx = 0; idx < hash.length; idx++) {
            if (hash[idx].freq == 0)
                break;
            ans.add(hash[idx].ele);
        }

        return ans;
    }
}

public class Workout {
    public static void main(String[] args) {
        WorkoutSolutions solutions = new WorkoutSolutions();
        System.out.println(solutions.frequencySort("bbccddaaa"));
    }
}
