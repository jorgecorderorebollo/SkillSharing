package es.uji.ei1027.SkillSharing.Dao;


import es.uji.ei1027.SkillSharing.ObjetosDeDominio.Incidencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class IncidenciaDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* INSERT*/
    public void addIncidencia(Incidencia incidencia) {
        jdbcTemplate.update(...)
    }

    /* DELETE */
    public void deleteIncidencia(Incidencia incidencia) {
        jdbcTemplate.update(...);
    }

    /* UPDATE */
    public void updateIncidencia(Incidencia incidencia) {
        jdbcTemplate.update(...);
    }

    /* SELECT Incidencia */
    public Incidencia getIncidencia(String nombreIncidencia) {
        try {
            return jdbcTemplate.queryForObject(...);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Incidencia */
    public List<Incidencia> getIncidencias() {
        try {
            return jdbcTemplate.query(...)
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Incidencia>();
        }
    }
}
