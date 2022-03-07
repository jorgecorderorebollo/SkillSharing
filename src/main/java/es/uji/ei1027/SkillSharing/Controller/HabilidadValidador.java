package es.uji.ei1027.SkillSharing.Controller;
import es.uji.ei1027.SkillSharing.Model.Habilidad;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class HabilidadValidador implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return Habilidad.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Habilidad habilidad = (Habilidad) target;

        /*------------------------------------(Codigo de la habilidad)------------------------------------*/
        if (habilidad.getCodigo_habilidad().trim().equals("")) //Código vacio
            errors.rejectValue("codigo_habilidad", "Habilidad_codigo_habilidad_vacio",
                    "Debe facilitar un código.");

        if (habilidad.getCodigo_habilidad().length() != 6) //Codigo distinto de 6 caracteres
            errors.rejectValue("codigo_habilidad", "Habilidad_codigo_habilidad_longitudIncorrecta",
                    "Este campo debe tener 6 caracteres.");

        if (habilidad.getCodigo_habilidad().trim().length() != 6) //Codigo distinto de 6 caracteres
            errors.rejectValue("codigo_habilidad", "Habilidad_codigo_habilidad_blancosAlInicio",
                    "Elimine los espacios en blanco del inicio de este campo");

        if (!habilidad.getCodigo_habilidad().trim().substring(1, 5).matches("[0-9]"))
            errors.rejectValue("codigo_habilidad", "Habilidad_codigo_habilidad_ViolacionCadenaDeDigitos",
                    "El valor introducido debe tener el siguiente formato (Las 'x' són digitos): Hxxxxx");

        if (!habilidad.getCodigo_habilidad().trim().substring(0).toUpperCase().equals("I")) //DNI sin letra identificativa
            errors.rejectValue("codigo_habilidad", "Habilidad_codigo_habilidad_ViolacionLetraCodigo",
                    "El valor introducido debe tener el siguiente formato (Las 'x' són digitos): Hxxxxx");

        /*------------------------------------(Nombre de la habilidad)------------------------------------*/
        if (habilidad.getCodigo_habilidad().trim().equals("")) //Código vacio
            errors.rejectValue("nombre", "Habilidad_nombre_vacio",
                    "Debe facilitar un nombre.");
        /*------------------------------------(Descripción de la habilidad)------------------------------------*/
        /*------------------------------------(Nivel de la habilidad)------------------------------------*/
        //El nivel esta asegurado al ser una lista de seleción
    }
}
