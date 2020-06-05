package cn.tanyu.springcloud.myhandler;

import cn.tanyu.springcloud.cloudapicommons.entity.CommonResult;
import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义的限流处理信息...");
    }
}
