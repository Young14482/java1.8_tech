package ex04;

import java.util.Arrays;
import java.util.List;

public class SortApp {
    public static void main(String[] args) {
        // 4. sort, distinct (정렬, 중복제거)
        List<Integer> nums = Arrays.asList(5, 3, 1, 2, 4, 5, 2);

        nums.stream()
                .sorted()
                .distinct()
                .forEach(integer -> System.out.println(integer));

    }
}
