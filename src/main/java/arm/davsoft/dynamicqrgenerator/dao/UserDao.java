package arm.davsoft.dynamicqrgenerator.dao;

import arm.davsoft.dynamicqrgenerator.helpers.provider.RowMapperProvider;
import arm.davsoft.dynamicqrgenerator.model.User;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

/**
 * @author David Shahbazyan
 * @since May 08, 2017
 */
public class UserDao extends BaseDao<User> {
    //language=SQLite
    private final String USER_VALIDATE_QUERY = "SELECT UserID FROM Users WHERE login = :login AND pass = :password";
    //language=SQLite
    private final String USER_LOAD_QUERY = "SELECT * FROM Users";
    //language=SQLite
    private final String USER_LOAD_BY_ID_QUERY = "SELECT * FROM Users WHERE UserID = :id";

    public UserDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void create(User entity) {

    }

    @Override
    public List<User> loadAll() {
        try {
            return jdbcTemplate.query(USER_LOAD_QUERY, getRowMapper());
        } catch (Exception ex) {
            Logger.getLogger(getClass()).error("Error occurred during data load.", ex);
        }
        return null;
    }

    @Override
    public User load(int id) {
        try {
            List<User> result = jdbcTemplate.query(USER_LOAD_BY_ID_QUERY, Collections.singletonMap("id", id), getRowMapper());
            if (result == null || result.isEmpty()) {
                throw new IllegalArgumentException(String.format("No user with %s id was found!", id));
            } else if (result.size() > 1) {
                throw new IllegalArgumentException(String.format("There was more than one user with %s id in DB, but should not!", id));
            }
            return result.get(0);
        } catch (Exception ex) {
            Logger.getLogger(getClass()).error("Error occurred during data load.", ex);
        }
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    protected RowMapper<User> getRowMapper() {
        return RowMapperProvider.USER_ROW_MAPPER;
    }

    public boolean validate(String user, String pass) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("login", user)
                    .addValue("password", pass);
            List<User> result = jdbcTemplate.query(USER_VALIDATE_QUERY, params, getRowMapper());
            return result.size() == 1;
        } catch (Exception ex) {
            Logger.getLogger(getClass()).error("Error occurred during user validation.", ex);
        }
        return false;
    }
}
