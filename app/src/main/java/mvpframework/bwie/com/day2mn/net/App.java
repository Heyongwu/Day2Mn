package mvpframework.bwie.com.day2mn.net;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by 何永武 on 2017/11/11.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .build();
        ImageLoader.getInstance().init(configuration);
        Config.DEBUG = true;



    }
    {
        PlatformConfig.setQQZone("1106449273","8Lz5m6xTGVJfS1tG");
    }
}
