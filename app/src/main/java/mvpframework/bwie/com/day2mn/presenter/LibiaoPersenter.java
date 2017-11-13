package mvpframework.bwie.com.day2mn.presenter;

import mvpframework.bwie.com.day2mn.bean.MusicBean;
import mvpframework.bwie.com.day2mn.model.ILibiaoModel;
import mvpframework.bwie.com.day2mn.model.LibiaoModel;
import mvpframework.bwie.com.day2mn.net.OnNetListener;
import mvpframework.bwie.com.day2mn.view.ILibiaoActivity;

/**
 * Created by 何永武 on 2017/11/11.
 */

public class LibiaoPersenter {
    private ILibiaoActivity iLibiaoActivity;
    private final ILibiaoModel libiaoModel;

    public LibiaoPersenter(ILibiaoActivity iLibiaoActivity) {
        this.iLibiaoActivity = iLibiaoActivity;
        libiaoModel = new LibiaoModel();


    }
    public void getMusic(String offset){
        libiaoModel.getMusic(offset, new OnNetListener<MusicBean>() {
            @Override
            public void OnFiale(Exception e) {

            }

            @Override
            public void OnSuccess(MusicBean musicBean) {

                iLibiaoActivity.showRv(musicBean.getSong_list());
            }
        });
    }
}
