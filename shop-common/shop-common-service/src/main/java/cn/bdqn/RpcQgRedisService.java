package cn.bdqn;

import cn.bdqn.common.Constants;
import cn.bdqn.common.MD5;
import cn.bdqn.pojo.QgUser;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public interface RpcQgRedisService {

    public boolean set(String key,String value);

    public boolean set(String key,long seconds,String value);

    public boolean exist(String key);

    public Object get(String key);

    public void delete(String key);

    public boolean lock(String key);

    public void unlock(String key);

    public Object getValueNx(String key);

    public boolean validate(String agent, String token);

    public QgUser getCurrentUser(String agent, String tokenString);

    public QgUser getCurrentUser(String tokenString);
}
