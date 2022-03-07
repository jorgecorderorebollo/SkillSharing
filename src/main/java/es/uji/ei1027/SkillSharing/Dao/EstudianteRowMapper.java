package es.uji.ei1027.SkillSharing.Dao;


import es.uji.ei1027.SkillSharing.Model.Estudiante;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class EstudianteRowMapper implements RowMapper<Estudiante> {
    public Estudiante mapRow(ResultSet rs, int rowNum) throws SQLException {
        Estudiante estudiante = new Estudiante();
        estudiante.setDni_alumno(rs.getString("dni_alumno"));
        estudiante.setNombre_completo(rs.getString("nombre_completo"));
        estudiante.setEmail(rs.getString("email"));
        estudiante.setPassword(rs.getString("password"));
        estudiante.setBaneado(rs.getBoolean("baneado"));
        return estudiante;
    }
}