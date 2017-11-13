package mvpframework.bwie.com.day2mn.presenter;

import mvpframework.bwie.com.day2mn.view.IreActivity;

/**
 * Created by 何永武 on 2017/11/11.
 */

public class ReclayPersenter {
    public IreActivity ireActivity;

    public ReclayPersenter(IreActivity ireActivity) {
        this.ireActivity = ireActivity;

    }
    public void toReclay(){
        ireActivity.Tolb();
    }

}
