package top.dyw.write_exam.bytedance;

import java.util.Arrays;

public class B01版本号排序 {

    public static void main(String[] args) {
        String[] versions = {
                "1.45", "1.5", "6", "3.3.3.3.3.3"
        };

        sortVersions(versions);

        for (String version : versions) {
            System.out.println(version);
        }
    }

    private static void  sortVersions(String[] versions) {
        int n = versions.length;
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (compareToVersion(versions[j], versions[j+1]) > 0) {
                    String temp = versions[j];
                    versions[j] = versions[j+1];
                    versions[j+1] = temp;
                }
            }
        }
    }

    private static int compareToVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int n = Math.max(v1.length, v2.length);

        for (int i=0; i<n; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1!=num2) {
                return Integer.compare(num1, num2);
            }
        }
        return 0;
    }
}
