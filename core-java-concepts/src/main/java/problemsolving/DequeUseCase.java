package problemsolving;

import java.util.*;

public class DequeUseCase {
    public static void main(String[] args) {

        Deque deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        int n = 6;
        int m = 4;
        int[] nums = {3,3,3,1,3,3};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int input = nums[i];
            deque.add(input);
            set.add(input);
            System.out.println(deque);
            if (deque.size() == m) {
                if (set.size() > max)
                    max = set.size();
                System.out.println("max "+max);
                int first = (int) deque.remove();
                System.out.println("first "+first);
                if (!deque.contains(first))
                    set.remove(first);
            }
        }
        System.out.println(max);
    }
}
