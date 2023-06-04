package mr.kawkumputer.pharmaprochebackend.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
public class KafkaConsumers {

    @KafkaListener(topics = "message", groupId = "pharma-proche-events")
    public String listener(String in){
        log.info("**** {} ****", in);
        return in;
    }
}
