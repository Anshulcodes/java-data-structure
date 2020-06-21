import java.io.*;
//import java.util.Stack;

class postfix2
{
  public static int valueOf(char c)
  {
    switch(c)
    {
      case '(':
        return 4;
      case '^':
        return 3;
      case '*':
        return 2;
      case '/':
          return 2;
      case '+':
          return 1;
      case '-':
          return 1;
      default:
        return -1;
    }
  }


  public static void main(String[] args) throws IOException
  {
      BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      String str= br.readLine().trim();
      str= inToPost(str);
      System.out.println(str);
  }

  public static String inToPost(String str)
  {
    String fin="";
    Stack st= new Stack();
    for(int i=0; i<str.length(); i++)
    {
      if(str.substring(i, i+1).matches("[A-Za-z]"))
      {
        fin=fin+str.substring(i, i+1);
      }
      else if((""+str.charAt(i)).matches("[\\*\\+\\-\\/\\(\\^]"))
      {
        if(valueOf(st.peek())-valueOf(str.charAt(i))<=0)
        {
          st.push(str.charAt(i));
        }
        else
        {
          // while(valueOf(st.peek())-valueOf(str.charAt(i))>0)
          while(st.peek()!=' ')
          {
            if(st.peek()=='(')
            {
              break;
            }
            if(st.peek()==' ')
            {
              break;
            }
            fin=fin+st.pop();
          }

          st.push(str.charAt(i));

        }
      }
      else{
        while(st.peek()!='('&&st.peek()!=' ')
        {
          fin=fin+st.pop();
        }

          st.pop();

      }
    }

    while(st.peek()!=' ')
    {
      fin= fin+st.pop();
      if(st.peek()=='(')
      {
        st.pop();
      }
    }
    return fin;
  }
}


class Stack{

  class Node
  {
    char oper;
    Node next;

    Node(char oper)
    {
      this.oper=oper;
      this.next=null;
    }
  }

  Node head;

  Stack()
  {
    this.head=null;
  }

  char peek()
  {
    if(this.head==null)
    {
      return ' ';
    }
    // else
    return this.head.oper;
  }

  void push(char data)
  {
    Node temp= new Node(data);
    if(this.head==null)
    {
      this.head=temp;
    }
    else {
        temp.next=this.head;
        this.head=temp;
    }
    System.out.println("pushed" + data);
  }

  char pop()
  {
    if(this.head==null)
    {
      return ' ';
    }
    else
    {
    char value=(this.head).oper;
    this.head=this.head.next;

      System.out.println("popped" + value);
    return value;
    }
  }
}
