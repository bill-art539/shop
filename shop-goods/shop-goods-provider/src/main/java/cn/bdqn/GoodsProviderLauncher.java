package cn.bdqn;
import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class GoodsProviderLauncher {
    public static void main(String[] args) {
        SpringApplication.run(GoodsProviderLauncher.class, args);
        synchronized (GoodsProviderLauncher.class) {
            while (true) {
                try {
                    GoodsProviderLauncher.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}