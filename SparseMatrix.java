public class SparseMatrix implements SparseInterface
{
  private SparseNode head;
  private int size;

  public SparseMatrix()
  {
    size = 5;
  }

  public SparseMatrix(int size)
  {
    this.size = size;
  }

  public void clear()
  {
    head = null;
  }

  public void setSize(int size)
  {
    this.size = size;
    clear();
  }

  public void addElement(int row, int col, int data)
  {
    //Sets the current to the head and previous node to null
    SparseNode curNode = head;
    SparseNode prevNode = null;

    SparseNode newNode = new SparseNode(row, col, data);

    //Throws an error if the specified row or col are out of bounds
    if(row > size || col > size || row < 0 || col < 0)
    {
      throw new ArrayIndexOutOfBoundsException();
    }

    //If the matrix is all zeros, it assigns head as the first entry
    if(head == null)
    {
      head = newNode;
      return;
    }

    while(true)
    {
      //If the row is greater than the current row, it tries to iterate
      if(row > curNode.getRow())
      {
        //If there is another node, then it iterates
        if(curNode.hasNext())
        {
          prevNode = curNode;
          curNode = curNode.next();
        }
        //Otherwise, it makes the last node point to the new node
        else
        {
          curNode.setNext(newNode);
          return;
        }
      }
      //If the row is equal, it must then test the column
      else if(row == curNode.getRow())
      {
        //If the column is greater than the current column, it either iterates
        //or sets the final element to point to the new element
        if(col > curNode.getCol())
        {
          if(curNode.hasNext())
          {
            prevNode = curNode;
            curNode = curNode.next();
          }
          else
          {
            curNode.setNext(newNode);
            return;
          }
        }
        //If the row and column are equal, it overwrites the data
        else if(col == curNode.getCol())
        {
          curNode.setData(data);
          return;
        }
        //If the column is less than the current column, then it assigns the new
        //node as the next element or sets the head (if it is the first element)
        else
        {
          if(prevNode != null)
          {
            prevNode.setNext(newNode);
          }
          else
          {
            head = newNode;
          }
          newNode.setNext(curNode);
          return;
        }
      }
      //If the row is less than the current row, then it inserts it at that
      //position (similar to above)
      else
      {
        if(prevNode != null)
        {
          prevNode.setNext(newNode);
        }
        else
        {
          head = newNode;
        }
        newNode.setNext(curNode);
        return;
      }
    }
  }

  public void removeElement(int row, int col)
  {
    SparseNode curNode = head;
    SparseNode prevNode = null;

    //Throws an error if the specified row or col are out of bounds
    if(row > size || col > size || row < 0 || col < 0)
    {
      throw new ArrayIndexOutOfBoundsException();
    }

    //Doesn't do anything if the list is empty
    if(head == null)
    {
      return;
    }

    //Iterates until it finds what it's looking for or reaches the end
    while(true)
    {
      if(curNode.sameCoords(row, col))
      {
        if(prevNode != null)
        {
          if(curNode.hasNext())
          {
            //Removes an element from the middle of the list by setting the
            //previous node's next to the current node's next
            prevNode.setNext(curNode.next());
          }
          else
          {
            //Removes the last element by setting the previous element's pointer
            //to null
            prevNode.setNext(null);
          }
        }
        else
        {
          if(curNode.hasNext())
          {
            //Removes the first element by setting the head to the current
            //element's next
            head = curNode.next();
          }
          else
          {
            //Removes everything if it is the only element in the list
            head = null;
          }
        }
        return;
      }
      else
      {
        //Iterates by updating the current node
        if(curNode.hasNext())
        {
          prevNode = curNode;
          curNode = curNode.next();
        }
        else
        {
          return;
        }
      }
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

    //Doesn't do anything if the list is empty
    if(head == null)
    {
      return 0;
    }

    //Iterates through the linked list until it reaches what it's looking for
    //or the size of the list
    while(true)
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
        continue;
      }

      //If the row-col combination isn't found in the list, it returns 0
      return 0;
    }
  }

  public int determinant()
  {
    return 0;
  }

  public SparseInterface minor(int row, int col)
  {
    SparseMatrix minor = new SparseMatrix(this.size - 1);

    SparseNode curNode = head;
    SparseNode prevNode = null;

    //Throws an error if the specified row or col are out of bounds
    if(row > size || col > size || row < 0 || col < 0)
    {
      throw new ArrayIndexOutOfBoundsException();
    }

    //Doesn't do anything if the list is empty
    if(head == null)
    {
      return null;
    }

    while(true)
    {
      //If the current node doesn't share the same column and row as the
      //arguments passed in, it is added to the minor
      f(curNode.getCol() != col && curNode.getRow() != row)
      {
        minor.addElement(curNode.getRow(), curNode.getCol(), curNode.getData());
      }
      //Iterates through the list
      if(curNode.hasNext())
      {
        prevNode = curNode;
        curNode = curNode.next();
      }
      //Exits the loop
      else
      {
        break;
      }
    }
    return minor;

  }

  public String toString()
  {
    SparseNode curNode = head;
    String str = "";

    if(head != null)
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
