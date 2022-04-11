package es.uji.ei1027.SkillSharing.Dao;

import es.uji.ei1027.SkillSharing.Model.Usuario;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UsuarioDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public Usuario comprobarPassword(String username, String password) {
        try {
            BasicPasswordEncryptor passwordEncriptor = new BasicPasswordEncryptor();

            Usuario usuario = jdbcTemplate.queryForObject("SELECT * FROM usuario WHERE username=?",
                    new UsuarioRowMapper(), username);

            if (usuario != null && passwordEncriptor.checkPassword(password, usuario.getUsername())) return usuario;

            return null;

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }


    public Usuario getTipo(String username) {
        try {

            Usuario usuario = jdbcTemplate.queryForObject("SELECT * FROM usuario WHERE username=?",
                    new UsuarioRowMapper(), username);

            if (usuario != null) return usuario;

            return null;

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}