package com.example.peach.controller;

import com.example.peach.common.ServiceResponse;
import com.example.peach.pojo.Appointment;
import com.example.peach.service.AppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/insertappointment", method = RequestMethod.POST)
    public ServiceResponse<String> insertAppointment(@ModelAttribute Appointment appointment) {

        if (appointment != null) {
            ServiceResponse<String> response = appointmentService.selectAppointment(appointment);
            if (!response.isSuccess()) {
                return response;
            } else {
                response = appointmentService.insertAppointment(appointment);
                return response;
            }
        } else {
            return ServiceResponse.createByError("传入空值！");
        }
    }


    //查询自己约见的对象
    @RequestMapping(value = "/selectbymyid", method = RequestMethod.GET)
    public ServiceResponse<Object> selectByMyId(@RequestParam Integer myid) {

        if (myid != null) {
            ServiceResponse<Object> response = appointmentService.selectByMyId(myid);
            return response;
        } else {
            return ServiceResponse.createByError("传入空值!");
        }
    }


    //查询约见自己的对象
    @RequestMapping(value = "/selectbyyouid", method = RequestMethod.GET)
    public ServiceResponse<Object> selectByYouId(@RequestParam Integer youid) {

        if (youid != null) {
            ServiceResponse<Object> response = appointmentService.selectByYouId(youid);
            return response;
        } else {
            return ServiceResponse.createByError("传入空值！");
        }
    }

    //拒绝约见
    @RequestMapping(value = "/updatestatus1", method = RequestMethod.POST)
    public ServiceResponse<String> updateStatus1(@ModelAttribute Appointment appointment) {

        if (appointment != null) {
            ServiceResponse<String> response = appointmentService.updateStatus1(appointment);
            if (!response.isSuccess()) {
                return response;
            } else {
                ServiceResponse.createBySuccess("拒绝约见！");
                return response;
            }
        } else {
            return ServiceResponse.createByError("传入空值！");
        }
    }

    //同意约见
    @RequestMapping(value = "/updatestatus2", method = RequestMethod.POST)
    public ServiceResponse<String> updateStatus2(@ModelAttribute Appointment appointment) {

        if (appointment != null) {
            ServiceResponse<String> response = appointmentService.updateStatus2(appointment);
            if (!response.isSuccess()) {
                return response;
            } else {
                ServiceResponse.createBySuccess("接受约见！");
                return response;
            }
        } else {
            return ServiceResponse.createByError("传入空值！");
        }
    }
}
