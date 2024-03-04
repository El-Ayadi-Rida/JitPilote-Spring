package academy.jobintech.jitechpilot.service;

import academy.jobintech.jitechpilot.dto.TicketDTO;
import academy.jobintech.jitechpilot.entity.Ticket;

import java.util.List;

/**
 * @author Yassine CHALH
 */
public interface TicketService {

    TicketDTO createTicket(Long sectionId , TicketDTO ticketDTO);
    TicketDTO updateTicket(Long id, TicketDTO ticketDTO);
    void deleteTicket(Long id);
    TicketDTO getTicketById(Long id);
    List<TicketDTO> getAllTickets();
    Ticket getTicketByIdHelper(Long ticketId);

    List<TicketDTO> getTicketsBySection(Long sectionId);
}
