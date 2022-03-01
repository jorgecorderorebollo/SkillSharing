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
        jdbcTemplate.update("INSERT INTO incidencia VALUES (?, ?, ?, ?, ?, ?)",
               incidencia.getDni_alumno(), incidencia.getDni_promotor(), incidencia.getNombre_alumno(),
                incidencia.getNombre_promotor(), incidencia.getDescripcion());
    }

    /* DELETE */
    public void deleteIncidencia(Incidencia incidencia) {
        jdbcTemplate.update("DELETE FROM incidencia WHERE dni_alumno=? AND dni_promotor=?",
                incidencia.getDni_alumno(), incidencia.getDni_promotor());
    }

    /* UPDATE */
    public void updateIncidencia(Incidencia incidencia) {
        jdbcTemplate.update("UPDATE incidencia SET nombre_alumno=?, nombre_promotor=?, descripcion=? " +
                "WHERE dni_alumno=? AND dni_promotor=?",
                incidencia.getNombre_alumno(), incidencia.getNombre_promotor(), incidencia.getDescripcion(),
                incidencia.getDni_alumno(), incidencia.getDni_promotor());
    }

    /* SELECT Incidencia */
    public Incidencia getIncidencia(String codigoEstudiante, String codigoPromotor) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM incidencia WHERE dni_alumno=? AND dni_promotor=?",
                    new IncidenciaRowMapper(), codigoEstudiante, codigoPromotor);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Incidencia */
    public List<Incidencia> getIncidencias() {
        try {
            return jdbcTemplate.query("SELECT * FROM incidencia",
                    new IncidenciaRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Incidencia>();
        }
    }
}
