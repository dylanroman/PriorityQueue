public class ERApp {
    public static void main(String[] args) {

        MaxHeap<Integer> test = new MaxHeap<>();

        int[] numbers = {20, 30, 10, 10, 15, 4, 2, 1, 13, 12};

        for (int i = 0; i < numbers.length; i++) {
            test.add(numbers[i]);
            test.displayHeap();
        }

        test.removeMax();

        test.displayHeap();
    }
}
