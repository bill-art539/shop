package cn.bdqn;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDubboConfiguration
public class UserConsumerLauncher {
	public static void main(String[] args) {
		SpringApplication.run(UserConsumerLauncher.class, args);
	}
}
