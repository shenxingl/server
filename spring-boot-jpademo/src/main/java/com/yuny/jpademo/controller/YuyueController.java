package com.yuny.jpademo.controller;

import com.yuny.jpademo.pojo.yuyue;
import com.yuny.jpademo.repository.YuyueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class YuyueController {
    @Autowired
    private YuyueRepository yuyueRepository;

    @PostMapping(value = "/find")
    public List<yuyue> personListByName(@RequestBody String name) {
        return yuyueRepository.findByNameIsLike(name);
    }

    @PostMapping(value = "/all")
    public List<yuyue> getAll(@RequestBody String date) {
        return yuyueRepository.findByDatetimeLike(date);
    }

    @PostMapping("/del")
    public void personDelete(@RequestBody yuyue y) {
        yuyueRepository.delete(y);
    }

    @PostMapping(value = "/yuYue")
    public int yuYue(@RequestBody yuyue yy) {
        int s=0;
        System.out.println(yy.getDatetime());
        yuyue dr = yuyueRepository.findByDatetimeAndRoom(yy.getDatetime(),yy.getRoom());
        yuyue dn = yuyueRepository.findByDatetimeAndName(yy.getDatetime(),yy.getName());
        if(dr!=null)s=1;
        else if(dn!=null)s=2;
       if(s == 0)yuyueRepository.save(yy);
       return s;
    }

    @PostMapping("/findHyszy")
    public String findHyszy (@RequestBody yuyue n) {
        String message="";int m,my,mm;
        String[][] arr=new String[31][8];
        List<yuyue> list = yuyueRepository.findByDatetimeLike(n.getDatetime());//查询对应月份所有记录
        for(int i=0;i<list.size();i++)                                         //筛选对应会议室记录
        {
            if(list.get(i).getRoom()!= n.getRoom()) {
                list.remove(i);i--;}
        }
        m= Integer.valueOf(n.getDatetime());                                   //读取年月
        my=m/100;mm=m-my*100;                                                  //分离年月，my为年份，mm为月份
        for(int i=0;i<list.size();i++)                                          //遍历查询记录，将对应日和时的预约人储存进数组
        {
            int d,t,t1,s=0;
            s = Integer.valueOf(list.get(i).getDatetime());
            d=(s-m*10000)/100;
            t=s-m*10000-d*100;
            if(t<12)t1=t-8;
            else t1=t-10;
            arr[d-1][t1]=list.get(i).getName();
        }
                                                                                //打印标题、表头
        message = "<h4>"+my+"年"+mm+"月"+n.getRoom()+"会议室占用情况表</h4><table border=\"1\" cellspacing=\"0\"><tr style=\"height: 30px\"><td width=\"80px\">日期</td>";
        for(int i=1;i<=31;i++)
        {
            message=message+"<td width=\"100px\">"+i+"</td>";                   //循环打印（表头）
        }
        message = message + "</tr>";
        for(int i = 1;i<9;i++)                                                  //外循环，循环时间，8-12，14-18
        {
            if(i<5) message = message + "<tr style=\"height: 65px\"><td>"+(i+7)+":00-"+(i+8)+":00</td>";    //打印第一列
            else message = message + "<tr style=\"height: 65px\"><td>"+(i+9)+":00-"+(i+10)+":00</td>";
            for(int j = 1;j<32;j++)                                              //内循环，循环日，1-31
            {
                if(arr[j-1][i-1]==null) message = message + "<td>"+"</td>";      //对应日、时为空时打印空td
                                                                                 //对应日、时有数据时打印td（内容、字体、背景颜色）
                else message = message + "<td bgcolor=\"#7CFC00\"><p style=\"font-family:verdana;font-size:40%;color:black\">"+arr[j-1][i-1]+"</p></td>";
            }
            message = message + "</tr>";                                          //行结束
        }
        message=message+ "</table>";                                               //表格结束
        return message;                                                             //返回全部打印内容
    }
}
