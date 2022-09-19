package com.cos.reactivetest;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {
    
    private Subscription s;
    private int bufferSize = 3;

    public void onSubscribe(Subscription s) {
        System.out.println("������ : ���� ���� �� �޾Ҿ�");
        this.s = s;
        System.out.println("������ : �� ���� �Ź� 1���� ��!");
        s.request(bufferSize); // �Ź� �Ѱ��� ���ϸ��� ��! (��������) �Һ��ڰ� �ѹ��� ó���� �� �ִ� ������ ��û
    }

    public void onNext(Integer t) { 
        System.out.println("onNext() : " + t);
        bufferSize--;
        if (bufferSize == 0) {
            System.out.println("�Ϸ� ����");
            bufferSize = 3;
            s.request(bufferSize);
        }
    }

    public void onError(Throwable t) {
        System.out.println("������ ����");
    }

    public void onComplete() {
        System.out.println("���� �Ϸ�");
    }

    
}
