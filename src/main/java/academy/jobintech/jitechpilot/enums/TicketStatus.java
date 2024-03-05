package academy.jobintech.jitechpilot.enums;


public enum TicketStatus {
    OPEN("Open"),
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
