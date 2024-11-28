import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        CustomMutableClass mutableClass = new CustomMutableClass(10);


        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);


        ImmutableClass immutableClass = new ImmutableClass("Example", numbers, mutableClass);


        System.out.println("Initial state: " + immutableClass);


        List<Integer> numbersReference = immutableClass.getNumbers();



        CustomMutableClass mutableClassReference = immutableClass.getCustomMutableClass();
        mutableClassReference.setValue(20);


        System.out.println("State after attempted modification: " + immutableClass);


        Map<ImmutableClass, String> map = new HashMap<>();
        map.put(immutableClass, "Value");


        System.out.println("Map contains key: " + map.containsKey(immutableClass));
    }
}