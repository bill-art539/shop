package cn.bdqn.controller;
import cn.bdqn.common.RedisUtils;
import cn.bdqn.mapper.QgUserMapper;
import cn.bdqn.pojo.QgUser;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.jms.JMSException;
import javax.jms.Message;

@Controller("/test")
public class TestController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private QgUserMapper qgUserMapper;

    @RequestMapping("send")
    public void testSend(){
        String message="我是测试";
        jmsMessagingTemplate.convertSendAndReceive("test.queue",message,String.class);
    }

    @RequestMapping("/tokenCreate")
    public void tokenCreate() throws Exception{
        for (int i=2;i<10002;i++){
            QgUser qgUser=new QgUser();
            qgUser.setId(i+"");
            qgUser.setPhone("13366966561");
//          qgUserMapper.insertQgUser(qgUser);
            String token="token:"+i;
            redisUtils.set(token, JSONObject.toJSONString(qgUser));
        }
    }
}
