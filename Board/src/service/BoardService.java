package service;

import Interface.Clear;
import Interface.Create;
import Interface.Delete;
import Interface.Read01;
import Interface.Read02;
import Interface.Update;
import dto.Board;
import java.util.List;

public interface BoardService extends Create, Read01, Read02, Clear, Delete, Update {


  List<Board> list();
}
