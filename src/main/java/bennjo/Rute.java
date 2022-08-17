package bennjo;

public class Rute {

    private int ruteID;

    private int diffusjonsNivå;

    private Koordinat koordinat;

    public Rute(int ruteID) {
        this.ruteID = ruteID;
    }

    public int getRuteID() {
        return ruteID;
    }

    public void setRuteID(int ruteID) {
        this.ruteID = ruteID;
    }

    public int getDiffusjonsNivå() {
        return diffusjonsNivå;
    }

    public void setDiffusjonsNivå(int diffusjonsNivå) {
        this.diffusjonsNivå = diffusjonsNivå;
    }

    public void setKoordinat(Koordinat koordinat) {
        this.koordinat = koordinat;
    }

    public Koordinat getKoordinat() {
        return koordinat;
    }
}
