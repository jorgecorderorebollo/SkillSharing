package es.uji.ei1027.SkillSharing.Dao;


import es.uji.ei1027.SkillSharing.ObjetosDeDominio.Solicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class SolicitudDao {

    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* INSERT*/
    public void addSolicitud(Solicitud solicitud) {
        jdbcTemplate.update(...)
    }

    /* DELETE */
    public void deleteSolicitud(Solicitud solicitud) {
        jdbcTemplate.update(...);
    }

    /* UPDATE */
    public void updateSolicitud(Solicitud solicitud) {
        jdbcTemplate.update(...);
    }

    /* SELECT Solicitud */
    public Solicitud getSolicitud(String nombreSolicitud) {
        try {
            return jdbcTemplate.queryForObject(...);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Solicitud */
    public List<Solicitud> getSolicitudes() {
        try {
            return jdbcTemplate.query(...)
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Solicitud>();
        }
    }

}
