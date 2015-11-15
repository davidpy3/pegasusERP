package org.pegasus.patrimonio.jsf;

public class PatrimonioUtils {

    public String f_get_detallle_tecnico(String as_codbien,String as_correla) {

        String ls_clase, ls_grupo;
        String ls_detalle_tecnico="";
        String ls_marca, ls_modelo, ls_serie, ls_placa, ls_motor, ls_color, ls_raza, ls_especie, ls_dimension;
        String ls_product_name, ls_titulo, ls_edicion;
/*
        ls_grupo = Mid(as_codbien, 1, 2)
        ls_clase = Mid(as_codbien, 3, 2)


        SELECT RTRIM(marca
        ), RTRIM(modelo)
        , RTRIM(dimension)
        , RTRIM(serie)
        , RTRIM(placa)
        , RTRIM(nummotor)
        , RTRIM(color)
        , RTRIM(raza)
        , RTRIM(especie)
        , RTRIM(product_name)
        , RTRIM(titulo)
        , RTRIM(edicion)
        INTO:
        ls_marca, :ls_modelo, :ls_dimension, :ls_serie, :ls_placa, :ls_motor, :ls_color, :ls_raza, :ls_especie, :ls_product_name, :ls_titulo
        , :ls_edicion FROM mbienes0 WHERE codbien = :as_codbien AND correla = :as_correla USING sqlca;

        IF IsNull(ls_marca
        ) THEN ls_marca = '-'
        IF IsNull(ls_modelo
        ) THEN ls_modelo = '-'
        IF IsNull(ls_dimension
        ) THEN ls_dimension = '-'
        IF IsNull(ls_serie
        ) THEN ls_serie = '-'
        IF IsNull(ls_placa
        ) THEN ls_placa = '-'
        IF IsNull(ls_motor
        ) THEN ls_motor = '-'
        IF IsNull(ls_color
        ) THEN ls_color = '-'
        IF IsNull(ls_raza
        ) THEN ls_raza = '-'
        IF IsNull(ls_especie
        ) THEN ls_especie = '-'
        IF IsNull(ls_product_name
        ) THEN ls_especie = '-'
        IF IsNull(ls_titulo
        ) THEN ls_especie = '-'
        IF IsNull(ls_edicion
        ) THEN ls_especie = '-'


        CHOOSE CASE ls_clase CASE '08', '22', '50', '01' //campos marca, modelo, serie
		
		ls_detalle_tecnico = "Marca: " + ls_marca + ", Modelo: " + ls_modelo + ", Serie: " + ls_serie
		
	CASE '36', '82' //campos marca, placa, nummotor		
		
		ls_detalle_tecnico = "Marca: " + ls_marca + ", Placa: " + ls_placa + ", Num Motor: " + ls_motor
		
	CASE '64'  //campos dimension, modelo, color
		
		ls_detalle_tecnico = "Dimensión: " + ls_dimension + ", Color: " + ls_color + ", Modelo: " + ls_modelo
		
	CASE 	'78' //campos  color, raza, especie
		
		ls_detalle_tecnico = "Color: " + ls_color + ", Raza: " + ls_raza + ", Especie: " + ls_especie
	CASE '00'
		
		CHOOSE CASE ls_grupo CASE '39'
				ls_detalle_tecnico = "Titulo: " + ls_titulo + ", Edicion: " + ls_edicion
			CASE '74'
				ls_detalle_tecnico = "Producto: " + ls_product_name + ", Versión: " + ls_edicion
			
        END CHOOSE
			
        END CHOOSE
*/
        return ls_detalle_tecnico;
    }
}
