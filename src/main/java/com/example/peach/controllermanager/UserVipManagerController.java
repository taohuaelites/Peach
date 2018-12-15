package com.example.peach.controllermanager;

import com.example.peach.common.ServiceResponse;
import com.example.peach.service.UserVipService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class UserVipManagerController {
    @Resource
    private UserVipService userVipService;

    /**
     * 查询所有用户会员非会员的信息
     * @return
     */
    @RequestMapping(value = "/all/vipinfo",method = RequestMethod.GET)
    public ServiceResponse<List> FindAllUserVip(){
       ServiceResponse<List> listServiceResponse = userVipService.selectAllUvipUser();
        return listServiceResponse;
    }

}
