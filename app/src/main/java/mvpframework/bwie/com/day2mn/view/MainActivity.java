package mvpframework.bwie.com.day2mn.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import mvpframework.bwie.com.day2mn.R;
import mvpframework.bwie.com.day2mn.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements IMainactivity , View.OnClickListener {

    /**
     * 登录
     */
    private Button mBtLogin;
    /**
     * 请输入账号
     */
    private EditText mEditText2;
    /**
     * 请输入密码
     */
    private EditText mEt1;
    /**
     * 注册
     */
    private Button mBtReigster;
    private RelativeLayout mActivityMain;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loginPresenter =
                new LoginPresenter(this);
    }

    private void initView() {
        mBtLogin = (Button) findViewById(R.id.bt_login);
        mBtLogin.setOnClickListener(this);
        mEditText2 = (EditText) findViewById(R.id.editText2);
        mEt1 = (EditText) findViewById(R.id.et1);
        mBtReigster = (Button) findViewById(R.id.bt_reigster);
        mBtReigster.setOnClickListener(this);
        mActivityMain = (RelativeLayout) findViewById(R.id.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_login:
                loginPresenter.login();
                break;
            case R.id.bt_reigster:
                break;
        }
    }

    @Override
    public String getAccount() {
        return mEditText2.getText().toString();
    }

    @Override
    public String getPwd() {
        return mEt1.getText().toString();
    }

    @Override
    public void showData(String str) {
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
    }

    @Override
    public void ToResiter() {
        Intent intent = new Intent(MainActivity.this, ReclayViewActivity.class);
        startActivity(intent);
    }
}
