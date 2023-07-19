package test1;

// Java program to demonstrate working of
// interface

// A simple interface
interface Test1{

    // public, static and final
    final int a = 10;

    // public and abstract
    void display();
}

// A class that implements the interface.
class TestClass implements Test1 {

    // Implementing the capabilities of
    // interface.
    public void display(){
        System.out.println("Geek");
    }

    // Driver Code
    public static void main(String[] args)
    {
        TestClass t = new TestClass();
        t.display();
        System.out.println(a);
    }
}