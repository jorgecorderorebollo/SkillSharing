package es.uji.ei1027.SkillSharing.Dao;

import es.uji.ei1027.SkillSharing.ObjetosDeDominio.Incidencia;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class IncidenciaRowMapper implements RowMapper<Incidencia> {
    public Incidencia mapRow(ResultSet rs, int rowNum) throws SQLException {
        Incidencia incidencia = new Incidencia();
        incidencia.setDni_alumno(rs.getString("dni_alumno"));
        incidencia.setDni_promotor(rs.getString("dni_promotor"));
        incidencia.setNombre_alumno(rs.getString("nombre_alumno"));
        incidencia.setNombre_promotor(rs.getString("nombre_promotor"));
        incidencia.setDescripcion(rs.getString("descripcion"));
        return incidencia;
    }
}
