package cn.bdqn;

import cn.bdqn.pojo.QgOrder;
import cn.bdqn.vo.QgGoodsMessageVo;

/**
 * Created by Administrator on 2018/1/22.
 */
public interface RpcQgWxpayService {
    public Integer insertTrade(QgGoodsMessageVo qgGoodsMessageVo) throws Exception;
}

