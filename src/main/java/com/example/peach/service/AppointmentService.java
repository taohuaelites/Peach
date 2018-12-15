package com.example.peach.service;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Appointment;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/11/21.
 */
public interface AppointmentService {

    //创建约见数据
    ServiceResponse<String> insertAppointment(Appointment appointment);

    //查询自己的约见计划
    ServiceResponse<Object> selectByMyId(Integer myid);

    //查询约见自己的计划
    ServiceResponse<Object> selectByYouId(Integer youid);

    //查询是否已有约见计划
    ServiceResponse<String> selectAppointment(Appointment appointment);

    //拒绝约见
    ServiceResponse<String> updateStatus1(Appointment appointment);

    //同意约见
    ServiceResponse<String> updateStatus2(Appointment appointment);

}
