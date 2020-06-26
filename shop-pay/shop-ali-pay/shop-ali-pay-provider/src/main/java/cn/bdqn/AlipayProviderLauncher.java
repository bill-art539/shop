package cn.bdqn;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2018/1/3.
 */
@SpringBootApplication
@EnableDubboConfiguration
@MapperScan("cn.bdqn.mapper")
public class AlipayProviderLauncher {
    public static void main(String[] args) {
        SpringApplication.run(AlipayProviderLauncher.class, args);
        synchronized (AlipayProviderLauncher.class) {
            while (true) {
                try {
                    AlipayProviderLauncher.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
