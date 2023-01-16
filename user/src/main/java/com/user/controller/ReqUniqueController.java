package com.user.controller;

import com.user.service.ReqUniqueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import res.BaseResponse;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class ReqUniqueController {
    @Resource
    private ReqUniqueService reqUniqueService;

    @GetMapping("/getUniqueReqId")
    public BaseResponse<String> getUniqueReqId() {
       return BaseResponse.success(reqUniqueService.genUniqueId());
    }
}
