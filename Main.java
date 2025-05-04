import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer> mergesort(ArrayList<Integer> arr) {
        if(arr.size() == 1){
            return arr;
        }

        int middle = arr.size() / 2;

        ArrayList<Integer> left = new ArrayList<>(arr.subList(0, middle));
        ArrayList<Integer> right = new ArrayList<>(arr.subList(middle, arr.size()));

        return merge(mergesort(left), mergesort(right));
    }

    public static ArrayList<Integer> merge (ArrayList<Integer> arrLeft, ArrayList<Integer> arrRight){
        ArrayList<Integer> result = new ArrayList<>();

        int a = 0;
        int b = 0;

        while (a < arrLeft.size() && b < arrRight.size()) {
            if (arrLeft.get(a) <= arrRight.get(b)) {
                result.add(arrLeft.get(a));
                a++;
            }
            else {
                result.add(arrRight.get(b));
                b++;
            }
        }

        while (a < arrLeft.size()) {
            result.add(arrLeft.get(a));
            a++;
        }

        while (b < arrRight.size()) {
            result.add(arrRight.get(b));
            b++;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> testArrayList = new ArrayList<>();
        testArrayList.add(3);
        testArrayList.add(2);
        testArrayList.add(1);
        testArrayList.add(6);
        testArrayList.add(7);
        testArrayList.add(8);
        testArrayList.add(9);
        testArrayList.add(4);
        testArrayList.add(22);
        testArrayList.add(11);

        ArrayList<Integer> sortedList = mergesort(testArrayList);

        System.out.println(sortedList);
    }
}