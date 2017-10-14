package arm.davsoft.dynamicqrgenerator.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author David Shahbazyan
 * @since May 08, 2017
 */
public abstract class BaseDao<T> {
    protected final DataSource dataSource;
    protected final NamedParameterJdbcTemplate jdbcTemplate;

    public BaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public abstract void create(T entity);

    public abstract List<T> loadAll();

    public abstract T load(int id);

    public abstract void update(T entity);

    public abstract void delete(T entity);

    protected abstract RowMapper<T> getRowMapper();
}
