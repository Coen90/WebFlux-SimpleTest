package com.cos.reactivetest;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class MySub implements Subscriber<Integer> {
    
    private Subscription s;
    private int bufferSize = 3;

    public void onSubscribe(Subscription s) {
        System.out.println("구독자 : 구독 정보 잘 받았어");
        this.s = s;
        System.out.println("구독자 : 나 이제 신문 1개씩 줘!");
        s.request(bufferSize); // 신문 한개씩 매일매일 줘! (백프레셔) 소비자가 한번에 처리할 수 있는 개수를 요청
    }

    public void onNext(Integer t) { 
        System.out.println("onNext() : " + t);
        bufferSize--;
        if (bufferSize == 0) {
            System.out.println("하루 지남");
            bufferSize = 3;
            s.request(bufferSize);
        }
    }

    public void onError(Throwable t) {
        System.out.println("구독중 에러");
    }

    public void onComplete() {
        System.out.println("구독 완료");
    }

    
}
