package cn.bdqn;

import cn.bdqn.vo.QgGoodsMessageVo;

/***
 * 发送消息的接口
 */
public interface RpcMessageService {
    /***
     * 记录抢购消息
     */
    public void recordQgMessageLog(QgGoodsMessageVo QgGoodsMessage) throws Exception;
}
