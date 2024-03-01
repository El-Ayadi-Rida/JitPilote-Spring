package academy.jobintech.jitechpilot.service;

import academy.jobintech.jitechpilot.dto.TicketDTO;

import java.util.List;

/**
 * @author Yassine CHALH
 */
public interface TicketService {

    TicketDTO createTicket(TicketDTO ticketDTO);
    TicketDTO updateTicket(Long id, TicketDTO ticketDTO);
    void deleteTicket(Long id);
    TicketDTO getTicketById(Long id);
    List<TicketDTO> getAllTickets();
}
