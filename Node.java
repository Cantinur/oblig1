/* Benyttet meg av tipset i oppgaven sa nar jeg konstuerer en node sa konsturerer jeg ogsa
de to prossesorene som den vil trenge.*/
class Node{
  private int gb;
  private Prosessor p1;
  private Prosessor p2;

  /* Ved a lage en node for man alle variablene til prossessor ogsa, dette
  gjor det lettere i kode konstruksjon lenger opp i programmet. Har en boolean
  som definerer om Noden har to prosessorer eller ikke. Den har automatisk da
  de samme verdiene for begge prossessorer. */

  //Husm a sette public pa konstruktor.
  Node(int gb, boolean ant, int k, double kl){
    this.gb = gb;
    p1 = new Prosessor(k, kl);
    if (ant){
      p2 = new Prosessor(k, kl);
    } else {
      p2 = null;
    }
  }

  /*Refererer til utregnelsen som gjores per prosessor.
  Her legger den sammen slik at den for samlet hastighet for Noden.*/
  public double flops(){
    double f = p1.flopsPerProsessor();
    if (p2 != null){
      f = f + p2.flopsPerProsessor();
    }
    return f;
  }

  // returnerer GB mengden til prossessor.
  public int gb(){
    return gb;
  }


}
