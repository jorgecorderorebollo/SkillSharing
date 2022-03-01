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
        jdbcTemplate.update("INSERT INTO promotor VALUES (?, ?, ?, ?)",
                promotor.getDni_promotor(), promotor.getNombre_completo(), promotor.getEmail(), promotor.getPassword());
    }

    /* DELETE */
    public void deletePromotor(Promotor promotor) {
        jdbcTemplate.update("DELETE FROM promotor WHERE dni_promotor=?",
                promotor.getDni_promotor());
    }

    /* UPDATE */
    public void updatePromotor(Promotor promotor) {
        jdbcTemplate.update("UPDATE promotor SET nombre_completo=?, email=?, password=? WHERE dni_promotor=?",
                promotor.getNombre_completo(), promotor.getEmail(), promotor.getPassword(),promotor.getDni_promotor());
    }

    /* SELECT Promotor */
    public Promotor getPromotor(String dni) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM promotor WHERE=dni_promotor",
                    new PromotorRowMapper(), dni);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Promotor */
    public List<Promotor> getPromotores() {
        try {
            return jdbcTemplate.query("SELECT * FROM promotor",
                    new PromotorRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Promotor>();
        }
    }
}
