package academy.jobintech.jitechpilot.dto.pagination;
import academy.jobintech.jitechpilot.dto.response.TeamResponse;

import java.util.List;

public class PaginationResponseTeam {
    private List<TeamResponse> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
