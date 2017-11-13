package mvpframework.bwie.com.day2mn.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import mvpframework.bwie.com.day2mn.R;
import mvpframework.bwie.com.day2mn.presenter.ReclayPersenter;

public class ReclayViewActivity extends AppCompatActivity implements IreActivity ,View.OnClickListener {

    /**
     * QQ登录
     */
    private TextView mTvQq;
    private LinearLayout mActivityReclayView;
    /**
     * 列表
     */
    private Button mBtLb;
    private ReclayPersenter reclayPersenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclay_view);
        initView();
        reclayPersenter = new ReclayPersenter(this);
    }


    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //授权开始的回调
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

    private void initView() {
        mTvQq = (TextView) findViewById(R.id.tv_qq);
        mTvQq.setOnClickListener(this);
        mBtLb = (Button) findViewById(R.id.bt_lb);
        mBtLb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tv_qq:
                UMShareAPI.get(ReclayViewActivity.this).getPlatformInfo(ReclayViewActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
            case R.id.bt_lb:
                reclayPersenter.toReclay();
                break;
        }
    }

    @Override
   public void Tolb() {
        Intent intent = new Intent(ReclayViewActivity.this, LibiaoActivity.class);
        startActivity(intent);
    }
}
