import java.util.ArrayList;

class Regneklynge{
  //Oppretter en privat ArrayListe som inneholder Rack.
  private ArrayList<Rack> rackListe = new ArrayList<Rack>();
  private int storrelsePaaRack;

  Regneklynge(int storrelsePaaRack){
    this.storrelsePaaRack = storrelsePaaRack;
  }

  //Hjelpeklasse som genererer et nytt Rack.
  public Rack leggTilRack(){
    int i = rackListe.size() + 1;
    String navn = "Rack " + i;
    int x = storrelsePaaRack;
    Node[] liste = new Node[x];
    Rack r = new Rack(navn, x, liste);
    rackListe.add(r);
    return r;
  }

  //Summerer opp antall rack totalt i regneklyngen.
  public int antallIListe(){
    return rackListe.size();
  }

  /*Her er en metode som enten setter inn en node der det er ledig plass
  hvis det ikke er plass så lager den et nytt rack.*/
  public void settInnNode(Node n){
    for (Rack r : rackListe){
      if(r.erPlass()){
        r.leggTilNode(n);
        return;
      }
    }
    //Oppretter nytt rack og legger inn noden.
    Rack r = leggTilRack();
    r.leggTilNode(n);
  }

  //Legger sammen alle Rack veridene sammen.
  public void flops(){
    double tot = 0.00;
    for (Rack r : rackListe){
      if (r != null){
        double t = r.flopsPerRack();
        tot = tot + t;
      }
    }
    System.out.println("Samlet FLOPS: " + tot);
  }

  //Site steg i gjennomforingen av a se etter hvor mange Noder som oppfyller minne krav.
  public void noderMedNokMinne(int paakrevdMinne){
    int count = 0;
    for(Rack r : rackListe){
      if (r != null){
        int i = r.noderMinne(paakrevdMinne);
        count = count + i;
      }
    }
    System.out.println("Noder med minst " + paakrevdMinne + " GB: " + count);
  }

}
