package cn.bdqn;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubboConfiguration
@EnableTransactionManagement
@MapperScan("cn.bdqn.mapper")
public class WxpayProviderLauncher
{
    public static void main( String[] args )
    {
        SpringApplication.run(WxpayProviderLauncher.class, args);
        synchronized (WxpayProviderLauncher.class) {
            while (true) {
                try {
                    WxpayProviderLauncher.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
