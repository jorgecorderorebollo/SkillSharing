package es.uji.ei1027.SkillSharing.Dao;


import es.uji.ei1027.SkillSharing.ObjetosDeDominio.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class HabilidadDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* INSERT*/
    public void addHabilidad(Habilidad habilidad) {
        jdbcTemplate.update(...)
    }

    /* DELETE */
    public void deleteHabilidad(Habilidad habilidad) {
        jdbcTemplate.update(...);
    }

    /* UPDATE */
    public void updateHabilidad(Habilidad habilidad) {
        jdbcTemplate.update(...);
    }

    /* SELECT Habilidad */
    public Habilidad getHabilidad(String nombreHabilidad) {
        try {
            return jdbcTemplate.queryForObject(...);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Habilidad */
    public List<Habilidad> getHabilidades() {
        try {
            return jdbcTemplate.query(...)
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Habilidad>();
        }
    }
}
