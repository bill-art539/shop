package cn.bdqn.service;

import cn.bdqn.common.Dto;
import cn.bdqn.pojo.QgOrder;
import cn.bdqn.vo.QgOrderVo;

import javax.jms.Message;
import java.util.List;

public interface OrderService {
    /****
     * 查询订单Vo
     * @param token
     * @return
     */
    public Dto<List<QgOrderVo>> queryOrderList(String token) throws Exception;

    public Dto flushIsGet(String token,String goodsId) throws Exception;

    /**
     * 获取被定时刷新的订单的列表
     * @return
     * @throws Exception
     */
    public boolean cancelGoodsAndOrder() throws Exception;
}
