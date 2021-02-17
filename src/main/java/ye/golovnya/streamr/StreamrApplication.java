package ye.golovnya.streamr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StreamrApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamrApplication.class, args);
    }

}
