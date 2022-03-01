package es.uji.ei1027.SkillSharing.Dao;

import es.uji.ei1027.SkillSharing.ObjetosDeDominio.Solicitud;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class SolicitudRowMapper implements RowMapper<Solicitud> {
    public Solicitud mapRow(ResultSet rs, int rowNum) throws SQLException {
        Solicitud solicitud = new Solicitud();
        solicitud.setCodigo_solicitud(rs.getString("codigo_solicitud"));
        solicitud.setStartdate(rs.getDate("startdate"));
        solicitud.setDni_alumno(rs.getString("dni_alumno"));
        solicitud.setCodigo_habilidad(rs.getString("codigo_habilidad"));
        return solicitud;
    }
}
