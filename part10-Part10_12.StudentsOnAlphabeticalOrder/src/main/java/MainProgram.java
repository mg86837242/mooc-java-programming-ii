import java.util.List;

public class MainProgram {

    public static void main(String[] args) {
        Student first = new Student("jamo");
        Student second = new Student("jamo1");
        System.out.println(first.compareTo(second));

        List<Student> students = List.of(new Student("aaaa"), new Student("BBB"), new Student("bb"), new Student("bbb"),
                new Student("cc"),
                new Student("d"));
        students.stream().sorted().forEach(student -> System.out.println(student));
    }
}
