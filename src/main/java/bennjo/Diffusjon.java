package bennjo;

public class Diffusjon {

    private Grensesnitt gui;
    private Program program;

    public Diffusjon() {

        nyDiffusjon();

    }


    private void nyDiffusjon(){
        this.program = new Program();
        this.gui = Grensesnitt.lagNyttGrensesnitt(8, program.getRuter());
    }

    public static void main(String[] args) {
        new Diffusjon();
    }
}
