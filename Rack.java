class Rack{

  private String rackNavn;
  private int storrelse;
  private Node[] nodeListe = new Node[storrelse];

  /*La med en int konstrukro slik at man kan endre storrelsen pa rack.
  Slik det er konstruert na sa ma riktig nok alle rack i en regneklyne
  sa ma alle rack ha plass til like mange noder.*/
  Rack(String rackNavn, int storrelse, Node[] nodeListe){
    this.rackNavn = rackNavn;
    this.storrelse = storrelse;
    this.nodeListe = nodeListe;
  }

  //Returnerer navnet til racket.
  public String toString(){
    return rackNavn;
  }

  //Returnerer en boolean for a se etter om det er plass eller ikke i racket.
  public boolean erPlass(){
    int count = 0;
    for (Node n : nodeListe){
      if (n != null){
        count++;
      }
    }
    if (count == storrelse){
      return false;
    }
    return true;
  }

  //Ser etter ledig plass og legger til noede.
  public void leggTilNode(Node n){
    for (int i = 0; i < storrelse; i++){
      if (nodeListe[i] == null){
        nodeListe[i] = n;
        return;
      }
    }
  }

  /*Her legger jeg sammen alle nodene i et rack. Denne summen
  blir brukt av flops metoden i regeneklynge. */
  public double flopsPerRack(){
    double k = 0;
    for (Node n : nodeListe){
      if (n != null){
        double f = n.flops();
        k = k + f;
      }
    }
    return k;
  }

  /*Enkel teller for hvert rack som teller opp hvor mange noder
  som oppfyller minne kravet.*/
  public int noderMinne(int paakrevdMinne){
    int count = 0;
    for (Node n : nodeListe){
      if (n != null){
        if (n.gb() >= paakrevdMinne){
          count++;
        }
      }
    }
    return count;
  }



}
