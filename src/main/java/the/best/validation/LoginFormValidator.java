package the.best.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import the.best.form.SingUpForm;

import java.util.regex.Pattern;

import static the.best.validation.SingUpFormValidator.EMAIL_PATTERN;

@Component(value = "loginValidator")
public class LoginFormValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return SingUpForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SingUpForm form = (SingUpForm) o;

        if(!isValidEmail(form.getEmail())){
            errors.rejectValue("email", "registration.password.not.match");
        }
    }

    private boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}