package mr.kawkumputer.pharmaprochebackend.controller;

import lombok.AllArgsConstructor;
import mr.kawkumputer.pharmaprochebackend.model.Notification;
import mr.kawkumputer.pharmaprochebackend.model.User;
import mr.kawkumputer.pharmaprochebackend.service.NotificationService;
import mr.kawkumputer.pharmaprochebackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "api/v1/pharma-proche/notifications")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping
    public ResponseEntity<List<Notification>> findAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(notificationService.findAllNotifications());
    }

    @PostMapping
    public ResponseEntity<Notification> save(@RequestBody Notification notification) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificationService.save(notification));
    }
}
