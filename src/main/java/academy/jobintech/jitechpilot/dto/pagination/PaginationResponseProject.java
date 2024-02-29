package academy.jobintech.jitechpilot.dto.pagination;

import academy.jobintech.jitechpilot.dto.response.ProjectResponse;

import java.util.List;

public class PaginationResponseProject {
    private List<ProjectResponse> content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
