package cn.bdqn;

import cn.bdqn.pojo.QgGoodsMessage;

/***
 * 抢购消息业务接口
 */
public interface RpcQgGoodsMessageService {

    public int addQgGoodsMessage(QgGoodsMessage qgGoodsMessage)throws Exception;
}
