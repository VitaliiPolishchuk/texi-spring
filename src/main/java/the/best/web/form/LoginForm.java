package the.best.web.form;

import javax.validation.constraints.NotNull;

public class LoginForm {
    @NotNull
    private String email;
    @NotNull
    private String password;

    public LoginForm() {
    }
}
