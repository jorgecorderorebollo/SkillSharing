package es.uji.ei1027.SkillSharing.Dao;

import es.uji.ei1027.SkillSharing.Model.Oferta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class OfertaRowMapper implements RowMapper<Oferta> {
    public Oferta mapRow(ResultSet rs, int rowNum) throws SQLException {
        Oferta oferta = new Oferta();
        oferta.setCodigo_oferta(rs.getString("codigo_oferta"));
        oferta.setFecha_inicio(rs.getDate("fecha_inicio"));
        oferta.setFecha_fin(rs.getDate("fecha_fin"));
        oferta.setDescripcion(rs.getString("descripcion"));
        oferta.setDni_alumno(rs.getString("dni_alumno"));
        oferta.setCodigo_habilidad(rs.getString("codigo_habilidad"));
        return oferta;
    }
}
