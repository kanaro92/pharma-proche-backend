package mr.kawkumputer.pharmaprochebackend.config;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducers {

    final private KafkaTemplate<String, String> kafkaTemplate;
    final private KafkaConfigProps kafkaConfigProps;

    public KafkaProducers(KafkaTemplate<String, String> kafkaTemplate, KafkaConfigProps kafkaConfigProps) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaConfigProps = kafkaConfigProps;
    }

    public void sendMessage(String message){
        kafkaTemplate.send(kafkaConfigProps.getTopic(), message);
    }
}
