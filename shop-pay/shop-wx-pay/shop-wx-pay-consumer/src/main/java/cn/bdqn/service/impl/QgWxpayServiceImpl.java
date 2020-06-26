package cn.bdqn.service.impl;

import cn.bdqn.RpcQgAlipayService;
import cn.bdqn.RpcQgGoodsService;
import cn.bdqn.RpcQgOrderService;
import cn.bdqn.RpcQgWxpayService;
import cn.bdqn.pojo.QgOrder;
import cn.bdqn.service.QgWxpayService;
import cn.bdqn.vo.QgGoodsMessageVo;
import com.alibaba.boot.dubbo.annotation.DubboConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/22.
 */
@Service
public class QgWxpayServiceImpl implements QgWxpayService{
    private static final Logger logger = LoggerFactory.getLogger(QgWxpayServiceImpl.class);
    @DubboConsumer
    private RpcQgOrderService rpcQgOrderService;
    @DubboConsumer
    private RpcQgGoodsService rpcQgGoodsService;
    @DubboConsumer
    private RpcQgWxpayService rpcQgWxpayService;

    @Override
    public Integer insertTrade(String orderNo, String tradeNo) throws Exception {
        QgOrder qgOrder = rpcQgOrderService.loadQgOrderByOrderNo(orderNo);
        //如果订单已经支付则终止后续业务的执行
        if(1 == qgOrder.getStatus()){
            return 0;
        }
        QgGoodsMessageVo qgGoodsMessageVo = new QgGoodsMessageVo();
        qgGoodsMessageVo.setTradeNo(tradeNo);
        qgGoodsMessageVo.setOrderNo(orderNo);
        qgGoodsMessageVo.setGoodsId(qgOrder.getGoodsId());
        qgGoodsMessageVo.setUserId(qgOrder.getUserId());
        qgGoodsMessageVo.setAmount(qgOrder.getAmount());
        qgGoodsMessageVo.setNum(qgOrder.getNum());
        return rpcQgWxpayService.insertTrade(qgGoodsMessageVo);
    }

    @Override
    public QgOrder loadQgOrderByOrderNo(String orderNo) throws Exception {
        return rpcQgOrderService.loadQgOrderByOrderNo(orderNo);
    }

    @Override
    public boolean processed(String orderNo) throws Exception {
        return rpcQgOrderService.processed(orderNo);
    }
}
