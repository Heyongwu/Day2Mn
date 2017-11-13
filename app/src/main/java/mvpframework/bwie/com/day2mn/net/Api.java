package mvpframework.bwie.com.day2mn.net;

/**
 * Created by 何永武 on 2017/11/11.
 */

public interface Api{
        public static final String DEV = "http://120.27.23.105/";
        public static final String url = "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=%s";
        public static final String LOGIN = DEV + "user/login";//登陆
        public static final String REGISTER = DEV + "user/reg";//注册
}
