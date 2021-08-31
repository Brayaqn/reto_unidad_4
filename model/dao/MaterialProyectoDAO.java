package model.dao;
// arrayList para guardar 
import java.util.ArrayList;

//  librerias sql
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

// connexion base de datos
import util.JDBCutilities;
import model.vo.MaterialProyectoVO;



public class MaterialProyectoDAO {
    
    public ArrayList<MaterialProyectoVO> MaterialesProyecto() throws SQLException {

        // crear arreglo donde guardamos los registros que son el resultado que vamos a ejecutar
        ArrayList<MaterialProyectoVO> respuestaConsulta4 = new ArrayList<MaterialProyectoVO>();

        // abrir conexion con la base de datos
        Connection conexion = JDBCutilities.getConnection();

        // ejecutar la consulta sql

        String consulta = 
        " SELECT mc.Nombre_Material, mc.Precio_Unidad, SUM(c.Cantidad) Total"+
        " FROM Proyecto p LEFT JOIN Compra c ON p.ID_Proyecto = c.ID_Proyecto " +
        " LEFT JOIN  MaterialConstruccion mc ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion " +
        " WHERE p.ID_Proyecto in (199, 7, 378, 120,216)" +
        " GROUP BY mc.Nombre_Material, mc.Precio_Unidad " +
        " ORDER BY mc.Nombre_Material ";


        // llamado Statament
        Statement st = conexion.createStatement();


        // ejecutar consulta Statement
        ResultSet rs = st.executeQuery(consulta);

        // recorrer resultSet
        while (rs.next()) {
            String Nombre_Material = rs.getString("Nombre_Material");
            Integer Precio_Unidad = rs.getInt("Precio_Unidad");
            Integer Total = rs.getInt("Total");
            respuestaConsulta4.add( new MaterialProyectoVO(Nombre_Material, Precio_Unidad, Total));
        }


        // cerrar conexion
        rs.close();
        st.close();
        conexion.close();

        // 
        return respuestaConsulta4;
    }

}

