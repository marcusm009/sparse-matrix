import java.util.Scanner;

class Project1
{

  public static void main(String args[])
  {
    Scanner scan = new Scanner(System.in);
    SparseMatrix sm = new SparseMatrix();
    char cont = 'y';
    int row = 0;
    int col = 0;
    int data = 0;

    while(cont != 'n')
    {
      System.out.println("Add, remove, get, minor, clear, or print? (a/r/g/m/c/p)");
      char mode = scan.next().charAt(0);

      if(mode == 'a' || mode == 'r' || mode == 'g' || mode == 'm')
      {
        System.out.println("Enter row");
        row = scan.nextInt();
        System.out.println("Enter col");
        col = scan.nextInt();
      }

      if(mode == 'a')
      {
        System.out.println("Enter data");
        data = scan.nextInt();
        sm.addElement(row, col, data);
      }
      else if(mode == 'r')
      {
        sm.removeElement(row, col);
      }
      else if(mode == 'g')
      {
        System.out.println(sm.getElement(row, col));
      }
      else if(mode == 'c')
      {
        sm.clear();
      }
      else if(mode == 'p')
      {
        System.out.println(sm.toString());
      }
      else if(mode == 'm')
      {
        sm = (SparseMatrix) sm.minor(row, col);
      }



      System.out.println("Continue? (y/n)");
      scan.nextLine();
      cont = scan.next().charAt(0);
    }
  }

}
