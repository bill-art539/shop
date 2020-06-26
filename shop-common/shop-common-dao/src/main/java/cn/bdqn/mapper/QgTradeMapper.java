package cn.bdqn.mapper;
import cn.bdqn.pojo.QgTrade;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QgTradeMapper {

    /**
     *
     * @param qgTrade
     * @return
     * @throws Exception
     */
	public Integer insertQgTrade(QgTrade qgTrade)throws Exception;
}
