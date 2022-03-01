package es.uji.ei1027.SkillSharing.Dao;

import es.uji.ei1027.SkillSharing.ObjetosDeDominio.Promotor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class PromotorDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* INSERT*/
    public void addPromotor(Promotor promotor) {
        jdbcTemplate.update(...)
    }

    /* DELETE */
    public void deletePromotor(Promotor promotor) {
        jdbcTemplate.update(...);
    }

    /* UPDATE */
    public void updatePromotor(Promotor promotor) {
        jdbcTemplate.update(...);
    }

    /* SELECT Promotor */
    public Promotor getPromotor(String nombrePromotor) {
        try {
            return jdbcTemplate.queryForObject(...);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Promotor */
    public List<Promotor> getPromotores() {
        try {
            return jdbcTemplate.query(...)
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Promotor>();
        }
    }


}
