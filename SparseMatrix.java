public class SparseMatrix implements SparseInterface
{
  private SparseNode head;
  private int entries;
  private int size;

  public SparseMatrix()
  {
    size = 5;
    entries = 0;
  }

  public void clear()
  {

  }

  public void setSize(int size)
  {
    this.size = size;
    clear();
  }

  public void addElement(int row, int col, int data)
  {
    //Sets the current to the head
    SparseNode currentNode = head;

    //Throws an error if the specified row or col are out of bounds
    if(row > size || col > size || row <= 0 || col <= 0)
    {
      throw new ArrayIndexOutOfBoundsException();
    }

    //If there are no entries, it sets the specified entry as the head
    if(entries == 0)
    {
      head = new SparseNode(row, col, data);
    }
    else
    {
      //Iterates through the linked list until it reaches the entry size
      for(int i = 0; i < entries; i++)
      {
        //If the specified row and col already exist, it overwrites that node
        if(currentNode.getRow() == row && currentNode.getCol() == col)
        {
          currentNode.setData(data);
          break;
        }
        //If the current node has a node after it, it sets the next node as
        //current and continues to the next iteration
        if(currentNode.hasNext())
        {
          currentNode = currentNode.next();
          continue;
        }
        //If the current node doesn't have a next, it creates one
        currentNode.setNext(new SparseNode(row, col, data));
      }
    }
    //Increments the amount of elements
    entries++;
  }

  public void removeElement(int row, int col)
  {

  }

  public int getElement(int row, int col)
  {
    SparseNode currentNode = head;

    //Throws an error if the specified row or col are out of bounds
    if(row > size || col > size || row <= 0 || col <= 0)
    {
      throw new ArrayIndexOutOfBoundsException();
    }

    //Iterates through list and returns the data if the row and col are a match
    while(currentNode.hasNext())
    {
      if(currentNode.getRow() == row && currentNode.getCol() == col)
      {
        return currentNode.getData();
      }
      currentNode = currentNode.next();
    }

    //Does the final check
    if(currentNode.getRow() == row && currentNode.getCol() == col)
    {
      return currentNode.getData();
    }
    else
    {
      return 0;
    }
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
    SparseNode currentNode = head;
    String str = "";

    //Iterates through
    while(currentNode.hasNext())
    {
      str += "Row: " + currentNode.getRow() + " Col: " + currentNode.getCol() + " Data: " + currentNode.getData() + "\n";
      currentNode = currentNode.next();
    }
    str += "Row: " + currentNode.getRow() + " Col: " + currentNode.getCol() + " Data: " + currentNode.getData() + "\n";
    return str;
  }

  public int getSize()
  {
    return 0;
  }
}
