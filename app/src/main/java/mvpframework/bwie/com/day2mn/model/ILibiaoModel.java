package mvpframework.bwie.com.day2mn.model;

import mvpframework.bwie.com.day2mn.bean.MusicBean;
import mvpframework.bwie.com.day2mn.net.OnNetListener;

/**
 * Created by 何永武 on 2017/11/11.
 */

public interface ILibiaoModel {
    public void getMusic(String offset, OnNetListener<MusicBean> onNetListener);
}
