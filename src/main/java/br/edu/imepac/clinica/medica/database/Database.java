package br.edu.imepac.clinica.medica.database;

import br.edu.imepac.clinica.medica.views.aluno.AlunoCadastro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Database {

    protected Connection connection;

    public Database() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/academico?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false",
                    "root",
                    "12345678"
            );
        } catch (SQLException ex) {
            Logger.getLogger(AlunoCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() throws SQLException {
        this.connection.close();
    }

}
