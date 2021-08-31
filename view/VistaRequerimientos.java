package view;

import java.sql.SQLException;
import java.util.ArrayList;
import controller.ControladorRequerimientos;
import model.vo.*;

public class VistaRequerimientos {
    // atributo

    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();
    // metodos

        // consulta numero 1 del reto 3
        public static void requerimiento1() {

            System.out.println("Requerimiento 1, Consulta 1:");
            System.out.println("Nombre Salario");
    
            
            try {
                //comunicarse con el controlador, recibir los resultados
                ArrayList<LiderSalarioCartagoVO> respuesta = ControladorRequerimientos.consutarLideresCartago();
    
                // recorrer e impirmir resultados 
    
                for ( LiderSalarioCartagoVO registro : respuesta){
                     System.out.println(registro.getNombre()+" " + registro.getSalario() );
    
                }
    
            } catch (SQLException e) {
                System.err.println("Oops, paso algo! " + e.getMessage());
            }
        }

    // consulta numero 4 del reto 3
    public static void requerimiento2() {

        System.out.println("Requerimiento 2, Consulta 4:");
        System.out.println("Nombre_Material Precio_Unidad Total");

        
        try {
            //comunicarse con el controlador, recibir los resultados
            ArrayList<MaterialProyectoVO> respuesta = ControladorRequerimientos.consultarMaterialesProyecto();

            // recorrer e impirmir resultados 

            for (MaterialProyectoVO registro : respuesta){
                 System.out.println(registro.getNombre_Material()+" " + registro.getPrecio_Unidad()+ " " + registro.getTotal());

            }

        } catch (SQLException e) {
            System.err.println("Oops, paso algo! " + e.getMessage());
        }
    }
    // consulta numero 5 del reto 3
    public static void requerimiento3() {

        System.out.println("Requerimiento 3, Consulta 5:");
        System.out.println("Nombre Promedio");

        
        try {
            //comunicarse con el controlador, recibir los resultados
            ArrayList<LideresCostoPromVO> respuesta = ControladorRequerimientos.consultarLideresPromedio();

            // recorrer e impirmir resultados 

            for ( LideresCostoPromVO registro : respuesta){
                 System.out.println(registro.getNombre()+" " + registro.getPromedio() );

            }

        } catch (SQLException e) {
            System.err.println("Oops, paso algo! " + e.getMessage());
        }
    }

}
