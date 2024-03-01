package academy.jobintech.jitechpilot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private long userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String role;
    private LocalDateTime createdAt;


}
