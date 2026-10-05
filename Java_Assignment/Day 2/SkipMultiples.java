//  Day 2  1st Question   Skip with continue

public class SkipMultiples {
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            if (i % 4 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }
}