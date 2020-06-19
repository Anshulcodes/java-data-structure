import java.io.*;

class stack{

  static class Node
  {
      int data;
      Node next;

      Node(int data)
      {
        this.data=data;
      }

  }

  static Node top;

  stack()
  {
    this.top=null;
  }

  public static void push(int data)
  {
      Node temp = new Node(data);
      temp.next=null;
      if(top==null)
      {
          top=temp;
          return;
      }
      else{
          temp.next=top;
          top=temp;
          return;
      }
  }

  public static void pop(stack st)
  {
      if(st.top== null)
      {
        System.out.println("Stack empty...");
      }
      else
      {
        System.out.println(top.data+" removed...");
        top=top.next;
      }
  }

  public static void printStack()
  {
    Node temp=top;
    System.out.println("  *********************      ");
    while(temp.next!=null)
    {
      System.out.println(temp.data);
      temp=temp.next;
    }
    System.out.println(temp.data);
    System.out.println("  *********************      ");
  }

  public static void main(String[] args) throws IOException
  {
    stack st= new stack();
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    int n= Integer.parseInt(br.readLine());
    while(n>0)
    {
      st.push(Integer.parseInt(br.readLine()));
      n--;
    }
    printStack();
    pop(st);
    printStack();
  }

}
