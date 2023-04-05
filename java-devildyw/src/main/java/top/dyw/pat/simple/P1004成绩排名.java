package top.dyw.pat.simple;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Devil
 * @since 2022-10-06-12:55
 */
@SuppressWarnings("all")
public class P1004成绩排名 {

    static class Student{
        private String name;
        private String id;
        private Integer score;

        public Student(String name, String id, Integer score) {
            this.name = name;
            this.id = id;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return name+" "+id;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String name = input.next();
            String id = input.next();
            Integer score = input.nextInt();
            students[i] = new Student(name,id,score);
        }

        Arrays.sort(students, (s1,s2)->{
            return s2.score-s1.score;
        });

        System.out.println(students[0]+"\n"+students[n-1]);
    }
}
