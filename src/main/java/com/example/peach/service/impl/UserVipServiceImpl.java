package com.example.peach.service.impl;

import com.example.peach.common.ServiceResponse;
import com.example.peach.dao.UserVipMapper;
import com.example.peach.pojo.UserVip;
import com.example.peach.pojo.merge.UvipUser;
import com.example.peach.service.UserVipService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserVipServiceImpl implements UserVipService {
    @Resource
    private UserVipMapper userVipMapper;
    private static final Logger L = Logger.getLogger(UserVipServiceImpl.class);
    /**
     * 修改用户会员信息
     * @param userVip
     * @return
     */
    @Override
    public ServiceResponse<String> updateByUserId(UserVip userVip) {
        int getrows = userVipMapper.updateByUserId(userVip);
        if(getrows>0){
            return ServiceResponse.createBySuccess("修改成功");
        }else{
            L.warn(userVip.getId()+"修改失败");
            return ServiceResponse.createByError("修改失败");
        }
    }

    /**
     * 添加用户vip信息
     * @param userVip
     * @return
     */
    @Override
    public ServiceResponse<String> addUserVip(UserVip userVip) {
        int getrows = userVipMapper.insertSelective(userVip);
        if(getrows>0){
            return ServiceResponse.createBySuccess("用户vip信息,添加成功");
        }else{
            L.warn(userVip.getUserId()+"用户vip信息,添加失败");
            return ServiceResponse.createByError("用户vip信息,添加失败");
        }
    }

    /**
     * 约见成功相减
     * @param zUserid  主约id
     * @param bUserid   被约id
     * @return
     */
    @Transactional
    @Override
    public ServiceResponse<String> upateUappointmentByid(Integer zUserid, Integer bUserid) {
        //查询user约见次数
        UserVip zuserVip = userVipMapper.selectByUserId(zUserid);
        int Zappointment = zuserVip.getVipAppointment();
        //判断用户
        if(Zappointment>0){
            Zappointment-=1;
            int getrows = userVipMapper.updateAppiontmentByUserId(Zappointment,zUserid);
            //减主约见次数
            if(getrows>0){
                //查询user约见次数
                UserVip buserVip = userVipMapper.selectByUserId(zUserid);
                int Bappointment = buserVip.getVipAppointment();
                Bappointment-=1;
                int getrows2 = userVipMapper.updateAppiontmentByUserId(Bappointment,bUserid);
                //减被约见次数
                if(getrows2>0){
                    return ServiceResponse.createBySuccess("约见相减成功");
                }else{
                    L.warn("用户"+bUserid+"约见次数相减失败");
                    return ServiceResponse.createByError("约见次数相减失败");
                }
            }else{
                L.warn("用户"+zUserid+"约见次数相减失败");
                return ServiceResponse.createByError("约见次数相减失败");
            }
        }else{
            L.warn("用户"+zUserid+"没有约见次数");
            return ServiceResponse.createByError("您没有约见次数");
        }
    }

    /**
     * 修改钱包金额
     * @param money
     * @param userId
     * @return
     */
    @Override
    public ServiceResponse<String> updateUwlletByUserId(Double money, Integer userId) {
        money+=userVipMapper.selectByUserId(userId).getUserWallet();
        int getrows = userVipMapper.updateUwalletByUserId(money,userId);
        if (getrows>0){
            return ServiceResponse.createBySuccess("钱包修改成功");
        }else{
            return ServiceResponse.createByError("钱包修改失败");
        }
    }

    /**
     * 会员是否过期
     * @param userId
     * @return
     */
    @Override
    public ServiceResponse<UvipUser> selectCreatAndEndByUserId(Integer userId) {
//        SimpleDateFormat myFmt = new SimpleDateFormat("yyMMddHHmmss");
       UvipUser uvipUser = userVipMapper.selectUvipUser(userId);
       if(uvipUser!=null) {
           if(uvipUser.getVipGrade()>0) {
               Date d1 = uvipUser.getVipEndtime();
               Date d2 = new Date();
               long hour = (d1.getTime() - d2.getTime()) / (1000 * 60 * 60);
               long day = (d1.getTime() - d2.getTime()) / (1000 * 60 * 60 * 24);
               if (hour > 0) {
                   return ServiceResponse.createBySuccess("会员过期还有" + day + "天",uvipUser);
               } else {
                   L.warn(userId+"此用户会员过期或没有购买会员");
                   return ServiceResponse.createByError("此用户会员过期或没有购买会员",uvipUser);
               }
           }else {
               L.warn("用户"+userId+"不是会员");
               return ServiceResponse.createByError("您不是会员",uvipUser);
           }
       }else{
           L.warn("没有"+userId+"用户的会员记录");
           return ServiceResponse.createByError("没有此用户的会员记录");
       }
    }

    /**
     *  查询所有vip(非vip和vip)信息
     * @return
     */
    @Override
    public ServiceResponse<List> selectAllUvipUser() {
        List<UvipUser> list = userVipMapper.selectAllUvipUser();
        if(list!=null){
            return  ServiceResponse.createBySuccess(list);
        }else{
            return ServiceResponse.createByError("查询失败");
        }
    }
}
