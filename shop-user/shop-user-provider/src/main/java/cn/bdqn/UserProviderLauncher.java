package cn.bdqn;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDubboConfiguration
public class UserProviderLauncher {
    public static void main(String[] args) {
        SpringApplication.run(UserProviderLauncher.class, args);
        synchronized (UserProviderLauncher.class) {
            while (true) {
                try {
                    UserProviderLauncher.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }}
