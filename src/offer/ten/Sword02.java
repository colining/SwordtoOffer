package offer.ten;

/**
 * Created by asus on 2017/5/7.
 */
class Singleton1 {
    /*
    饿汉式，非常急，着急的就把单例初始化了，不会遇见线程问题
     */
    static private Singleton1 sword = new Singleton1(); //类加载时直接创建实例，类只加载一次，所以单例只有一个

    private Singleton1() {
    }

    static public Singleton1 getSword() {
        if (sword == null)
            sword = new Singleton1();
        return sword;
    }

}

class Singleton2 {
    /*
    懒汉，线程同步会出现问题
     */
    static private Singleton2 sword = null;

    private Singleton2() {                             //不允许其他类调用，但是自己可以调用
    }

    static public Singleton2 getSword() {            //该方法调用构造方法，其他类调用此方法；
        if (sword == null)                            //假设现在两个线程同时到达这里，他们各自创建了他们自己的单例
            sword = new Singleton2();                  //线程不安全
        return sword;
    }

}

class Singleton3 {
    /*
    线程加锁
     */
    static private Singleton3 sword = new Singleton3(); //类加载时直接创建实例，类只加载一次，所以单例只有一个

    private Singleton3() {
    }

    static public synchronized Singleton3 getSword() {  //锁起来好了，这样俩线程肯定不能同时访问喽
        if (sword == null)                              //但是多线程每次都得等，太慢
            sword = new Singleton3();
        return sword;
    }

    static public Singleton3 getSword1() {             //锁起来好了，这样俩线程肯定不能同时访问喽
        if (sword == null)                             //只在实例却是未初始化时，进行同步；
            synchronized (Singleton3.class) {          //不过据说不靠谱
                if (sword == null)
                    sword = new Singleton3();
            }
        return sword;
    }

}

class Singleton4 {
    /*
    静态内部类
     */
    private static class LazyHolder {
        private static final Singleton4 sword = new Singleton4();
    }

    private Singleton4() {
    }

    public static final Singleton4 getInstance() {
        return LazyHolder.sword;
    }

}


class Test {
    public static void main(String[] args) {
        Singleton1 singleton = Singleton1.getSword();

    }
}
