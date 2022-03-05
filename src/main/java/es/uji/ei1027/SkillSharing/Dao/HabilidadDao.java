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
        jdbcTemplate.update("INSERT INTO solicitud VALUES (?, ?, ?, ?)",
                habilidad.getCodigo_habilidad(), habilidad.getNombre(), habilidad.getDescripcion(), habilidad.getNivel());
    }

    /* DELETE */
    public void deleteHabilidad(Habilidad habilidad) {
        jdbcTemplate.update("DELETE FROM habilidad WHERE codigo_habilidad=?", habilidad.getCodigo_habilidad());
    }

    /* UPDATE */
    public void updateHabilidad(Habilidad habilidad) {
        jdbcTemplate.update("UPDATE habilidad SET nombre=?, descripcion=?, nivel=? WHERE codigo_habilidad=?",
                habilidad.getNombre(), habilidad.getDescripcion(), habilidad.getNivel(), habilidad.getCodigo_habilidad());
    }

    /* SELECT Habilidad */
    public Habilidad getHabilidad(String nombreHabilidad) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM habilidad WHERE codigo_habilidad=?",
                    new HabilidadRowMapper(), nombreHabilidad);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Habilidad */
    public List<Habilidad> getHabilidades() {
        try {
            return jdbcTemplate.query("SELECT * FROM habilidad", new HabilidadRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Habilidad>();
        }
    }
}
