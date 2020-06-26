package cn.bdqn;
import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Administrator on 2018/1/2.
 */
@SpringBootApplication
@EnableDubboConfiguration
@EnableTransactionManagement
@MapperScan("cn.bdqn.mapper")
public class AlipayConsumerLauncher {
    public static void main(String args[]){
        SpringApplication.run(AlipayConsumerLauncher.class, args);
    }
}
