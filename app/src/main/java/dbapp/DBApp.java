package dbapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dbapp.config.DBConfig;
import dbapp.model.Product;
import dbapp.model.ProductRepository;
import dbapp.service.ProductService;

public class DBApp {

    public static void main(String[] args) throws SQLException {

        // new Thread(()->{
        // Connection conn = DBConfig.getConnection();
        // ProductRepository productRepository = new ProductRepository(conn); // 의존성 주입
        // DI
        // try {
        // productRepository.insert("carrot", 1000, 30);
        // } catch (SQLException e) {
        // e.printStackTrace();
        // }
        // }).start();

        // Connection conn = DBConfig.getConnection(); //사용자 접근시 최초의 하나만 connection 연결!
        // ProductRepository productRepository = new ProductRepository(conn); // 의존성 주입
        // DI
        // productRepository.insert("raspberry", 1000, 30);

        // //동시에 접근 하기 때문에 transaction을 해줘야한다!!!
        // //service를 만들어서 transaction을 생성한다.

        // 1. 커넥션 가져오기
        Connection conn = DBConfig.getConnection(); // 사용자 접근시 최초의 하나만 connection 연결!
        // 2. DAO를 메모리에 올리기
        ProductRepository productRepository = new ProductRepository(conn); // 의존성 주입 DI
        // 3. SERVICE를 메모리에 올리기
        ProductService productService = new ProductService(productRepository, conn);// 의존성 주입 (같은 커넥션을 써야하기 때문에 )

        // productService.상품등록("apple", 2000, 5);

        // 메인메서드라 커넥션 종료를 안하지 컨트롤러의 하나의 메서드라면 conn.close 해줘야한다.

        // Product product = productRepository.findById(1);
        // System.out.println(product.getId());
        // System.out.println(product.getName());
        // System.out.println(product.getPrice());
        // System.out.println(product.getQty());
        // System.out.println(product.getCreatedAt());

        List<Product> productList = productRepository.findAll();
        for (Product product : productList) {
            System.out.println(product.getId());
            System.out.println(product.getName());
        }
    }
}
