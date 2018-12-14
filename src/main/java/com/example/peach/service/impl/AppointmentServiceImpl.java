package com.example.peach.service.impl;

import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.AppointmentMapper;
import com.example.peach.pojo.Appointment;
import com.example.peach.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/11/21.
 */
@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Resource
    private AppointmentMapper appointmentMapper;

    //创建约见数据
    @Override
    public ServiceResponse<String> insertAppointment(Appointment appointment) {

        int rs=appointmentMapper.insertAppointment(appointment);
        if (rs>0){
            return ServiceResponse.createBySuccess("约见成功！");
        }else{
            return ServiceResponse.createByError("约见失败！");
        }
    }

    //查询自己的约见计划
    @Override
    public ServiceResponse<Object> selectByMyId(Integer myid) {

        List<Appointment> list=appointmentMapper.selectByMyId(myid);
        if(list!=null && list.size()>0){
            return ServiceResponse.createBySuccess(list);
        }else{
            return ServiceResponse.createByError("没有约见计划！");
        }
    }

    //查询约见自己的计划
    @Override
    public ServiceResponse<Object> selectByYouId(Integer youid) {

        List<Appointment> list=appointmentMapper.selectByYouId(youid);
        if(list!=null && list.size()>0){
            return ServiceResponse.createBySuccess(list);
        }else{
            return ServiceResponse.createByError("没有约见计划！");
        }
    }

    //查询是否已有约见计划
    @Override
    public ServiceResponse<String> selectAppointment(Appointment appointment) {

        List<Appointment> list=appointmentMapper.selectAppointment(appointment);

        if(list!=null && list.size()>0){
            return ServiceResponse.createByError("已约见！");
        }else{
            return ServiceResponse.createBySuccess();
        }
    }

    //拒绝约见
    @Override
    public ServiceResponse<String> updateStatus1(Appointment appointment) {

        int rs=appointmentMapper.updateStatus1(appointment);
        if (rs>0){
            return ServiceResponse.createBySuccess();
        }else{
            return ServiceResponse.createByError("操作失败！");
        }
    }

    //同意约见
    @Override
    public ServiceResponse<String> updateStatus2(Appointment appointment) {

        int rs=appointmentMapper.updateStatus2(appointment);
        if (rs>0){
            return ServiceResponse.createBySuccess();
        }else{
            return ServiceResponse.createByError("操作失败！");
        }
    }


}
