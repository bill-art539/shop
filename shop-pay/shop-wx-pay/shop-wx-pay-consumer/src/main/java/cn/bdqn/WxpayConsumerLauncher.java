package cn.bdqn;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDubboConfiguration
public class WxpayConsumerLauncher
{
    public static void main( String[] args )
    {
        SpringApplication.run(WxpayConsumerLauncher.class, args);
        synchronized (WxpayConsumerLauncher.class) {
            while (true) {
                try {
                    WxpayConsumerLauncher.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
