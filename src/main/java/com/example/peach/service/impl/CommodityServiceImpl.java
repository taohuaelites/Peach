package com.example.peach.service.impl;

import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.CommodityMapper;
import com.example.peach.pojo.Commodity;
import com.example.peach.service.CommodityService;
import com.example.peach.service.OrderPayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Resource
    private CommodityMapper commodityMapper;
    @Resource
    private OrderPayService orderPayService;
    /**
     * 显示所有会员卡信息
     * @return
     */
    @Override
    public ServiceResponse<List> selectCommodity() {
        List<Commodity> list = commodityMapper.selectCommodity();
        if(list!=null) {
            return ServiceResponse.createBySuccess(list);
        }
            return ServiceResponse.createByError("查询错误",list);

    }


}
