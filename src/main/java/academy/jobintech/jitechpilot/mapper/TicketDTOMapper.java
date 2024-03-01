package academy.jobintech.jitechpilot.mapper;

import academy.jobintech.jitechpilot.dto.TicketDTO;
import academy.jobintech.jitechpilot.entity.Ticket;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Yassine CHALH
 */
@Component
@Scope(value = "singleton")
public class TicketDTOMapper implements EntityDTOMapper<Ticket, TicketDTO> {

    @Override
    public TicketDTO toDto(Ticket ticket) {
        TicketDTO dto = new TicketDTO();

        dto.setTicketId(ticket.getTicketId());
        dto.setTitle(ticket.getTitle());
        dto.setDescription(ticket.getDescription());
        dto.setPriority(ticket.getPriority());
        dto.setStatus(ticket.getStatus());
       //dto.setProjectId(ticket.getProject().getProjectId());
        // TODO: setUser Assigned to ...

        return dto;
    }

    @Override
    public Ticket toEntity(TicketDTO dto) {
        Ticket ticket = new Ticket();

        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setPriority(dto.getPriority());
        ticket.setStatus(dto.getStatus());
        //ticket.setProject(dto.getProjectId());
        // TODO: setting project and user enities

        return ticket;
    }
}