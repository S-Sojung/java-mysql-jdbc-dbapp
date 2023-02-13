package dbapp.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 내부적으로 실행하면서 알아서 실행해줌!!!
            String url = "jdbc:mysql://localhost:3306/metadb";
            // . . . . . 프로토콜 이름 / ip주소 : 포트번호/db
            Connection conn = DriverManager.getConnection(url, "root", "1234");
            System.out.println("db연결 성공");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
