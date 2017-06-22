package asd.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import asd.com.test.rx.RxUtils;
import butterknife.BindView;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;

public class Activity_Rxandroid extends AppCompatActivity {

    @BindView(R.id.mes)
    EditText mes;

    String[] name = {"zhangsan", "lishi", "wangwu"};
    String[][] sets = {{"11", "12"}, {"21", "22"}, {"31", "32", "33"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

//        one();
//        two();
//        three();
//        four();
//        five();
//        sex();
//        seven();
//        eight();
//        night();
//        ten();
        distinctUntilChanged();

//        last();
    }

    private void distinctUntilChanged() {
        Observable.just(0, 1, 1, 2, 3, 4, 3, 4, 5, 6).distinctUntilChanged().subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Logger.e(integer + "--");
            }
        });
    }

    private void ten() {
        Observable.just(0, 1, 1, 2, 3, 4, 3, 4, 5, 6).distinct().subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Logger.e(integer + "--");
            }
        });
    }

    private void night() {
        Subscription subscribe = Observable.just(0, 1, 2, 3, 4, 5).take(3).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Logger.e(integer + "------");
            }
        });
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        compositeSubscription.add(subscribe);
        if(compositeSubscription!=null&&compositeSubscription.hasSubscriptions()){

        }
    }

    private void eight() {
        Observable.just(0, 1, 2, 3, 4).filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 1;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Logger.e(integer + "----");
            }
        });
    }

    private void seven() {
        Observable.from(sets).flatMap(new Func1<String[], Observable<String>>() {
            @Override
            public Observable<String> call(String[] strings) {
                return Observable.from(strings);
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Logger.e(s);
            }
        });
    }

    private void sex() {
        Observable.from(name).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return "My name:" + s;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Logger.e(s);
            }
        });
    }

    private void five() {
        Observable.just(0, 1, 2, 3).repeat(2).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer + "fuck....";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Logger.e(s);
            }
        });
    }

    private void four() {
        Observable.just(0, 1).repeat(2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Logger.e(integer + "------");
            }
        });
    }

    private void three() {
        Observable.range(0, 10).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Logger.e(integer + "-----");
            }
        });
    }

    private void two() {
        Observable<Integer> observable1 = Observable.just(1, 2, 3);
        observable1.subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Logger.e(integer + "-------");
            }
        });
    }

    private void last() {
        RxUtils.create().subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.err.println("onCompleted...");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Logger.e(s);
            }
        });
    }

    private void one() {
        //观察者
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Logger.e(s);
            }
        };
        //被观察者
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("onNext...");// 发送事件
                subscriber.onCompleted();// 完成事件
            }
        });
        observable.subscribe(subscriber);
    }

}