
// Definir la interfaz MinMaxInterface
interface MinMaxInterface<T> {
    T min();
    T max();
}

// Implementar la clase genérica MinMax
class MinMax<T extends Comparable<T>> implements MinMaxInterface<T> {
    private T[] array;

    public MinMax(T[] array) {
        this.array = array;
    }

    @Override
    public T min() {
        T minValue = array[0];
        for (T value : array) {
            if (value.compareTo(minValue) < 0) {
                minValue = value;
            }
        }
        return minValue;
    }

    @Override
    public T max() {
        T maxValue = array[0];
        for (T value : array) {
            if (value.compareTo(maxValue) > 0) {
                maxValue = value;
            }
        }
        return maxValue;
    }
}

// Clase Student que implementa Comparable
class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

// Método main para probar la implementación
public class ParameterizedInterface {
    public static void main(String[] args) {
        Integer [] values = {10, 1, 4, 6, 2, 6, 3, 8, 12, 5};
        MinMax<Integer> m = new MinMax<> (values);
        System.out.println (m.min ());
        System.out.println (m.max ());

        Character [] letters = { 'z', 'x', 'c', 'w', 'g', 'l', 'p', 'k', 'a', 't' };
        MinMax<Character> c = new MinMax<> (letters);
        System.out.println (c.min ());
        System.out.println (c.max ());

        Student [] students = {
                new Student ("Grissel", 28),
                new Student ("Cintya", 25),
                new Student ("Perla", 31)
        };

        MinMax<Student> e = new MinMax<Student> (students);
        System.out.println (e.min ());
        System.out.println (e.max ());
    }
}
