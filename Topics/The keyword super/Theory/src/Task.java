// You can experiment here, it won’t be checked

public class Task {
  public static void main(String[] args) {
    // put your code here
    B b = new B(100, "txt", 'k');
    b.print(); // answer:  100 abc z

      }
}

class A {

  protected int n = 10;
  protected String s = "abc";
  protected char ch = 'q';

  public A(int n) {
    this.n = n;
  }
}

class B extends A {

  protected int n = 20;
  protected String s = "str";
  protected char ch = 'z';

  public B(int n, String s, char ch) {
    super(n);
    this.s = s;
    super.ch = ch;
  }

  public void print() {
    System.out.println(super.n + " " + super.s + " " + ch);
  }
  //  B b = new B(100, "txt", 'k');
}



