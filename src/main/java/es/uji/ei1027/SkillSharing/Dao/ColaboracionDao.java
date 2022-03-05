package es.uji.ei1027.SkillSharing.Dao;

import es.uji.ei1027.SkillSharing.ObjetosDeDominio.Colaboracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class ColaboracionDao { /*
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* INSERT*/ /*
    public void addColaboracion(Colaboracion colaboracion) {
        jdbcTemplate.update(...)
    }

    /* DELETE */ /*
    public void deleteColaboracion(Colaboracion colaboracion) {
        jdbcTemplate.update(...);
    }

    /* UPDATE */ /*
    public void updateColaboracion(Colaboracion colaboracion) {
        jdbcTemplate.update(...);
    }

    /* SELECT Colaboracion *//*
    public Colaboracion getColaboracion(String nombreColaboracion) {
        try {
            return jdbcTemplate.queryForObject(...);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Colaboracion *//*
    public List<Colaboracion> getColaboraciones() {
        try {
            return jdbcTemplate.query(...)
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Colaboracion>();
        }
    }*/
}
