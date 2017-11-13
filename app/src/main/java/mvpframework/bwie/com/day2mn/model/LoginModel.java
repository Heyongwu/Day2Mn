package mvpframework.bwie.com.day2mn.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import mvpframework.bwie.com.day2mn.bean.LoginBean;
import mvpframework.bwie.com.day2mn.net.Api;
import mvpframework.bwie.com.day2mn.net.HttpUtils;
import mvpframework.bwie.com.day2mn.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by 何永武 on 2017/11/11.
 */

public class LoginModel extends BaseModel implements ILoginModel{



    @Override
    public void login(String account, String pwd, final OnNetListener onNetListener) {
        Map<String,String> params = new HashMap<>();
        params.put("mobile",account);
        params.put("password",pwd);
        HttpUtils.getHttpUtils().doPost(Api.LOGIN, params, new Callback() {
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
                final LoginBean loginBean = new Gson().fromJson(string, LoginBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.OnSuccess(loginBean);
                    }
                });


            }
        });

    }
}
