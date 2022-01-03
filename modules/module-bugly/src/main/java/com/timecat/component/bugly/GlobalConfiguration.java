package com.timecat.component.bugly;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.jess.arms.base.delegate.AppLifecycles;
import com.jess.arms.di.module.GlobalConfigModule;
import com.jess.arms.integration.ConfigModule;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

import java.util.List;

import timber.log.Timber;

public class GlobalConfiguration implements ConfigModule {

    @Override
    public void applyOptions(@NonNull Context context, GlobalConfigModule.Builder builder) {
    }

    @Override
    public void injectAppLifecycle(@NonNull Context context, List<AppLifecycles> lifecycles) {
        lifecycles.add(0, new AppLifecycles() {

            @Override
            public void attachBaseContext(@NonNull Context base) {
            }

            @Override
            public void onCreate(@NonNull Application application) {
                //初始化所有的第三方
                //腾讯 bugly
                Timber.d("module-bugly --> bugly init start >>>");
                /* Beta高级设置*/
                /*
                 * true表示app启动自动初始化升级模块；
                 * false不好自动初始化
                 * 开发者如果担心sdk初始化影响app启动速度，可以设置为false
                 * 在后面某个时刻手动调用
                 */
                Beta.autoInit = true;
                /*
                 * true表示初始化时自动检查升级
                 * false表示不会自动检查升级，需要手动调用Beta.checkUpgrade()方法
                 */
                Beta.autoCheckUpgrade = true;
                /*
                 * 设置升级周期为60s（默认检查周期为0s），60s内SDK不重复向后天请求策略
                 */
                Beta.initDelay = 1000;
                Beta.canNotifyUserRestart = true;
                Beta.autoDownloadOnWifi = true;
                Beta.enableNotification = true;
                Bugly.init(application, BuildConfig.BUGLY_ID, false);
                Timber.d("module-bugly --> bugly init end <<<");
            }

            @Override
            public void onTerminate(@NonNull Application application) {

            }
        });
    }

    @Override
    public void injectActivityLifecycle(@NonNull Context context,
                                        List<Application.ActivityLifecycleCallbacks> lifecycles) {
    }

    @Override
    public void injectFragmentLifecycle(@NonNull Context context,
                                        List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {
    }

}
