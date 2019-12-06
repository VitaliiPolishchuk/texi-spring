package the.best.form;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

@Slf4j
@Getter
@Setter
public class SingUpForm {
    @NotNull
    private String first_name;
    @NotNull
    private String last_name;
    @NotNull
    private String email;
    @NotNull
    private String password;

    public SingUpForm() {
    }


}
