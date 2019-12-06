package the.best.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import the.best.form.SingUpForm;

import java.util.regex.Pattern;

@Component(value = "singUpValidator")
public class SingUpFormValidator implements Validator {

    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);;


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