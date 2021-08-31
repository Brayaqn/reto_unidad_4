package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import model.dao.*;
import model.vo.*;




public class ControladorRequerimientos {

    private static final MaterialProyectoDAO materialProyectoDAO = new MaterialProyectoDAO(); 
    private static final LideresSalarioCartagoDAO  lideresSalarioCartagoDAO = new LideresSalarioCartagoDAO(); 
    private static final LideresCostosPromDAO  lideresCostosPromDAO = new LideresCostosPromDAO(); 


    public ControladorRequerimientos() {
    

        
    }

    public static ArrayList<MaterialProyectoVO> consultarMaterialesProyecto()throws SQLException {
        return materialProyectoDAO.MaterialesProyecto();
    }

    public static ArrayList<LiderSalarioCartagoVO> consutarLideresCartago()throws SQLException {
        return lideresSalarioCartagoDAO.consultarLideresCartago();
    }

    public static ArrayList<LideresCostoPromVO> consultarLideresPromedio()throws SQLException {
        return lideresCostosPromDAO.consultarLideresPromedio();
    }

}
