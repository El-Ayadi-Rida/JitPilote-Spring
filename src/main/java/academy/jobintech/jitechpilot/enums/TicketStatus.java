package academy.jobintech.jitechpilot.enums;

/**
 * @author Yassine CHALH
 */
public enum TicketStatus {
    TODO("To Do"),
    IN_PROGRESS("In Progress"),
    DONE("Done");

    private final String status;

    TicketStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }

}
