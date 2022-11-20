package com.timecat.component.bugly;

import android.app.Application;
import android.content.Context;

import com.timecat.identity.service.MtaService;
import com.umeng.commonsdk.UMConfigure;
import com.xiaojinzi.component.anno.ServiceAnno;

/**
 * @author 林学渊
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2020-02-27
 * @description null
 * @usage null
 */
@ServiceAnno(MtaService.class)
public class MtaServiceImpl implements MtaService {
    @Override
    public void registerActivityLifecycleCallbacks(Application context) {
    }

    @Override
    public void startStatService(Context context) {
        //友盟正式初始化
        UMConfigure.init(context, "5a669093a40fa335210000fe", "github", UMConfigure.DEVICE_TYPE_PHONE, "96eee0872f33f29193d1d48ecea726f0");
    }

    @Override
    public void setDebugEnable(boolean debugEnable) {
        // [可选]设置是否打开debug输出，上线时请关闭，Logcat标签为"MtaSDK"
        UMConfigure.setLogEnabled(debugEnable);
    }
}
