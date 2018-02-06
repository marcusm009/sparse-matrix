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
    head = null;
    entries = 0;
  }

  public void setSize(int size)
  {
    this.size = size;
    clear();
  }

  public void addElement(int row, int col, int data)
  {
    //Sets the current to the head
    SparseNode curNode = head;

    //Throws an error if the specified row or col are out of bounds
    if(row > size || col > size || row < 0 || col < 0)
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
        if(curNode.getRow() == row && curNode.getCol() == col)
        {
          curNode.setData(data);
          break;
        }
        //If the current node has a node after it, it sets the next node as
        //current and continues to the next iteration
        if(curNode.hasNext())
        {
          curNode = curNode.next();
          continue;
        }
        //If the current node doesn't have a next, it creates one
        curNode.setNext(new SparseNode(row, col, data));
      }
    }
    //Increments the amount of elements
    entries++;
  }

  public void removeElement(int row, int col)
  {
    SparseNode prevNode = null;
    SparseNode curNode = head;

    //Throws an error if the specified row or col are out of bounds
    if(row > size || col > size || row < 0 || col < 0)
    {
      throw new ArrayIndexOutOfBoundsException();
    }

    //Doesn't do anything if the list is empty
    if(entries == 0)
    {
      return;
    }
    //If the list is of length one, it checks if it the node is the correct
    //one to be removed and takes appropriate action
    else if(entries == 1)
    {
      if(curNode.checkCoords(row, col))
      {
        head = null;
        entries--;
        return;
      }
    }
    //If the length is greater than two, it sets the current node to the next
    //node and keeps the previous node as a backup
    else
    {
      for(int i = 0; i < entries; i++)
      {
        if(curNode.checkCoords(row,col))
        {
          if(i == 0)
          {
            head = curNode.next();
          }
          else
          {
            prevNode.setNext(curNode.next());
          }
          break;
        }
        prevNode = curNode;
        curNode = prevNode.next();
      }
      entries--;
    }
  }

  public int getElement(int row, int col)
  {
    //Sets the current to the head
    SparseNode curNode = head;

    //Throws an error if the specified row or col are out of bounds
    if(row > size || col > size || row < 0 || col < 0)
    {
      throw new ArrayIndexOutOfBoundsException();
    }

    //Iterates through the linked list until it reaches the entry size
    for(int i = 0; i < entries; i++)
    {
      //If the specified row and col have a non-zero element, it returns it
      if(curNode.getRow() == row && curNode.getCol() == col)
      {
        return(curNode.getData());
      }
      //If the current node has a node after it, it sets the next node as
      //current and continues to the next iteration
      if(curNode.hasNext())
      {
        curNode = curNode.next();
      }
    }
    //If the row-col combination isn't found in the list, it returns 0
    return 0;
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
    SparseNode curNode = head;
    String str = "";

    if(entries != 0)
    {
      //Iterates through
      while(curNode.hasNext())
      {
        str += "Row: " + curNode.getRow() + " Col: " + curNode.getCol() + " Data: " + curNode.getData() + "\n";
        curNode = curNode.next();
      }
      str += "Row: " + curNode.getRow() + " Col: " + curNode.getCol() + " Data: " + curNode.getData() + "\n";
    }
    return str;
  }

  public int getSize()
  {
    return size;
  }
}
