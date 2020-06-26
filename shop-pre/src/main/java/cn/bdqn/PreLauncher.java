package cn.bdqn;
import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class PreLauncher {
    public static void main(String[] args) {
        SpringApplication.run(PreLauncher.class, args);
    }
}