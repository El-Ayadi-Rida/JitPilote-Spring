package academy.jobintech.jitechpilot.repository;

import academy.jobintech.jitechpilot.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yassine CHALH
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
