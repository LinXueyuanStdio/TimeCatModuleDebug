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
    }

    @Override
    public void setDebugEnable(boolean debugEnable) {
        // [可选]设置是否打开debug输出，上线时请关闭，Logcat标签为"MtaSDK"
        UMConfigure.setLogEnabled(debugEnable);
    }
}
