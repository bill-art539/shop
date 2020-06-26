package cn.bdqn;
import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class OrderConsumerLauncher {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerLauncher.class, args);
        synchronized (OrderConsumerLauncher.class) {
            while (true) {
                try {
                    OrderConsumerLauncher.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
