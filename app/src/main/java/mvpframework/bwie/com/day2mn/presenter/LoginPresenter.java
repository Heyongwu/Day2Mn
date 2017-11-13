package mvpframework.bwie.com.day2mn.presenter;

import android.text.TextUtils;

import mvpframework.bwie.com.day2mn.bean.LoginBean;
import mvpframework.bwie.com.day2mn.model.ILoginModel;
import mvpframework.bwie.com.day2mn.model.LoginModel;
import mvpframework.bwie.com.day2mn.net.OnNetListener;
import mvpframework.bwie.com.day2mn.view.IMainactivity;

/**
 * Created by 何永武 on 2017/11/11.
 */

public class LoginPresenter {
    private IMainactivity iMainactivity;
    private final ILoginModel iLoginModel;

    public LoginPresenter(IMainactivity iMainactivity) {
        this.iMainactivity = iMainactivity;
        iLoginModel = new LoginModel();


    }
    public void login(){
        final String account = iMainactivity.getAccount();
        final String pwd = iMainactivity.getPwd();
        if(checkPwd(pwd)&&checkAccount(account)){
            iLoginModel.login(account, pwd, new OnNetListener<LoginBean>() {
                @Override
                public void OnFiale(Exception e) {

                }

                @Override
                public void OnSuccess(LoginBean loginBean) {
                    iMainactivity.showData(loginBean.getMsg());
                    iMainactivity.ToResiter();
                }
            });
        }

    }
    private boolean checkPwd(String pwd){
        if(TextUtils.isEmpty(pwd)){
            iMainactivity.showData("输入密码");
            return false;
        }
        if(pwd.length()!=6){
            iMainactivity.showData("密码长度为6位");
            return  false;
        }
        return true;
    }
    private boolean checkAccount(String account){
        if(TextUtils.isEmpty(account)){
            iMainactivity.showData("输入账号");
            return false;
        }
        if(account.length()!=11){
            iMainactivity.showData("手机号长度为11位");
            return  false;
        }
        return true;
    }


}
