package lesson10.regform.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NoteDTO {

    private String username;
    private String firstName;
    private String lastName;

    private String login;

}
