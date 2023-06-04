package mr.kawkumputer.pharmaprochebackend.repository;

import mr.kawkumputer.pharmaprochebackend.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
