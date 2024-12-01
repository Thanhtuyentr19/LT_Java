import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLTest {
    public static void main(String[] args) {
 
        String url = "jdbc:mysql://localhost:3306/DATA";
        String username = "root";
        String password = "HoaiLuong@123";

 
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Kết nối thành công!");
            
            Statement getAllStatement = connection.createStatement();
            
            String sqlCommand = "SELECT * FROM Table1";
            ResultSet resultSet = getAllStatement.executeQuery(sqlCommand);

            ResultSetMetaData metaData = resultSet.getMetaData();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.print(metaData.getColumnLabel(i) + "\t           ");
            }
            System.out.println();
            while(resultSet.next()) {
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.print(resultSet.getObject(i) + "\t       ");
                }
                System.out.println();
            }
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Kết nối thất bại. Lỗi: " + e.getMessage());
        } finally {
            //TODO
        }
    }
}
