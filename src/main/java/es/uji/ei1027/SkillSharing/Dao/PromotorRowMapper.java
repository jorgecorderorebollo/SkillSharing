package es.uji.ei1027.SkillSharing.Dao;

import es.uji.ei1027.SkillSharing.Model.Promotor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class PromotorRowMapper implements RowMapper<Promotor> {
    public Promotor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Promotor promotor = new Promotor();
        promotor.setDni_promotor(rs.getString("dni_promotor"));
        promotor.setNombre_completo(rs.getString("nombre_completo"));
        promotor.setEmail(rs.getString("email"));
        promotor.setPassword(rs.getString("password"));
        return promotor;
    }
}
