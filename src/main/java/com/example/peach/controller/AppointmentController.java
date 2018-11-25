package com.example.peach.controller;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Appointment;
import com.example.peach.service.AppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Administrator on 2018/11/21.
 */
@RestController
@RequestMapping(value = "/appointment")
public class AppointmentController {

    @Resource
    private AppointmentService appointmentService;

    //添加约见
    @RequestMapping(value = "/insertAppointment/{myid}/{youid}")
    public ServiceResponse<String> insertAppointment(@ModelAttribute Appointment appointment) {

        ServiceResponse<String> response=appointmentService.selectAppointment(appointment);

        if (!response.isSuccess()){
            return response;
        }else {
            response=appointmentService.insertAppointment(appointment);
            return response;
        }

    }


    //查询自己约见的对象
    @RequestMapping(value = "/selectByMyId/{myid}")
    public ServiceResponse<Object> selectByMyId(@PathVariable("myid") int myid){

        ServiceResponse<Object> response=appointmentService.selectByMyId(myid);
        return  response;
    }


    //查询约见自己的对象
    @RequestMapping(value = "/selectByYouId/{youid}")
    public ServiceResponse<Object> selectByYouId(@PathVariable("youid") int youid){
        ServiceResponse<Object> response=appointmentService.selectByYouId(youid);
        return  response;
    }

    //拒绝约见
    @RequestMapping(value = "/updateStatus1/{myid}/{youid}")
    public ServiceResponse<String> updateStatus1(@ModelAttribute Appointment appointment){

        ServiceResponse<String> response=appointmentService.updateStatus1(appointment);
        if (!response.isSuccess()){
            return response;
        }else {
            ServiceResponse.createBySuccess("拒绝约见！");
            return response;
        }

    }

    //同意约见
    @RequestMapping(value = "/updateStatus2/{myid}/{youid}")
    public ServiceResponse<String> updateStatus2(@ModelAttribute Appointment appointment){

        ServiceResponse<String> response=appointmentService.updateStatus2(appointment);
        if (!response.isSuccess()){
            return response;
        }else {
            ServiceResponse.createBySuccess("接受约见！");
            return response;
        }

    }
}
