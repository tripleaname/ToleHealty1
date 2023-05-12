package id.xproteam.tolehealty.models;

public class Video {
    private String stringJudul, stringLink, stringGambar;

    public Video() {
    }

    public Video(String stringJudul, String stringLink, String stringGambar) {
        this.stringJudul = stringJudul;
        this.stringLink = stringLink;
        this.stringGambar = stringGambar;
    }

    public String getStringJudul() { return stringJudul; }

    public void setStringJudul(String stringJudul) {
        this.stringJudul = stringJudul;
    }

    public String getStringLink() {
        return stringLink;
    }

    public void setStringLink(String stringLink) {
        this.stringLink = stringLink;
    }

    public String getStringGambar() {
        return stringGambar;
    }

    public void setStringGambar(String stringGambar) {
        this.stringGambar = stringGambar;
    }

}
