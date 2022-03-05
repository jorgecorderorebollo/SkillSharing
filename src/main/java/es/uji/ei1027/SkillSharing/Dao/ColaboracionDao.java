package es.uji.ei1027.SkillSharing.Dao;

import es.uji.ei1027.SkillSharing.ObjetosDeDominio.Colaboracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ColaboracionDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* INSERT*/
    public void addColaboracion(Colaboracion colaboracion) {
        jdbcTemplate.update("INSERT INTO colaboracion VALUES (?, ?, ?, ?, ?, ?, ?)",
                colaboracion.getCodigo_colaboracion(), colaboracion.getFecha_inicio(),
                colaboracion.getFecha_fin(), colaboracion.getHoras(), colaboracion.getEvaluacion(),
                colaboracion.getCodigo_oferta(), colaboracion.getCodigo_solicitud());
    }

    /* DELETE */
    public void deleteColaboracion(Colaboracion colaboracion) {
        jdbcTemplate.update("DELETE FROM colaboracion WHERE codigo_colaboracion=?", colaboracion.getCodigo_colaboracion());
    }

    /* UPDATE */
    public void updateColaboracion(Colaboracion colaboracion) {
        jdbcTemplate.update("UPDATE colaboracion SET fecha_inicio=?, fecha_fin=?, horas=?, evaluacion=?," +
                "codigo_oferta=?, codigo_solicitud=? WHERE codigo_colaboracion=?",
                colaboracion.getFecha_inicio(), colaboracion.getFecha_fin(), colaboracion.getHoras(), colaboracion.getEvaluacion(),
                colaboracion.getCodigo_oferta(), colaboracion.getCodigo_solicitud(), colaboracion.getCodigo_colaboracion());
    }

    /* SELECT Colaboracion */
    public Colaboracion getColaboracion(String nombreColaboracion) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM colaboracion WHERE codigo_colaboracion=?",
                    new ColaboracionRowMapper(), nombreColaboracion);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Colaboracion */
    public List<Colaboracion> getColaboraciones() {
        try {
            return jdbcTemplate.query("SELECT * FROM colaboracion",
                    new ColaboracionRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Colaboracion>();
        }
    }
}
