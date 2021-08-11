package com.timecat.component.bugly;

import com.tencent.bugly.beta.Beta;
import com.timecat.identity.service.BuglyService;
import com.xiaojinzi.component.anno.ServiceAnno;

/**
 * @author dlink
 * @email linxy59@mail2.sysu.edu.cn
 * @date 2019/7/3
 * @description null
 * @usage null
 */
@ServiceAnno(BuglyService.class)
public class BuglyServiceImpl implements BuglyService {

    @Override
    public void checkUpdate() {
        Beta.checkUpgrade();
    }
}
