public class Letter {
    private String Morse;
    private String Latin;
    private String Cyrillic;

    public Letter(String morse, String latin, String cyrillic) {
        Morse = morse;
        Latin = latin;
        Cyrillic = cyrillic;
    }

    public Letter(String morse, String cyrillic) {
        Morse = morse;
        Cyrillic = cyrillic;
    }

    public String getMorse() {
        return Morse;
    }

    public String getLatin() {
        return Latin;
    }

    public String getCyrillic() {
        return Cyrillic;
    }
}
