class Hovedprogram{
  public static void main(String[] args) {
    Regneklynge abel = new Regneklynge(12);

    Node n64 = new Node(64, true, 8, 2.6);
    Node n1024 = new Node(1024, true, 8, 2.3);

    for (int i = 0; i < 650; i++){
      abel.settInnNode(n64);
    }

    for (int i = 0; i < 16; i++){
      abel.settInnNode(n1024);
    }

    abel.flops();
    abel.noderMedNokMinne(32);
    abel.noderMedNokMinne(64);
    abel.noderMedNokMinne(128);
    System.out.println("Antall rack: " + abel.antallIListe());
  }
}
