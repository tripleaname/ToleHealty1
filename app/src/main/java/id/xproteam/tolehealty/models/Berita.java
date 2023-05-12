package id.xproteam.tolehealty.models;

public class Berita {
    private String stringJudul, stringDeskripsi, stringArtikel, stringGambar, stringTanggal, stringLink;

    public Berita() {
    }

    public Berita(String stringJudul, String stringDeskripsi, String stringArtikel, String stringGambar, String stringTanggal, String stringLink) {
        this.stringJudul = stringJudul;
        this.stringDeskripsi = stringDeskripsi;
        this.stringArtikel = stringArtikel;
        this.stringGambar = stringGambar;
        this.stringTanggal = stringTanggal;
        this.stringLink = stringLink;

    }

    public String getStringJudul() {
        return stringJudul;
    }

    public void setStringJudul(String stringJudul) {
        this.stringJudul = stringJudul;
    }

    public String getStringDeskripsi() {
        return stringDeskripsi;
    }

    public void setStringDeskripsi(String stringDeskripsi) {
        this.stringDeskripsi = stringDeskripsi;
    }

    public String getStringArtikel() {
        return stringArtikel;
    }

    public void setStringArtikel(String stringArtikel) {
        this.stringArtikel = stringArtikel;
    }

    public String getStringGambar() {
        return stringGambar;
    }

    public void setStringGambar(String stringGambar) {
        this.stringGambar = stringGambar;
    }

    public String getStringTanggal() {
        return stringTanggal;
    }

    public void setStringTanggal(String stringTanggal) {
        this.stringTanggal = stringTanggal;
    }

    public String getStringLink() {
        return stringLink;
    }

    public void setStringLink(String stringLink) {
        this.stringLink = stringLink;
    }
}
