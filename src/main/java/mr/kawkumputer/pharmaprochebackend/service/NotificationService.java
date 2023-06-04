package mr.kawkumputer.pharmaprochebackend.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import mr.kawkumputer.pharmaprochebackend.config.KafkaProducers;
import mr.kawkumputer.pharmaprochebackend.model.Notification;
import mr.kawkumputer.pharmaprochebackend.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final KafkaProducers kafkaProducers;
    private final ObjectMapper objectMapper;

    public List<Notification> findAllNotifications() {
        return this.notificationRepository.findAll();
    }

    public Notification save(Notification notification) {
        notification.setCreatedAt(LocalDateTime.now());
        Notification notificationDB = notificationRepository.save(notification);
        String payload = null;
        try {
            payload = objectMapper.writeValueAsString(notificationDB);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        kafkaProducers.sendMessage(payload);
        return notificationDB;
    }
}
