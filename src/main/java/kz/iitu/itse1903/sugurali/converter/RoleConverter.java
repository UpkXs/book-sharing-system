package kz.iitu.itse1903.sugurali.converter;

import kz.iitu.itse1903.sugurali.entity.profile.Role;
import org.springframework.core.convert.converter.Converter;

public class RoleConverter implements Converter<String, Role> {

    @Override
    public Role convert(String source) {
        String[] resource =source.split(",");
        return new Role(Integer.parseInt(resource[0]), resource[1]);
    }
}
