package com.cos.reactivetest;

public class App {
    
    public static void main(String[] args) {
        MyPub pub = new MyPub(); // �Ź��� ����
        MySub sub = new MySub(); // ������ ����
        
        pub.subscribe(sub);
    }
}
