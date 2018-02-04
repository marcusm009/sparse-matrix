import java.util.Scanner;

class Project1
{

  public static void main(String args[])
  {
    Scanner scan = new Scanner(System.in);
    SparseMatrix sm = new SparseMatrix();
    char cont = 'y';

    while(cont != 'n')
    {
      System.out.println("Enter row");
      int row = scan.nextInt();
      System.out.println("Enter col");
      int col = scan.nextInt();
      System.out.println("Enter data");
      int data = scan.nextInt();

      scan.nextLine();

      sm.addElement(row, col, data);

      System.out.println("Continue? (y/n)");
      cont = scan.next().charAt(0);
    }

    System.out.println(sm.toString());

  }

}
