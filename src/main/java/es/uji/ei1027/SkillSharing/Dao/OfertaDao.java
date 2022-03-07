package es.uji.ei1027.SkillSharing.Dao;


import es.uji.ei1027.SkillSharing.Model.Oferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OfertaDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* INSERT*/
    public void addOferta(Oferta oferta) {
        jdbcTemplate.update("INSERT INTO oferta VALUES (?, ?, ?, ?, ?, ?)",
                oferta.getCodigo_oferta(), oferta.getFecha_inicio(), oferta.getFecha_fin(), oferta.getDescripcion(),
                oferta.getDni_alumno(), oferta.getCodigo_habilidad());
    }

    /* DELETE */
    public void deleteOferta(Oferta oferta) {
        jdbcTemplate.update("DELETE FROM oferta WHERE codigo_oferta=?", oferta.getCodigo_oferta());
    }

    /* UPDATE */
    public void updateOferta(Oferta oferta) {
        jdbcTemplate.update("UPDATE oferta SET fecha_inicio=?, fecha_fin=?, descripcion=?," +
                "dni_alumno=?, codigo_habilidad=? WHERE codigo_oferta=?", oferta.getFecha_inicio(), oferta.getFecha_fin(),
                oferta.getDescripcion(), oferta.getDni_alumno(), oferta.getCodigo_habilidad(), oferta.getCodigo_oferta());
    }

    /* SELECT Oferta */
    public Oferta getOferta(String nombreOferta) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM solicitud WHERE codigo_solicitud=?",
                    new OfertaRowMapper(), nombreOferta);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Oferta */
    public List<Oferta> getOfertas() {
        try {
            return jdbcTemplate.query("SELECT * FROM oferta", new OfertaRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Oferta>();
        }
    }
}
