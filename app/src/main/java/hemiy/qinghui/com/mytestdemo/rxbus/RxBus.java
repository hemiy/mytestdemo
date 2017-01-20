package hemiy.qinghui.com.mytestdemo.rxbus;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * http://www.jianshu.com/p/ca090f6e2fe2
 * http://www.jianshu.com/p/71ab00a2677b   深入RxBus：［支持Sticky事件］
 * Created by hemiy on 16/9/30 15:35.
 */

//
//    注：
// 1、Subject同时充当了Observer和Observable的角色，Subject是非线程安全的，要避免该问题
// ，需要将 Subject转换为一个 SerializedSubject ，上述RxBus类中把线程非安全的PublishSubject包装成线程安全的Subject。
//
// 2、PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者。
//
// 3、ofType操作符只发射指定类型的数据，其内部就是filter+cast

// 4、filter操作符可以使你提供一个指定的测试数据项，只有通过测试的数据才会被“发射”。
//      cast操作符可以将一个Observable转换成指定类型的Observable。



//1、首先创建一个可同时充当Observer和Observable的Subject；
//
//2、在需要接收事件的地方，订阅该Subject（此时Subject是作为Observable），在这之后，一旦Subject接收到事件，立即发射给该订阅者；
//
//3、在我们需要发送事件的地方，将事件post至Subject，此时Subject作为Observer接收到事件（onNext），然后会发射给所有订阅该Subject的订阅者。




    //必须先订阅 再发送,可以支持在不同的activity里面传递数据

public class RxBus {
//    volatile 保证instance可见性 禁止指令重排
// 参考资料   http://www.infoq.com/cn/articles/java-memory-model-4

    private static volatile RxBus defaultInstance;

    private final Subject<Object, Object> bus;
    // PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者--------注意理解 如果先发送再订阅则不会受到数据
    public RxBus() {
        bus = new SerializedSubject<>(PublishSubject.create());
    }
    // 单例RxBus
    public static RxBus getDefault() {
        if (defaultInstance == null) {
            synchronized (RxBus.class) {
                if (defaultInstance == null) {
                    defaultInstance = new RxBus();
                }
            }
        }
        return defaultInstance ;
    }
    // 发送一个新的事件
    public void post (Object o) {
        bus.onNext(o);
    }
    // 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
    public <T> Observable<T> toObservable (Class<T> eventType) {
        return bus.ofType(eventType);
    }
}
