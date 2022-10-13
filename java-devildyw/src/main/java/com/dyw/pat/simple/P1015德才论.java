package com.dyw.pat.simple;

import java.util.*;

/**
 * @author Devil
 * @since 2022-10-13-19:18
 */
@SuppressWarnings("all")
public class P1015德才论 {
    static class Student{
        Integer id;

        Integer deScore;

        Integer caiSocre;

        Integer total;

        Integer type;

        public Student(Integer id, Integer deScore, Integer caiSocre,Integer h) {
            this.id = id;
            this.deScore = deScore;
            this.caiSocre = caiSocre;
            total = deScore+caiSocre;
            if (deScore>=h&&caiSocre>=h){
                this.type = 1;
            }else if (deScore>=h&&caiSocre<h){
                this.type = 2;
            } else if (deScore < h && caiSocre < h && deScore >= caiSocre) {
                this.type = 3;
            }else {
                this.type = 4;
            }
        }


        @Override
        public String toString() {
            return id+" "+deScore+" "+caiSocre;
        }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int l = input.nextInt();
        int h = input.nextInt();

        List<Student> students = new ArrayList<>();

        //德才全尽 德才分 >=h
        //德胜才 才<h 但 德 >= h
        //才德兼亡 德 才< h 但 德>=才
        //最低录取 除上述情况 但 德才都大于l

        for (int i = 0; i < n; i++) {
            Integer id = input.nextInt();
            Integer deScore = input.nextInt();
            Integer caiScore = input.nextInt();
            if (deScore>=l&&caiScore>=l){
                students.add(new Student(id,deScore,caiScore,h));
            }
        }

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.type==o2.type){
                    if (o1.total.equals(o2.total)){
                        if (o1.deScore.equals(o2.deScore)){
                            return o1.id-o2.id;
                        }
                        return o2.deScore - o1.deScore;
                    }
                    return o2.total - o1.total;
                }
                return o1.type-o2.type;
            }
        });

        for (Student student : students) {
            System.out.println(student);
        }



    }

}
