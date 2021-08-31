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
import model.vo.LiderSalarioCartagoVO;

public class LideresSalarioCartagoDAO {
        
    public ArrayList<LiderSalarioCartagoVO> consultarLideresCartago() throws SQLException {

        // crear arreglo donde guardamos los registros que son el resultado que vamos a ejecutar
        ArrayList<LiderSalarioCartagoVO> respuestaConsulta1 = new ArrayList<LiderSalarioCartagoVO>();

        // abrir conexion con la base de datos
        Connection conexion = JDBCutilities.getConnection();

        // ejecutar la consulta sql

        String consulta = 
        " SELECT Nombre || \" \" || Primer_Apellido || \" \" || Segundo_Apellido Nombre , Salario" +
        " FROM Lider "+ 
        " WHERE Ciudad_Residencia = 'Cartago' " +
        " ORDER BY Nombre ";


        // llamado Statament
        Statement st = conexion.createStatement();


        // ejecutar consulta Statement
        ResultSet rs = st.executeQuery(consulta);

        // recorrer resultSet
        while (rs.next()) {
            String Nombre = rs.getString("Nombre");
            Integer Salario = rs.getInt("Salario");
            respuestaConsulta1.add( new LiderSalarioCartagoVO(Nombre, Salario));
        }


        // cerrar conexion
        rs.close();
        st.close();
        conexion.close();

        // 
        return respuestaConsulta1;
    }

}

