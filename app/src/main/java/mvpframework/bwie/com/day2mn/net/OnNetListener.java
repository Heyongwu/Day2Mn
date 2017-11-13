package mvpframework.bwie.com.day2mn.net;

/**
 * Created by 何永武 on 2017/11/11.
 */

public interface OnNetListener<T> {
    public void OnFiale(Exception e);
    public void OnSuccess(T t);
}
