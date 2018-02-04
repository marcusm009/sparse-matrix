public class SparseMatrix implements SparseInterface
{
  SparseNode head;

  public SparseMatrix()
  {

  }

  public void clear()
  {

  }

  public void setSize(int size)
  {

  }

  public void addElement(int row, int col, int data)
  {
    SparseNode current = head;
    try
    {
      if(current.getRow() == row && current.getCol() == col)
      {
        current.setData(data);
      }
      else
      {
        while(current.hasNext())
        {
            current = current.next();
        }
        current.setNext(new SparseNode(row, col, data));
      }
    }
    catch(NullPointerException e)
    {
      head = new SparseNode(row, col, data);
    }

  }

  public void removeElement(int row, int col)
  {

  }

  public int getElement(int row, int col)
  {
    SparseNode current = head;
    while(current.hasNext())
    {
      current = current.next();
    }
    return current.getData();
  }

  public int determinant()
  {
    return 0;
  }

  public SparseInterface minor(int row, int col)
  {
    return null;
  }

  public String toString()
  {
    SparseNode current = head;
    String str = "";

    while(current.hasNext())
    {
      str += "Row: " + current.getRow() + " Col: " + current.getCol() + " Data: " + current.getData() + "\n";
      current = current.next();
    }
    str += "Row: " + current.getRow() + " Col: " + current.getCol() + " Data: " + current.getData() + "\n";
    return str;
  }

  public int getSize()
  {
    return 0;
  }
}
