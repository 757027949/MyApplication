package asd.com.test.rx;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by Administrator on 2016/10/13.
 */

public class RxUtils {



    public static Observable<String> create() {

        Observable<String> stringObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("就是你....");
                subscriber.onCompleted();
            }
        });
        return stringObservable;
    }
}
