package mvpframework.bwie.com.day2mn.net;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by 何永武 on 2017/11/11.
 */

public class HttpUtils {
    public static HttpUtils httpUtils;
    private final OkHttpClient client;

    public HttpUtils() {
        client = new OkHttpClient.Builder().addInterceptor(new LoggingInterceptor())
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build();

    };
    public static HttpUtils getHttpUtils(){
        if(httpUtils == null){
            synchronized (HttpUtils.class){
                if(httpUtils == null){
                    httpUtils= new HttpUtils();
                }
            }
        }
        return httpUtils;
    };
    public void doGet(String url, Callback callback){
        Request build = new Request.Builder().url(url).build();
        client.newCall(build).enqueue(callback);

    }
    public  void doPost(String url, Map<String,String> params,Callback callback){
        FormBody.Builder builder = new FormBody.Builder();
        for(Map.Entry<String,String> entry:params.entrySet()){
            builder.add(entry.getKey(),entry.getValue());
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        client.newCall(request).enqueue(callback);
    }

}
