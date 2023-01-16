package com.system.hystrix;

import res.BaseResponse;

public interface GlobalHystrix {
    default BaseResponse fallback(){
        return BaseResponse.fail("调用失败");
    }
}
