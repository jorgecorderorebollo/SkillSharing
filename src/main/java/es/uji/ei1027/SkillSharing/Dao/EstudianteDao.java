package es.uji.ei1027.SkillSharing.Dao;


import es.uji.ei1027.SkillSharing.ObjetosDeDominio.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDao { /*
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* INSERT*/ /*
    public void addEstudiante(Estudiante estudiante) {
        jdbcTemplate.update(...)
    }

    /* DELETE */ /*
    public void deleteEstudiante(Estudiante estudiante) {
        jdbcTemplate.update(...);
    }

    /* UPDATE */ /*
    public void updateEstudiante(Estudiante estudiante) {
        jdbcTemplate.update(...);
    }

    /* SELECT Estudiante */ /*
    public Estudiante getEstudiante(String nombreEstudiante) {
        try {
            return jdbcTemplate.queryForObject(...);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Estudiante */ /*
    public List<Estudiante> getEstudiantes() {
        try {
            return jdbcTemplate.query(...)
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Estudiante>();
        }
    }*/
}
