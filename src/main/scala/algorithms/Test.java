package algorithms;

import java.util.HashMap;

public class Test {
    Test() {}

    class Student{
        @Override
        public String toString() {
            return "Object Student";
        }

        String name = "mayur";
        Student() {
            this.name = "mayur";
        }

        @Override
        public int hashCode() {
            return (int) Math.random();
        }
    }

    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<String, Student>();

        Test t = new Test();

         Student s =  t.new Student();
        map.put(s.name, s);
        System.out.println(map.get(s.name).toString());

    }
}
