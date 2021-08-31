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
import model.vo.LideresCostoPromVO;

public class LideresCostosPromDAO {

    public ArrayList<LideresCostoPromVO> consultarLideresPromedio() throws SQLException {

        // crear arreglo donde guardamos los registros que son el resultado que vamos a ejecutar
        ArrayList<LideresCostoPromVO> respuestaConsulta3 = new ArrayList<LideresCostoPromVO>();

        // abrir conexion con la base de datos
        Connection conexion = JDBCutilities.getConnection();

        // ejecutar la consulta sql

        String consulta = 
        " SELECT l.Nombre ||\" \"|| l.Primer_Apellido||\" \"|| l.Segundo_Apellido Nombre, SUM(mc.Precio_Unidad * c.Cantidad) /COUNT(DISTINCT p.ID_Proyecto) Promedio" +
        " FROM Lider l LEFT JOIN Proyecto p ON l.ID_Lider = p.ID_Lider" +
        "    LEFT JOIN Compra c ON p.ID_Proyecto = c.ID_Proyecto"+
        "    LEFT JOIN  MaterialConstruccion mc ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion"+
        " WHERE p.Clasificacion = 'Condominio' "+
        " GROUP BY l.ID_Lider" +
        " HAVING  COUNT(DISTINCT p.ID_Proyecto) >= 2" +
        " ORDER BY Promedio DESC"+
        " LIMIT 3";


        // llamado Statament
        Statement st = conexion.createStatement();


        // ejecutar consulta Statement
        ResultSet rs = st.executeQuery(consulta);

        // recorrer resultSet
        while (rs.next()) {
            String Nombre = rs.getString("Nombre");
            Integer Promedio = rs.getInt("Promedio");
            respuestaConsulta3.add( new LideresCostoPromVO(Nombre,Promedio));
        }


        // cerrar conexion
        rs.close();
        st.close();
        conexion.close();

        // 
        return respuestaConsulta3;
    }

    
}
