package the.best.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import the.best.web.form.SingUpForm;

import java.util.regex.Pattern;

@Component(value = "singUpValidator")
public class SingUpFormValidator implements Validator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    ;
    private static final Pattern ONLY_LETTER_PATTERN = Pattern.compile("^[a-zA-Z]+$");

    @Override
    public boolean supports(Class<?> aClass) {
        return SingUpForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SingUpForm form = (SingUpForm) o;

        if (form.getFirst_name().isEmpty()) {
            errors.rejectValue("first_name", "registration.first.name.empty");
        } else if (form.getLast_name().isEmpty()) {
            errors.rejectValue("last_name", "registration.last.name.empty");
        } else if (form.getEmail().isEmpty()) {
            errors.rejectValue("email", "registration.email.empty");
        } else if (!isValidEmail(form.getEmail())) {
            errors.rejectValue("email", "registration.email.not.match");
        } else if (form.getPassword().isEmpty()) {
            errors.rejectValue("password", "registration.password.empty");
        }


    }

    private boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }
}