package es.uji.ei1027.SkillSharing.Dao;


import es.uji.ei1027.SkillSharing.ObjetosDeDominio.Colaboracion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ColaboracionRowMapper implements RowMapper<Colaboracion> {
    public Colaboracion mapRow(ResultSet rs, int rowNum) throws SQLException {
        Colaboracion colaboracion = new Colaboracion();
        colaboracion.setCodigo_colaboracion(rs.getString("codigo_colaboracion"));
        colaboracion.setFecha_inicio(rs.getDate("fecha_inicio"));
        colaboracion.setFecha_fin(rs.getDate("fecha_fin"));
        colaboracion.setHoras(rs.getFloat("horas"));
        colaboracion.setEvaluacion(rs.getString("evaluacion"));
        colaboracion.setCodigo_oferta(rs.getString("codigo_oferta"));
        colaboracion.setCodigo_solicitud(rs.getString("codigo_solicitud"));
        return colaboracion;
    }
}