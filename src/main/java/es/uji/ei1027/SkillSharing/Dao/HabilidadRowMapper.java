package es.uji.ei1027.SkillSharing.Dao;


import es.uji.ei1027.SkillSharing.Model.Habilidad;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class HabilidadRowMapper implements RowMapper<Habilidad> {
    public Habilidad mapRow(ResultSet rs, int rowNum) throws SQLException {
        Habilidad habilidad = new Habilidad();
        habilidad.setCodigo_habilidad(rs.getString("codigo_habilidad"));
        habilidad.setNombre(rs.getString("nombre"));
        habilidad.setDescripcion(rs.getString("descripcion"));
        habilidad.setNivel(rs.getString("nivel"));
        return habilidad;
    }
}
