package mvpframework.bwie.com.day2mn.model;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;

import mvpframework.bwie.com.day2mn.bean.MusicBean;
import mvpframework.bwie.com.day2mn.net.Api;
import mvpframework.bwie.com.day2mn.net.HttpUtils;
import mvpframework.bwie.com.day2mn.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 何永武 on 2017/11/11.
 */

public class LibiaoModel implements ILibiaoModel{
    private Handler handler = new Handler(Looper.getMainLooper());


    @Override
    public void getMusic(String offset, final OnNetListener<MusicBean> onNetListener) {
        String s = String.format(Api.url, offset);
        HttpUtils.getHttpUtils().doGet(s, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.OnFiale(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final MusicBean fromJson = new Gson().fromJson(string, MusicBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.OnSuccess(fromJson);
                    }
                });

            }
        });
    }
}
