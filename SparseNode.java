public class SparseNode
{
  private int data, row, col;
  private SparseNode next;

  public SparseNode()
  {
  }

  public SparseNode(int row, int col, int data)
  {
    this.row = row;
    this.col = col;
    this.data = data;
  }

  public void setNext(SparseNode node)
  {
    next = node;
  }

  public SparseNode next()
  {
    return next;
  }

  public boolean hasNext()
  {
    if(next != null)
      return true;
    else
      return false;
  }

  public int getRow()
  {
    return row;
  }

  public int getCol()
  {
    return col;
  }

  public int getData()
  {
    return data;
  }

  public boolean checkCoords(int row, int col)
  {
    if(this.row == row && this.col == col)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  public void setData(int data)
  {
    this.data = data;
  }
}
