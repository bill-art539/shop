package cn.bdqn;

import cn.bdqn.pojo.QgUser;

/**
 * Token管理接口
 * @author hduser
 *
 */
public interface RpcQgTokenService {

	/**
	 * 生成token
	 * @param user 用户信息
	 * @return Token格式<br/>
	 * 		PC：“USERCODE-USERID-CREATIONDATE”
	 */
	public String generateToken(QgUser user);
}
