package top.dyw.leetcode.algorithm.贪心;

import sun.misc.Launcher;
import sun.misc.URLClassPath;

import java.net.URL;

public class Test{

    public static void main(String[] args) {

        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@677327b6

        //获取其上层：引导类加载器
        ClassLoader bootstarpClassLoader = extClassLoader.getParent();
        System.out.println(bootstarpClassLoader);//null

        //对于用户自定义类来说：使用的是系统类加载器
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2


        //获取 BootstrapClassLoader 能够加载的api的路径
        URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
        URL[] urLs = bootstrapClassPath.getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
        }

        System.out.println("************扩展类加载器***********");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String s : extDirs.split(";")) {
            System.out.println(s);
        }

    }


}
