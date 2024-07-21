package service;

import java.util.ArrayList;
import dto.Board;
import java.util.Date;
import java.util.List;
import javax.management.Query;
import lib.ObjectDbio;

public class BoardServiceImpl extends ObjectDbio implements BoardService {



  @Override
  public void clear() {

  }

  @Override
  public void create(Board board) {
    String query = "INSERT INTO Board( title, content, writer, date ) values ('" + board.getBtitle() + "', '" + board.getBcontent() + "', '" + board.getBwriter() + "', " + new Date() + " );";
    //쿼리문 varchar타입은 ''로 반드시 묶어줘야함 , 컬럼 오류,''로 묶지 않으면 varchar로 읽지 않고 참조됨.
    //String querz = "INSERT INTO Board( title, content, writer, date ) values ( 'test1', 'testtest', 'leehs', 2024-01-01 );"
    preparedStatement(query);
    close();

  }

  @Override
  public void delete(int deleteBoardNo) {
    String query = "DELETE FROM Board WHERE no = " + deleteBoardNo;
    preparedStatement(query);
    close();

  }

  @Override
  public void read01(int no) {

  }

  @Override
  public ArrayList<Board> read02() {
    return null;
  }

  @Override
  public void update(Board board) {

  }

  @Override
  public List<Board> list() {

    List<Board> boardList = new ArrayList<>();



    return null;
  }
}
