package cn.dy.service;
import cn.dy.pojo.DyConsultants;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface DyConsultantsService {

    public DyConsultants getDyConsultantsById(String id)throws Exception;

    public List<DyConsultants>	getDyConsultantsListByMap(Map<String,Object> param)throws Exception;

    public Integer getDyConsultantsCountByMap(Map<String,Object> param)throws Exception;

    public Integer qdtxAddDyConsultants(DyConsultants dyConsultants)throws Exception;

    public Integer qdtxModifyDyConsultants(DyConsultants dyConsultants)throws Exception;

    public Integer qdtxDeleteDyConsultantsById(String id)throws Exception;

    public Integer qdtxBatchDeleteDyConsultants(String ids)throws Exception;

}
