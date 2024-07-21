import dto.Board;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import lombok.Locked.Read;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardExample {

  private final BoardService boardService = new BoardServiceImpl();

  Scanner sc = new Scanner(System.in);
//BoardExample
  //list
  //mainMenu

  public static void main(String[] args) {
    BoardExample boardexample = new BoardExample(); //보드 객체 생성
    boardexample.list();
  }

public void list() {

  List<Board> boardList = new ArrayList<>();
  boardList = boardService.list();

      int num = 0;
      boolean quit = true;
      while (quit) {// 4에서만 탈출하도록 조건식 제시, 4가 아닌 경우 아래 출력
        System.out.println("[게시물 목록]");
        System.out.println("-------------------------------------");
        System.out.println("""
            no     writer     date        title""");
        System.out.println("-------------------------------------");


        System.out.println("메인메뉴: " + "1. Create\t\t" + "2. Read\t\t " + "3. Clear\t\t" + "4. Exit\t\t");
        System.out.print("메뉴선택: ");
        num = sc.nextInt();
        sc.nextLine();

          switch (num) {
            case 1:
              System.out.println("[새 게시물 입력]");
              System.out.print("제목 : ");
              String title = sc.nextLine();
              System.out.print("내용 : ");
              String content = sc.nextLine();
              System.out.print("작성자 : ");
              String writer = sc.nextLine();
              Board newBoard = new Board(title, content, writer, new Date());
              boardService.create(newBoard);
              break;

            case 2:
              System.out.print("삭제할 게시판 번호를 입력하세요 : ");
              int index = sc.nextInt();
              sc.nextLine();

              boardService.delete(index);

              break;

            case 3:
              System.out.println("Clear메서드");
              break;

            case 4:
              System.out.println("프로그램을 종료합니다.");
              quit = false;
              break;

            default:
              System.out.println("잘못된 입력입니다. 1~4 숫자 입력\n");
              break;


              }

            }
          }
      }


