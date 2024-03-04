package academy.jobintech.jitechpilot.dto;


import academy.jobintech.jitechpilot.entity.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SectionDTO {

    private Long sectionId;
    private String sectionTitle;
    private String description;
    private List<TicketDTO> tickets = new ArrayList<>();
}
