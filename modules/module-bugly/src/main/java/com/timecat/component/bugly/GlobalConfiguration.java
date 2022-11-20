package com.timecat.component.bugly;

import android.app.Application;
import android.content.Context;

import com.jess.arms.base.delegate.AppLifecycles;
import com.jess.arms.di.module.GlobalConfigModule;
import com.jess.arms.integration.ConfigModule;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import timber.log.Timber;

public class GlobalConfiguration implements ConfigModule {

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlobalConfigModule.Builder builder) {

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
                CrashReport.initCrashReport(application, BuildConfig.BUGLY_ID, false);
                UMConfigure.preInit(application, "5a669093a40fa335210000fe", "github");
                Timber.d("module-bugly --> bugly init end <<<");
            }

            @Override
            public void onTerminate(@NonNull Application application) {

            }
        });
    }

    @Override
    public void injectActivityLifecycle(@NonNull Context context,
            @NonNull List<Application.ActivityLifecycleCallbacks> lifecycles) {
    }

    @Override
    public void injectFragmentLifecycle(@NonNull Context context,
            @NonNull List<FragmentManager.FragmentLifecycleCallbacks> lifecycles) {
    }

}
