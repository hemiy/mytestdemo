package hemiy.qinghui.com.mytestdemo.rxbus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import hemiy.qinghui.com.mytestdemo.util.LogUtil;
import rx.Observable;
import rx.Subscriber;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * http://www.jianshu.com/p/71ab00a2677b  【支持Sticky事件】
 * http://www.jianshu.com/p/0493cc28a811   【异常处理】
 * Created by hemiy on 16/9/30 16:58.
 */

public class RxBusSticky {
    private static volatile RxBusSticky mDefaultInstance;
    private final Subject<Object, Object> mBus;

    private final Map<Class<?>, Object> mStickyEventMap;

    public RxBusSticky() {
        mBus = new SerializedSubject<>(PublishSubject.create());
        mStickyEventMap = new ConcurrentHashMap<>();
    }

    public static RxBusSticky getDefault() {
        if (mDefaultInstance == null) {
            synchronized (RxBus.class) {
                if (mDefaultInstance == null) {
                    mDefaultInstance = new RxBusSticky();
                }
            }
        }
        return mDefaultInstance;
    }

    /**
     * 发送事件 必须先订阅 再发送消息,否则不能收到消息
     */
    public void post(Object event) {
        mBus.onNext(event);
    }

    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     */
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return mBus.ofType(eventType);
    }

    /**
     * 判断是否有订阅者
     */
    public boolean hasObservers() {
        return mBus.hasObservers();
    }

    public void reset() {
        mDefaultInstance = null;
    }

    /**
     * Stciky 相关
     */

    /**
     * 发送一个新Sticky事件,可以先发送再订阅
     */
    public void postSticky(Object event) {
        synchronized (mStickyEventMap) {
            mStickyEventMap.put(event.getClass(), event);
        }
        post(event);
    }

    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     */
    public <T> Observable<T> toObservableSticky(final Class<T> eventType) {
        synchronized (mStickyEventMap) {
            Observable<T> observable = mBus.ofType(eventType);
            final Object event = mStickyEventMap.get(eventType);

            if (event != null) {
                return observable.mergeWith(Observable.create(new Observable.OnSubscribe<T>() {
                    @Override
                    public void call(Subscriber<? super T> subscriber) {
                        subscriber.onNext(eventType.cast(event));
                    }
                }));
            } else {
                return observable;
            }
        }
    }

    /**
     * 根据eventType获取Sticky事件
     */
    public <T> T getStickyEvent(Class<T> eventType) {
        synchronized (mStickyEventMap) {
            return eventType.cast(mStickyEventMap.get(eventType));
        }
    }

    /**
     * 移除指定eventType的Sticky事件
     */
    public <T> T removeStickyEvent(Class<T> eventType) {
        synchronized (mStickyEventMap) {
            return eventType.cast(mStickyEventMap.remove(eventType));
        }
    }

    /**
     * 移除所有的Sticky事件
     */
    public void removeAllStickyEvents() {
        synchronized (mStickyEventMap) {
            LogUtil.i("sticky事件删除了");
            mStickyEventMap.clear();
        }
    }
}
