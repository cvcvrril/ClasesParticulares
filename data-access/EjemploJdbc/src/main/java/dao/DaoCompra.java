package dao;

import dao.common.DBConnectionPool;
import io.vavr.control.Either;
import jakarta.inject.Inject;
import model.Compra;
import model.error.ExamError;

import java.sql.*;
import java.time.LocalDate;

public class DaoCompra {

    /**
     * Importamos el DB Connection, muy importante hacer el inject
     **/

    private final DBConnectionPool db;

    @Inject
    public DaoCompra(DBConnectionPool db) {
        this.db = db;
    }

    public Either<ExamError, Integer> addCompra(Compra newCompra){
        Either<ExamError, Integer> res;
        try(Connection connection = db.getConnection()){
            try (PreparedStatement pstmt = connection.prepareStatement("insert into compra (cod_pro, dni_cliente, fecha_hora, cantidad, tipo_pago) values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){
                connection.setAutoCommit(false);

                pstmt.setInt(1,newCompra.getCodPro());
                pstmt.setString(2,newCompra.getDniCliente());
                pstmt.setDate(3, Date.valueOf(LocalDate.now()));
                pstmt.setInt(4,newCompra.getCantidad());
                pstmt.setString(5,newCompra.getTipoPago());

                int result = pstmt.executeUpdate();

                if (result > 0) {
                    res = Either.right(result);
                } else {
                    res = Either.left(new ExamError(0, "Ha habido un error"));
                }
            }catch (SQLException e) {
                res = Either.left(new ExamError(0, e.getMessage()));
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    res = Either.left(new ExamError(0, e.getMessage()));
                }
            } finally {
                connection.setAutoCommit(true);
            }
        }catch (SQLException e) {
            //log.error(e.getMessage(), e);
            res = Either.left(new ExamError(0, "There was an unexpected error"));
        }
        return res;
    }

}
