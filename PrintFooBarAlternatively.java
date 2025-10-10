Suppose you are given the following code:

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
The same instance of FooBar will be passed to two different threads:

thread A will call foo(), while
thread B will call bar().
Modify the given program to output "foobar" n times.


class FooBar {
    private int n;
    private boolean fooTurn = true;  // flag to control order

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!fooTurn) {
                wait();  // wait for foo's turn
            }
            printFoo.run();  // prints "foo"
            fooTurn = false;
            notifyAll();  // wake up bar thread
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (fooTurn) {
                wait();  // wait for bar's turn
            }
            printBar.run();  // prints "bar"
            fooTurn = true;
            notifyAll();  // wake up foo thread
        }
    }
}
