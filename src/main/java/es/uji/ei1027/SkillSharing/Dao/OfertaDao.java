package es.uji.ei1027.SkillSharing.Dao;


import es.uji.ei1027.SkillSharing.ObjetosDeDominio.Oferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class OfertaDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* INSERT*/
    public void addOferta(Oferta oferta) {
        jdbcTemplate.update(...)
    }

    /* DELETE */
    public void deleteOferta(Oferta oferta) {
        jdbcTemplate.update(...);
    }

    /* UPDATE */
    public void updateOferta(Oferta oferta) {
        jdbcTemplate.update(...);
    }

    /* SELECT Oferta */
    public Oferta getOferta(String nombreOferta) {
        try {
            return jdbcTemplate.queryForObject(...);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Oferta */
    public List<Oferta> getOfertas() {
        try {
            return jdbcTemplate.query(...)
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Oferta>();
        }
    }
}
