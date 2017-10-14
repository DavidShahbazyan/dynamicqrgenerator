package arm.davsoft.dynamicqrgenerator.helpers.provider;

import arm.davsoft.dynamicqrgenerator.model.User;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author David Shahbazyan
 * @since May 08, 2017
 */
public class RowMapperProvider {
    /* Additional DAOs should be injected here... */

    public static final RowMapper<User> USER_ROW_MAPPER = (resultSet, i) -> {
        User user = new User();
        return user;
    };
}
