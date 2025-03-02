package dao;

import dao.common.DBConnectionPool;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import model.Categoria;
import model.Producto;
import model.error.ExamError;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCategoria {

    /**
     * Importamos el DB Connection, muy importante hacer el inject
     **/

    private final DBConnectionPool db;

    @Inject
    public DaoCategoria(DBConnectionPool db) {
        this.db = db;
    }

    /**
     * Método para obtener todas las categorias
     * **/

    public Either<ExamError, List<Categoria>> getAll(){
        Either<ExamError, List<Categoria>> res;
        List <Categoria> categorias;
        try(Connection connection = db.getConnection()){
            PreparedStatement pstmt = connection.prepareCall("select * from categoria");
            ResultSet rs = pstmt.executeQuery();
            categorias = readRS(rs);
            if (categorias.isEmpty()){
                res = Either.left(new ExamError(0, "The list of categories is empty"));
            }else {
                res = Either.right(categorias);
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

    private List<Categoria> readRS(ResultSet rs) throws SQLException{
        List<Categoria> productoList = new ArrayList<>();
        while (rs.next()){
            int codigo = rs.getInt("codigo");
            String nombre = rs.getString("nombre");
            productoList.add(new Categoria(codigo,nombre));
        }
        return productoList;
    }
}
