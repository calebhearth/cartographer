class HelloWorld {
  public:
   int n;
   HelloWorld() { n=3; }
   void doStuff() { int x = 5 * 9;  }
};

int main() {
  HelloWorld *hw = new HelloWorld();
  hw->doStuff();
  delete hw;
  return 0;
}
