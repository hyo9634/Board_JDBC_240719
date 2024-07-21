package lib;
//db를 커넥션 하기 위한 부분
//반복되는 부분 분리

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.management.Query;

public abstract class ObjectDbio {
  //jdbc연동
  private String db_url = "jdbc:mysql://localhost:3306/employees";
  private String db_id = "root";
  private String db_pwd = "lhs1379";


  private Connection connection = null;

  private void open(){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(db_url, db_id, db_pwd);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      System.err.println(e.getMessage());
    }

  }
  public void close(){
    try{
      connection.close();
    }catch (SQLException e){
      System.err.println(e.getMessage());
    }

  };
  public ResultSet statement(String Query, ResultSet rs){
    //DB를 반환값을 가져올때
    //serch(read01,02)
    // 1. DB와 open으로 연결하기
    // 2. prepared 생성
    // 3. prepared의 쿼리를 매개값으로 전달
    // 4. 전달받은 쿼리문 실행
    // 5. 실행한 결과를 ResultSet에 담기
    // 6. ResulSet 리턴하기
    open();
    try {
      PreparedStatement ps = connection.prepareStatement(Query);
    rs = ps.executeQuery();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return rs;
  }

  protected void preparedStatement(String Query){
    //반환값이 필요없을때
    //update, delete, insert, create, clear 등등
    PreparedStatement ps = null;
    open();
    try {
      ps = connection.prepareStatement(Query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    try {
      ps.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  };


}
