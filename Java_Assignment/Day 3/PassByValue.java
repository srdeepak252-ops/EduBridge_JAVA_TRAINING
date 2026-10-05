//  Day 3  2nd Question  Pass by value experiment

public class PassByValue {
    static void changeNum(int x) {
        x = 100;
    }

    static void changeArr(int[] a) {
        a[0] = 100;
    }

    public static void main(String[] args) {
        int num = 5;
        int[] arr = {5, 10, 15};

        int numBefore = num;
        int arrBefore = arr[0];

        changeNum(num);
        changeArr(arr);

        System.out.println("num: \nBefore: " + numBefore + ", After: " + num);
        System.out.println("arr[0]: \nBefore: " + arrBefore + ", After: " + arr[0]);
    }
}