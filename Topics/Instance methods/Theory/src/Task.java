// You can experiment here, it won’t be checked

public class Task {

    static int height;

    public static void main(String[] args) {
        // put your code here
        Tree tree1 =  new Tree();
        Tree tree2 = tree1;
        Tree tree3 = tree2;


        tree1 = new Tree();
        tree1.age = 5;
        tree2.age = 10;
        tree3 = null;
        System.out.println(tree1.age);


    }

    private void some(){
        height = 1;
    }

}


class Tree {
    String sort;
    int age;
    double height;
}

interface Some{
    public static final int COI = 0;



}