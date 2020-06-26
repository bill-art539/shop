package cn.bdqn.service;

import cn.bdqn.RpcQgAlipayService;
import cn.bdqn.common.Constants;
import cn.bdqn.common.IdWorker;
import cn.bdqn.common.MqUtils;
import cn.bdqn.common.RedisUtils;
import cn.bdqn.mapper.QgTradeMapper;
import cn.bdqn.pojo.QgTrade;
import cn.bdqn.vo.QgGoodsMessageVo;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Component
@Service(interfaceClass= RpcQgAlipayService.class)
public class RpcQgAlipayServiceImpl implements RpcQgAlipayService {

    private static final Logger logger = LoggerFactory.getLogger(RpcQgAlipayServiceImpl.class);
    @Resource
    private QgTradeMapper qgTradeMapper;
    @Resource
    private MqUtils mqUtils;
    @Resource
    private RedisUtils redisUtils;

    @Override
    @Transactional
    public Integer insertTrade(QgGoodsMessageVo qgGoodsMessageVo) throws Exception {
        QgTrade qgTrade = new QgTrade();
        qgTrade.setId(IdWorker.getId());
        qgTrade.setAmount(qgGoodsMessageVo.getAmount());
        qgTrade.setCreatedTime(Calendar.getInstance().getTime());
        qgTrade.setOrderNo(qgGoodsMessageVo.getOrderNo());
        qgTrade.setPayMethod(1);
        qgTrade.setTradeNo(qgGoodsMessageVo.getTradeNo());
        //发消息去修改商品库存
        qgGoodsMessageVo.setOrderNo(qgGoodsMessageVo.getOrderNo());
        qgGoodsMessageVo.setTradeNo(qgGoodsMessageVo.getTradeNo());
        mqUtils.sendMessage(Constants.QueueName.TO_UPDATED_GOODS_QUQUE, qgGoodsMessageVo);
        mqUtils.sendMessage(Constants.QueueName.TO_UPDATED_ORDER_QUEUE, qgGoodsMessageVo);
        return qgTradeMapper.insertQgTrade(qgTrade);
    }
}
