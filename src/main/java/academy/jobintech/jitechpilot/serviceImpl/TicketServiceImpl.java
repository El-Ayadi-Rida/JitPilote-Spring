package academy.jobintech.jitechpilot.serviceImpl;

import academy.jobintech.jitechpilot.dto.TicketDTO;
import academy.jobintech.jitechpilot.entity.Ticket;
import academy.jobintech.jitechpilot.mapper.TicketDTOMapper;
import academy.jobintech.jitechpilot.repository.TicketRepository;
import academy.jobintech.jitechpilot.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yassine CHALH
 */
@Service
public class TicketServiceImpl implements TicketService {// TODO: Logs and Exceptions

    private final TicketRepository ticketRepository;
    private final TicketDTOMapper ticketDTOMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, TicketDTOMapper ticketDTOMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketDTOMapper = ticketDTOMapper;
    }

    @Override
    public TicketDTO createTicket(TicketDTO ticketDTO) {
        Ticket ticket = ticketDTOMapper.toEntity(ticketDTO);
        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketDTOMapper.toDto(savedTicket);
    }

    @Override
    public TicketDTO updateTicket(Long id, TicketDTO ticketDto) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found on :: " + id));

        ticket.setTitle(ticketDto.getTitle());
        ticket.setDescription(ticketDto.getDescription());
        ticket.setPriority(ticketDto.getPriority());
        ticket.setStatus(ticketDto.getStatus());

        Ticket updatedTicket = ticketRepository.save(ticket);

        return ticketDTOMapper.toDto(updatedTicket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public TicketDTO getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found on :: " + id));
        return ticketDTOMapper.toDto(ticket);
    }

    @Override
    public List<TicketDTO> getAllTickets() {
        return ticketDTOMapper.toDtos(ticketRepository.findAll());
    }
}
