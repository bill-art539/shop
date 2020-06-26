package cn.bdqn.service;

import cn.bdqn.RpcQgGoodsMessageService;
import cn.bdqn.RpcQgGoodsService;
import cn.bdqn.common.IdWorker;
import cn.bdqn.mapper.QgGoodsMessageMapper;
import cn.bdqn.pojo.QgGoodsMessage;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Service(interfaceClass = RpcQgGoodsMessageService.class)
public class RpcQgGoodsMessageServiceImpl implements RpcQgGoodsMessageService{

    @Resource
    private QgGoodsMessageMapper qgGoodsMessageMapper;

    @Override
    public int addQgGoodsMessage(QgGoodsMessage qgGoodsMessage) throws Exception{
        qgGoodsMessage.setId(IdWorker.getId());
        return qgGoodsMessageMapper.insertQgGoodsMessage(qgGoodsMessage);
    }
}
