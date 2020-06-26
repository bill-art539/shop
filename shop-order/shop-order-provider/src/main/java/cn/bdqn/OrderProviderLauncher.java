package cn.bdqn;
import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**QgMqMessage
 * Created by Administrator on 2018/1/3.
 */
@SpringBootApplication
@EnableDubboConfiguration
public class OrderProviderLauncher {
    public static void main(String[] args) {
        SpringApplication.run(OrderProviderLauncher.class, args);
    }
}
