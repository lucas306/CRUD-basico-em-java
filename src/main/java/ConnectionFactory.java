import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private String usuario = "root";
    private String senha = " ";
    private String host = " ";
    private String porta = " ";
    private String bd = "db_pessoas";

    public Connection obtemConexao() {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":" + porta + "/" + bd,
                    usuario,
                    senha
            );
            System.out.println("Conexao bem sucedida");
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
