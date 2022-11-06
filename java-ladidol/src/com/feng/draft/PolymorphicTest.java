package com.feng.draft;

//爷爷类
class Ye {
    public String show(Sun obj) {
        return ("Ye and Sun");
    }

    public String show(Ye obj) {
        return ("Ye and Ye");
    }

}
//爸爸类
class Fu extends Ye {
    public String show(Fu obj) {
        return ("Fu and Fu");
    }

    public String show(Ye obj) {
        return ("Fu and Ye");
    }
}
//儿子类
class Zi extends Fu {

}
//孙子类
class Sun extends Fu {

}

/**
 * 参数：
 * 返回值：
 * 作者： ladidol
 * 描述：主要就是一个了解多态，向上转型，继承的经典方法。
 */
public class PolymorphicTest {
    public static void main(String[] args) {
         Ye y = new Ye();
        Ye y2 = new Fu(); //向上
        Fu f = new Fu();
        Zi z = new Zi();
        Sun s = new Sun();

        // f 引用new Son（）时，Son决定了调用它的成员方法，Father决定可调用Father中的方法。

        System.out.println("第一题 " + y.show(f));
        System.out.println("第二题 " + y.show(z));
        System.out.println("第三题 " + y.show(s));
        System.out.println("第四题 " + y2.show(f)); //先看一下y2中有没有show(Ye obj)，有就看子类重写没有，重写了就直接 Fu and Ye（向上转型）
        System.out.println("第五题 " + y2.show(z)); //先看一下y2中有没有show(Ye obj)，有就看子类重写没有，重写了就直接 Fu and Ye（向上转型）
        System.out.println("第六题 " + y2.show(s)); //先看一下y2中有没有show(Sun obj)，有就看子类重写没有，没重写重写了就直接 Ye and Sun（向上转型）
        System.out.println("第七题 " + f.show(f));  //先看一下f中有没有show(Fu obj)，自己有就直接 Fu and Fu；（多态）
        System.out.println("第八题 " + f.show(z));  //先看一下f中有没有show(Fu obj)，自己有就直接 Fu and Fu；（多态）
        System.out.println("第九题 " + f.show(s));  //继承 默认有show(Sun obj)方法，所以直接用了。（继承）
     
    }
}