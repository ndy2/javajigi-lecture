package net.slipp.myslipp.web.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@ToString
@Getter @Setter
public class MemberForm {

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email
    private String email;

}
