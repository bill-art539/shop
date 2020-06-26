package cn.bdqn.service;

import cn.bdqn.common.Dto;
import cn.bdqn.pojo.QgGoods;
import cn.bdqn.vo.QgGoodsVo;

public interface QgGoodsService {

    public Dto<QgGoodsVo> queryQgGoodsById(String goodsId);

    public Dto sendQgGoodsMessage(String goodsId,String token) throws Exception;

    public void sendMessage();
}
