package dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString

public class Board {

  private int bno;
  private String btitle;
  private String bcontent;
  private String bwriter;
  private Date bdate;

  public Board(String btitle, String bcontent, String bwriter, Date bdate) {
    this.btitle = btitle;
    this.bcontent = bcontent;
    this.bwriter = bwriter;
    this.bdate = bdate;
  }
}
