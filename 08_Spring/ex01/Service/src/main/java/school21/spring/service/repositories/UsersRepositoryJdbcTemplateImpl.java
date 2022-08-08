package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import school21.spring.service.models.User;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    public JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl (DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id = ?;", (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2)) , new Object[]{id})
                .stream().findAny().orElse(null);
    }

    @Override
    public List findAll() {
        return jdbcTemplate.query("select * from users", (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2)));
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into users (id, email) values (?, ?)", user.getId(), user.getEmail());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE users SET email = ? WHERE id=?", user.getEmail(), user.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    @Override
    public Optional findByEmail(String email) {
        User user = jdbcTemplate.query("SELECT * FROM users WHERE email = ?", (rs, rowNum) -> new User(rs.getLong(1), rs.getString(2)),  new Object[]{email})
                .stream().findAny().orElse(null);
        return Optional.of(user);
    }

}
