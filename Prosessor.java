class Prosessor{
  private double  klokkehastighet;
  private int kjerner;

  /*
  Denne delen av programmet gjor veldig lite, dette er litt med intesjon.
  */
  Prosessor(int kjerner, double klokkehastighet){
    this.klokkehastighet = klokkehastighet;
    this.kjerner = kjerner;
  }

  //Gjor FLOPS utregningen.
  public double flopsPerProsessor(){
    double x = klokkehastighet * Math.pow(10, 9) * (double)kjerner * 8.00;
    return x;
  }

}
