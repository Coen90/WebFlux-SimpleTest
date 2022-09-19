package com.cos.reactivetest;

public class App {
    
    public static void main(String[] args) {
        MyPub pub = new MyPub(); // 脚巩荤 积己
        MySub sub = new MySub(); // 备刀磊 积己
        
        pub.subscribe(sub);
    }
}
