package mvpframework.bwie.com.day2mn.model;

import mvpframework.bwie.com.day2mn.bean.LoginBean;
import mvpframework.bwie.com.day2mn.net.OnNetListener;

/**
 * Created by 何永武 on 2017/11/11.
 */

public interface ILoginModel {
    public void login(String account,String pwd, OnNetListener<LoginBean> onNetListener);

}
