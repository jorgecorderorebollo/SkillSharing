package es.uji.ei1027.SkillSharing.Dao;


import es.uji.ei1027.SkillSharing.ObjetosDeDominio.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* INSERT*/
    public void addEstudiante(Estudiante estudiante) {
        jdbcTemplate.update("INSERT INTO estudiante VALUES (?, ?, ?, ?, ?)",
               estudiante.getDni_alumno(), estudiante.getNombre_completo(),estudiante.getEmail(),
                estudiante.getPassword(), estudiante.getBaneado());
    }

    /* DELETE */
    public void deleteEstudiante(Estudiante estudiante) {
        jdbcTemplate.update("DELETE FROM estudiante WHERE dni_alumno=?",
                estudiante.getDni_alumno());
    }

    /* UPDATE */
    public void updateEstudiante(Estudiante estudiante) {
        jdbcTemplate.update("UPDATE estudiante SET nombre_completo=?, email=?, password=?, baneado=? WHERE dni_alumno=?",
                estudiante.getNombre_completo(), estudiante.getEmail(), estudiante.getPassword(),
                estudiante.getBaneado(), estudiante.getDni_alumno());
    }

    /* SELECT Estudiante */
    public Estudiante getEstudiante(String nombreEstudiante) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM estudiante WHERE dni_alumno=?",
                    new EstudianteRowMapper(),nombreEstudiante);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* SELECT lista Estudiante */
    public List<Estudiante> getEstudiantes() {
        try {
            return jdbcTemplate.query("SELECT * FROM habilidad", new EstudianteRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Estudiante>();
        }
    }
}
