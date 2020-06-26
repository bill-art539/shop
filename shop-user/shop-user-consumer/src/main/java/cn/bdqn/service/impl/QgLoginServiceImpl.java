package cn.bdqn.service.impl;

import cn.bdqn.RpcQgTokenService;
import cn.bdqn.RpcQgUserService;
import cn.bdqn.common.Constants;
import cn.bdqn.common.RedisUtils;
import cn.bdqn.pojo.QgUser;
import cn.bdqn.service.QgLoginService;
import com.alibaba.boot.dubbo.annotation.DubboConsumer;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/1/8.
 */
@Service
public class QgLoginServiceImpl implements QgLoginService {
    private Logger logger = LoggerFactory.getLogger(QgLoginServiceImpl.class);
    @DubboConsumer
    private RpcQgUserService rpcQgUserService;
    @DubboConsumer
    private RpcQgTokenService rpcQgTokenService;
    @Resource
    private RedisUtils redisUtils;

    @Override
    public QgUser login(String phone, String password) throws Exception {
        return rpcQgUserService.login(phone, password);
    }

    @Override
    public String generateToken(QgUser user) {
        return rpcQgTokenService.generateToken(user);
    }

    @Override
    public void save(String token, QgUser user) {
        redisUtils.set(token, Constants.Redis_Expire.SESSION_TIMEOUT, JSON.toJSONString(user));
    }

    @Override
    public void delete(String token) {
        if (redisUtils.exist(token))
            redisUtils.delete(token);
    }

    @Override
    public boolean validate(String token) {
        return redisUtils.validate(token);
    }

    @Override
    public QgUser findByWxUserId(String wxUserId) throws Exception {
        return rpcQgUserService.getQgUserByWxUserId(wxUserId);
    }

    @Override
    public Integer createQgUser(String wxUserId, String id) throws Exception {
        return rpcQgUserService.createQgUser(wxUserId, id);
    }
}
