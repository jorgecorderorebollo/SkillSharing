package es.uji.ei1027.SkillSharing.Dao;


import es.uji.ei1027.SkillSharing.Model.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HabilidadDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* INSERT*/
    public void addHabilidad(Habilidad habilidad) {
        jdbcTemplate.update("INSERT INTO habilidad VALUES (?, ?, ?, ?)",
                habilidad.getCodigo_habilidad(), habilidad.getNombre(), habilidad.getDescripcion(), habilidad.getNivel());
    }

    /* DELETE */
    public void deleteHabilidad(String codigo) {
        jdbcTemplate.update("DELETE FROM habilidad WHERE codigo_habilidad=?", codigo);
    }

    /* UPDATE */
    public void updateHabilidad(Habilidad habilidad) {
        jdbcTemplate.update("UPDATE habilidad SET nombre=?, descripcion=?, nivel=? WHERE codigo_habilidad=?",
                habilidad.getNombre(), habilidad.getDescripcion(), habilidad.getNivel(), habilidad.getCodigo_habilidad());
    }

    /* SELECT Habilidad */
    public Habilidad getHabilidad(String codigo_habilidad) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM habilidad WHERE codigo_habilidad=?",
                    new HabilidadRowMapper(), codigo_habilidad);
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
