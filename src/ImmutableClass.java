import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class ImmutableClass {
    private final String name;
    private final List<Integer> numbers;
    private final CustomMutableClass customMutableClass;

    public ImmutableClass(String name, List<Integer> numbers, CustomMutableClass customMutableClass) {
        this.name = name;
        this.numbers = new ArrayList<>(numbers); // Создаем копию списка
        this.customMutableClass = new CustomMutableClass(customMutableClass.getValue()); // Создаем копию объекта
    }

    public String getName() {
        return name;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers); // Возвращаем неизменяемую копию списка
    }

    public CustomMutableClass getCustomMutableClass() {
        return new CustomMutableClass(customMutableClass.getValue()); // Возвращаем копию объекта
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableClass that = (ImmutableClass) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(numbers, that.numbers) &&
                Objects.equals(customMutableClass.getValue(), that.customMutableClass.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numbers, customMutableClass.getValue());
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "name='" + name + '\'' +
                ", numbers=" + numbers +
                ", customMutableClass=" + customMutableClass +
                '}';
    }
}