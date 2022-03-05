package es.uji.ei1027.SkillSharing.Dao;


import es.uji.ei1027.SkillSharing.ObjetosDeDominio.Solicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SolicitudDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* INSERT*/
    public void addSolicitud(Solicitud solicitud) {
        jdbcTemplate.update("INSERT INTO solicitud VALUES (?, ?, ?, ?, ?, ?)",
                solicitud.getCodigo_solicitud(), solicitud.getFecha_inicio(), solicitud.getFecha_fin(),
                solicitud.getDescripcion(), solicitud.getDni_alumno(), solicitud.getCodigo_habilidad());
    }

    /* DELETE */
    public void deleteSolicitud(Solicitud solicitud) {
        jdbcTemplate.update("DELETE FROM solicitud WHERE codigo_solicitud=?",
                solicitud.getCodigo_solicitud());
    }

    /* UPDATE */
    public void updateSolicitud(Solicitud solicitud) {
        jdbcTemplate.update("UPDATE solicitud SET fecha_inicio=?, fecha_fin=?, descripcion=?," +
                "dni_alumno=?, codigo_habilidad=? WHERE codigo_solicitud=?",
                solicitud.getFecha_inicio(), solicitud.getFecha_fin(), solicitud.getDescripcion(),
                solicitud.getDni_alumno(), solicitud.getCodigo_habilidad(), solicitud.getCodigo_solicitud());
    }

    /* SELECT Solicitud */
    public Solicitud getSolicitud(String codigo) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM solicitud WHERE codigo_solicitud=?",
                    new SolicitudRowMapper(), codigo);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Solicitud */
    public List<Solicitud> getSolicitudes() {
        try {
            return jdbcTemplate.query("SELECT * FROM solicitud",
                    new SolicitudRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Solicitud>();
        }
    }

}
