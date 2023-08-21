package com.feng.面试题._4399;

public class HelloWorld {
    public static void main(String[] args) {
        String input = "Hello World";
        String[] words = input.split("\\s+"); // 以空格分割单词

        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            StringBuilder processedWord = new StringBuilder();

            for (char c : word.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    processedWord.append(Character.toLowerCase(c));
                } else if (Character.isLowerCase(c)) {
                    processedWord.append(Character.toUpperCase(c));
                } else {
                    processedWord.append(c);
                }
            }

            result.append(processedWord).append(" ");
        }
        String substring = result.substring(0, 1);
        System.out.println("substring = " + substring);
        result.setLength(result.length() - 1); // 移除最后一个空格
        System.out.println(result.toString());
    }
}