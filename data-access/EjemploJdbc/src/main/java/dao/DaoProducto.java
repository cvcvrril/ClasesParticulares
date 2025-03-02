package dao;

import dao.common.DBConnectionPool;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import lombok.extern.log4j.Log4j2;
import model.Producto;
import model.error.ExamError;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DaoProducto {

    /**
     * Importamos el DB Connection, muy importante hacer el inject
     **/

    private final DBConnectionPool db;

    @Inject
    public DaoProducto(DBConnectionPool db) {
        this.db = db;
    }

    /**
     * Método para obtener todos los productos
     * **/

    public Either<ExamError, List<Producto>> getAll(){
        Either<ExamError, List<Producto>> res;
        List<Producto> productos;
        try(Connection connection = db.getConnection()){
            PreparedStatement pstmt = connection.prepareCall("select * from producto");
            ResultSet rs = pstmt.executeQuery();
            productos = readRS(rs);
            if (productos.isEmpty()){
                res = Either.left(new ExamError(0, "The list of products is empty"));
            }else {
                res = Either.right(productos);
            }
        }catch (SQLException e) {
            //log.error(e.getMessage(), e);
            res = Either.left(new ExamError(0, "There was an unexpected error"));
        }
        return res;
    }

    /**
     * Mapeado
     * **/

    /**
     * Para Strings usar getString, NO getNString
     * **/

    private List<Producto> readRS(ResultSet rs) throws SQLException{
        List<Producto> productoList = new ArrayList<>();
        while (rs.next()){
            int codigo = rs.getInt("codigo");
            String nombre = rs.getString("nombre");
            double pvp = rs.getDouble("pvp");
            int stock = rs.getInt("stock");
            int categoria = rs.getInt("categoria");
            productoList.add(new Producto(codigo, nombre, pvp, stock, categoria));

        }
        return productoList;

    }

}
