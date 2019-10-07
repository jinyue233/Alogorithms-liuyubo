package sorting_basic.selection_sort_using_comparable_02;

public class Student implements Comparable<Student> {
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Student otherStudent) {
        if (this.age < otherStudent.age) {
            return -1;
        } else if (this.age > otherStudent.age) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.name + ":" + this.age;
    }
}
