package activities;

public class Activity12 {
    public static void main(String[] args) {

        // Lambda expression without return keyword.
        Addable ad1 = (num1, num2) -> (num1 + num2);
        System.out.println(ad1.add(10, 20));

        // Lambda expression with return keyword.
        Addable ad2 = (int num1, int num2) -> {
            return (num1 + num2);
        };
        System.out.println(ad2.add(100, 200));
    }
}
