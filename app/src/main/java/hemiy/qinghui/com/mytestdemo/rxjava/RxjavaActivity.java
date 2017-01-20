package hemiy.qinghui.com.mytestdemo.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hemiy.qinghui.com.mytestdemo.R;
import hemiy.qinghui.com.mytestdemo.rxbus.RxBusSticky;
import hemiy.qinghui.com.mytestdemo.rxbus.UserEvent;
import hemiy.qinghui.com.mytestdemo.util.LogUtil;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * https://gank.io/post/560e15be2dca930e00da1083 给Android 开发者的 RxJava 详解
 * http://www.jianshu.com/p/e3c4280ce397
 * http://www.jianshu.com/p/72f864d5cd58
 * <p>
 * 例子和demo
 * http://blog.csdn.net/lzyzsd/article/details/50120801 RxJava使用场景小结
 * https://github.com/kaushikgopal/RxJava-Android-Samples gitup上的例子
 * Created by hemiy on 16/9/20 10:19.
 */

public class RxjavaActivity extends Activity {

    @BindView(R.id.btnRxjava1)
    Button btnRxjava1;
    @BindView(R.id.btnRxjava2)
    Button btnRxjava2;
    @BindView(R.id.btnRxjava3)
    Button btnRxjava3;
    @BindView(R.id.btnRxjava4)
    Button btnRxjava4;
    @BindView(R.id.btnRxjava5)
    Button btnRxjava5;
    @BindView(R.id.btnRxjava6)
    Button btnRxjava6;
    @BindView(R.id.btnRxjava7)
    Button btnRxjava7;
    @BindView(R.id.btnRxjava8)
    Button btnRxjava8;
    @BindView(R.id.btnRxjava9)
    Button btnRxjava9;
    @BindView(R.id.btnRxjava10)
    Button btnRxjava10;
    @BindView(R.id.btnRxjava11)
    Button btnRxjava11;
    @BindView(R.id.btnRxjava12)
    Button btnRxjava12;
    @BindView(R.id.btnRxjava13)
    Button btnRxjava13;
    @BindView(R.id.btnSendEvent)
    Button btnSendEvent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnRxjava1, R.id.btnRxjava2, R.id.btnRxjava3, R.id.btnRxjava4,
            R.id.btnRxjava5, R.id.btnRxjava6, R.id.btnRxjava7, R.id.btnRxjava8,
            R.id.btnRxjava9, R.id.btnRxjava10, R.id.btnRxjava11, R.id.btnRxjava12,
            R.id.btnRxjava13,R.id.btnSendEvent})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRxjava1:
                show();
                break;
            case R.id.btnRxjava2:
                show2();
                break;
            case R.id.btnRxjava3:
                show3();
                break;
            case R.id.btnRxjava4:
                show4();
                break;
            case R.id.btnRxjava5:
                show5();
                break;
            case R.id.btnRxjava6:
                show6();
                break;

            case R.id.btnRxjava7:
                show7();
                break;
            case R.id.btnRxjava8:
                show8();
                break;
            case R.id.btnRxjava9:
                show9();
                break;
            case R.id.btnRxjava10:
                show10();
                break;
            case R.id.btnRxjava11:
                show11();
                break;
            case R.id.btnRxjava12:
                show12();
                break;

            case R.id.btnRxjava13:
                show13();
                break;

            case R.id.btnSendEvent: //发送事件
                show14();
                break;
        }
    }

    /**
     * 发送rxBus事件
     */
    private void show14() {
        //发送事件
//        RxBus.getDefault().post(new UserEvent(2, "hemiy"));
//        Toast.makeText(this, "事件发送了", Toast.LENGTH_SHORT).show();


        //支持stick事件 可以先发送 再订阅,同样也能收到消息 注意理解时候收发的先后事件顺序
        RxBusSticky.getDefault().postSticky(new UserEvent(3,"rinn"));
        Toast.makeText(this, "事件发送了", Toast.LENGTH_SHORT).show();
    }

    /**
     * Repeat会将一个Observable对象重复发射，接收值是发射的次数，依然订阅在 computation Scheduler~
     */
    private void show13() {
        //把1打印10次出来
//        Observable.just(1).repeat(10).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                System.out.println(integer);
//            }
//        });
//
//        Observable.just("hemiy ").repeat(5).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//             LogUtil.i("------>"+s);
//            }
//        });

        Observable.just(0.23).repeat(2).subscribe(new Action1<Double>() {//把0.23打印2次出来
            @Override
            public void call(Double aDouble) {
                LogUtil.i("-----" + aDouble);
            }
        });
    }

    /**
     * error
     * 返回一个Observable，当有Observer订阅ta时直接调用Observer的onError方法终止
     * http://www.jianshu.com/p/0cb521ba1e10
     */
    private void show12() {
        Observable<String> error = Observable.error(new Throwable("Observable.error"));
        error.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());//会打印这句话 Observable.error
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext");
            }
        });
    }


    /**
     * never 创建一个Observable不发射任何数据、也不给订阅ta的Observer发出任何通知~
     * http://www.jianshu.com/p/0cb521ba1e10
     */
    private void show11() {
        //不会打印任何数据出来
        Observable<String> never = Observable.never();
        never.subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext");
            }
        });
    }

    /**
     * http://www.jianshu.com/p/0cb521ba1e10
     * Timer会在指定时间后发射一个数字0，注意其也是运行在computation Scheduler~
     */
    private void show10() {
        Observable
                .timer(2, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        // 替代timertask与handler延迟，可以在这跳转主界面
                        LogUtil.i("结束本页面"); //2s后关闭本次页面
                        finish();//
                    }
                });
    }

    /**
     * Interval所创建的Observable对象会从0开始，每隔固定的时间发射一个数字，
     * 需要注意的是这个对象是运行在computation Scheduler,所以要更新UI需要在主线程中进行订阅~
     */
    private void show9() {
        Observable
                .interval(1, TimeUnit.SECONDS) //每隔1秒发送一次
                .observeOn(AndroidSchedulers.mainThread()) //指定之后操作所在的线程,可以多次执行
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        LogUtil.i("发送的数字是" + aLong); //along这个数字从0开始
                    }
                });
    }

    /**
     * http://www.jianshu.com/p/0cb521ba1e10
     * just from的区别
     */
    private void show8() {
        // just操作符将某个对象转化为Observable对象，并且将其发射出去，可以使一个数字、一个字符串、数组、Iterate对象等
        //而使用just会发射一次来将整个的数组发射出去~
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        Observable.just(stringList).subscribe(new Action1<List<String>>() {//注意这里Action里面的参数是个list对象
            @Override
            public void call(List<String> strings) {
                Log.i("tag", strings.toString());
            }
        });

        //from会遍历集合里面的参数来,所以action里面的数据就是一个字符串了,比如说一个含有3个元素的集合，from会将集合分成3次发射

        Observable.from(stringList).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i("tag", s.toString());
            }
        });


        //总结 just("1","2","3")有这么一种写法,而from("1","2","3")没有这种写法

    }

    /**
     * 窗口，它可以批量或者按周期性从Observable收集数据到一个集合，然后把这些数据集合打包发射
     * 而不是一次发射一个数据,类似于Buffer，但Buffer发射的是数据，Window发射的是Observable~
     * <p>
     * <p>
     * Range操作符根据输入的初始值【initial】和数量【number】发射number次、大于等于initial的值~
     */
    private void show7() {
        Observable.range(1, 5).window(2).subscribe(new Action1<Observable<Integer>>() {
            @Override
            public void call(Observable<Integer> integerObservable) {
                System.out.println("onOutsideNext -->" + integerObservable);
                integerObservable.subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println("onInsideNext -->" + integer);
                    }
                });
            }
        });


    }

    /**
     * https://gank.io/post/560e15be2dca930e00da1083
     * http://www.jianshu.com/p/fafc82b579cd
     * 扁平映射的使用
     */
    private void show6() {
//        flatMap() 和 map() 有一个相同点：它也是把传入的参数转化之后返回另一个对象。
//        但需要注意，和 map() 不同的是， flatMap() 中返回的是个 Observable 对象
        final List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        Observable.just(stringList).flatMap(new Func1<List<String>, Observable<String>>() {
            @Override
            public Observable<String> call(List<String> list) {
                return Observable.from(list);//转换为一个Observable对象,依次把list里面的数据"遍历"发送出来
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String next) {
                System.out.println("onNext -->" + next);
            }
        });

    }

    /**
     * 使用了buffer
     * 可以简单的理解为缓存，它可以批量或者按周期性从Observable收集数据到一个集合，然后把这些数据集合打包发射，而不是一次发射一个数据~
     */
    private void show5() {
        //Range操作符根据输入的初始值【initial】和数量【number】发射number次、大于等于initial的值~
        //buffer一次订阅2个--------注意这里是把数据收集到一个集合里,所以下面参数是个list

        Observable.range(1, 5).buffer(2).subscribe(new Subscriber<List<Integer>>() { //这里从1开始,发送5次
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onNext(List<Integer> integers) {
                Log.i("tag", "onNext" + integers.toString()); //注意理解,收集数据到一个集合
            }
        });
    }

    /**
     * 使用map来进行转换
     */
    private void show4() {

//        Fun1 第一个参数是输入参数类型,第二个参数是输出参数类型
        Observable.just(nowTime()).map(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return "北京时间------->" + s;
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i("tag", s);
            }
        });
    }

    private void show3() {
//        just操作符将某个对象转化为Observable对象，并且将其发射出去，可以使一个数字、一个字符串、数组、Iterate对象等，
//        是一种非常快捷的创建Observable对象的方法~
        Observable.just(nowTime()).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i("tag ", s);
            }
        });

    }

    private String nowTime() {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = sim.format(System.currentTimeMillis());
        String time = sim.format(new Date());//打印当前时间
        return time;
    }

    //简化版本
    private void show2() {

        Observable.just("hemiy").subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                //发送后的数据会到这里进行打印
                Toast.makeText(RxjavaActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

    }


    //最原始的版本
    private void show() {


        //观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(String s) {
                Log.i("tag", s);
            }
        };
        //被观察者
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                //执行3次
                subscriber.onNext("Hello world_1,hemiy");
                subscriber.onNext("Hello world_2,rinn");
                subscriber.onNext("Hello world_3,tom");
            }
        });
        //订阅
        observable.subscribe(observer);
    }


//一个比较

//    new Thread() {
//        @Override
//        public void run() {
//            super.run();
//            for (File folder : folders) {
//                File[] files = folder.listFiles();
//                for (File file : files) {
//                    if (file.getName().endsWith(".png")) {
//                        final Bitmap bitmap = getBitmapFromFile(file);
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                imageCollectorView.addImage(bitmap);
//                            }
//                        });
//                    }
//                }
//            }
//        }
//    }.start();


//    Observable.from(folders)
//            .flatMap(new Func1<File, Observable<File>>() {
//        @Override
//        public Observable<File> call(File file) {
//            return Observable.from(file.listFiles());
//        }
//    })
//            .filter(new Func1<File, Boolean>() {
//        @Override
//        public Boolean call(File file) {
//            return file.getName().endsWith(".png");
//        }
//    })
//            .map(new Func1<File, Bitmap>() {
//        @Override
//        public Bitmap call(File file) {
//            return getBitmapFromFile(file);
//        }
//    })
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(new Action1<Bitmap>() {
//        @Override
//        public void call(Bitmap bitmap) {
//            imageCollectorView.addImage(bitmap);
//        }
//    });



}
