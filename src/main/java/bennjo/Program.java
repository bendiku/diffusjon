package bennjo;

public class Program {

    private Rute[] ruter;

    public Program() {
        initialisereRuter(8,8);
    }

    private void initialisereRuter(int antallRuterIBredde, int antallRuterIHøyde){
        int antallRuter = antallRuterIBredde * antallRuterIHøyde;
        this.ruter = new Rute[antallRuter];

        for(int indeks = 0; indeks < ruter.length; indeks++){
            this.ruter[indeks] =  new Rute(indeks);
        }
    }

    public Rute[] getRuter() {
        return ruter;
    }

}
