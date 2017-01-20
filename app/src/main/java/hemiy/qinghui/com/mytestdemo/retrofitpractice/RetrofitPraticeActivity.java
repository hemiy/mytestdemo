package hemiy.qinghui.com.mytestdemo.retrofitpractice;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import hemiy.qinghui.com.mytestdemo.R;
import hemiy.qinghui.com.mytestdemo.retorfit.ApiService;
import hemiy.qinghui.com.mytestdemo.retrofitpractice.notuse.BaseActivity;
import hemiy.qinghui.com.mytestdemo.retrofitpractice.progress.Order;
import hemiy.qinghui.com.mytestdemo.retrofitpractice.progress.ProgressSubscriber;
import hemiy.qinghui.com.mytestdemo.retrofitpractice.progress.ProgressFunSubscriber;
import hemiy.qinghui.com.mytestdemo.retrofitpractice.progress.User;
import hemiy.qinghui.com.mytestdemo.util.ApiSignUtil;
import hemiy.qinghui.com.mytestdemo.util.Md5Util;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hemiy on 16/11/19 14:25.
 */

public class RetrofitPraticeActivity extends BaseActivity {

    @BindView(R.id.btnRetrofit)
    Button btnRetrofit;
    @BindView(R.id.tvResult)
    TextView tvResult;
    @BindView(R.id.btnRetrofit2)
    Button btnRetrofit2;
    @BindView(R.id.btnRetrofit3)
    Button btnRetrofit3;

    private Context context;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_practice);
        ButterKnife.bind(this);
        context = this;
        btnRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sendNetRequest();
                sendNetRequest1();
            }
        });

        btnRetrofit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendGetOrder();
            }
        });


        btnRetrofit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMapRequest();
            }
        });

    }




    /**
     * 获取订单数组请求
     */
    private void sendGetOrder() {
        try {
            Map<String, Object> params = new HashMap<String, Object>();

            params.put("avatarId", id);
            params.put("status", "");
            params.put("page", "1");
            params.put("limit", "100");
            generateMap(params);


            ApiService api = RetrofitServiceManager.getInstance().getApi();
            api.getOrderList(params)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new ProgressSubscriber<List<Order>>(context) {
//                        @Override
//                        public void responseSuccess(HttpResult<List<Order>> t) {
//                            Log.i("tag", t.toString());
//                            Log.i("tag", t.getResult().toString());
//                            Log.i("tag", t.getResult().get(0).getItems().size() + "这个是item的数量");
//                        }
//                    });

                    //上下2种方式都可以
                    .map(new HttpResultFunc<List<Order>>())
                    .subscribe(new ProgressFunSubscriber<List<Order>>(context) {
                        @Override
                        public void responseSuccess(List<Order> orders) {

                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 发送网络请求
     */
    private void sendNetRequest() {
        try {
            Map<String, Object> params = new HashMap<String, Object>();

            params.put("phone", "15989009055");
            params.put("password", Md5Util.md5("123456"));
            generateMap(params);

            ApiService api = RetrofitServiceManager.getInstance().getApi();

            api.postLogin2(params)
//                        .flatMap(new Func1<HttpResult<User>, Observable<HttpResult<User>>>() {
//                            @Override
//                            public Observable<HttpResult<User>> call(HttpResult<User> userHttpResult) {
//                                return null;
//                            }
//                        })
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new ProgressSubscriber<User>(context) {
                        @Override
                        public void responseSuccess(HttpResult<User> t) {
                            Log.i("tag", t.toString());
//                            Log.i("tag",t.getResult().toString());

                            //走到这里一定是请求成功的,而且code的值肯定是1
                            //如果code的值不是1,下面的代码不执行,走onError方法
                            User user = t.getResult();
                            tvResult.setText(user.getCommunityAddress());
                        }
                    });


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void sendNetRequest1() {
        try {
            Map<String, Object> params = new HashMap<String, Object>();

            params.put("phone", "15989009055");
            params.put("password", Md5Util.md5("123456"));
            generateMap(params);

            ApiService api = RetrofitServiceManager.getInstance().getApi();
            api.postLogin2(params)
                    .map(new Func1<HttpResult<User>, String>() {

                        @Override
                        public String call(HttpResult<User> userHttpResult) {
                            return userHttpResult.getResult().getAvatarId(); //取出里面的数据
                            //取出的数据是一个字符串,所以subscribe里面形参也是一个字符串
                        }
                    })
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Action1<String>() {
                        @Override
                        public void call(String s) {
                            tvResult.setText(s);
                            id = s;
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void sendMapRequest() {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("phone", "15989009055");
            params.put("password", Md5Util.md5("1234356"));

            generateMap(params);
            ApiService api = RetrofitServiceManager.getInstance().getApi();
            api.postLogin2(params)
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    //如果用了fun的转换,则progressFucSubscriber必须也要有fun,否则会报错
                    .map(new HttpResultFunc<User>())//经过这个一步得到的数据就是把里面的User数据取出来的了,同时如果有错误会处理
                    .subscribe(new ProgressFunSubscriber<User>(context) {
                        @Override
                        public void responseSuccess(User user) {
                                Log.i("tag","转化的map结果是"+user.toString());
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 添加2个参数 改变map里面的数据
     *
     * @param params
     * @return
     * @throws Exception
     */
    private Map<String, Object> generateMap(Map<String, Object> params) throws Exception {
        params.put("timestamp", System.currentTimeMillis() + "");
        params.put("sign", ApiSignUtil.buildSignByMap(params));
        return params;
    }


}


//     参考例子

//    GitHubService service = ServiceGenerator.createService(GitHubService.class);
//    String username = inputUserNameView.getText().toString();
//    service.getUserFollowingObservable(username)
//            .subscribeOn(Schedulers.io())  // 在io线程做, 指定了被观察者的处理线程
//            .observeOn(AndroidSchedulers.mainThread()) //指定最后onNext()回调在主线程, 即指定了通知后续观察者的线程.
//            .subscribe(new Subscriber<List<User>>() {
//        @Override
//        public void onCompleted() {
//
//        }
//
//        @Override
//        public void onError(Throwable e) {
//
//        }
//
//        @Override
//        public void onNext(List<User> users) {
//            LogUtils.i("onNext: " + users.size());
//            peopleListAdapter.setUsers(users);
//            peopleListAdapter.notifyDataSetChanged();
//        }
//    });
