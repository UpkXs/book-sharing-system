package kz.iitu.itse1903.sugurali.formatter;

import kz.iitu.itse1903.sugurali.entity.profile.Role;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class RoleFormatter implements Formatter<Role> {

    @Override
    public Role parse(String text, Locale locale) throws ParseException {
        if(text != null) {
            String[] resource = text.split(",");
            if(resource.length == 1) {
                Role role = new Role();
                role.setName(resource[0]);
                return role;
            }
        }
        return null;
    }

    @Override
    public String print(Role role, Locale locale) {
        if(role == null) {
            return "";
        }
        return role.toString();
    }
}
