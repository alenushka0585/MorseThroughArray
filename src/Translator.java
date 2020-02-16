import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class Translator {
    private static List<Letter> letters = new ArrayList<>();

    static {
        letters.add(new Letter(".-", "a","а"));
        letters.add(new Letter("-...", "b","б"));
        letters.add(new Letter(".--", "w","в"));
        letters.add(new Letter("--.", "g","г"));
        letters.add(new Letter("-..", "d","д"));
        letters.add(new Letter(".", "e","е"));
        letters.add(new Letter("...-", "v","ж"));
        letters.add(new Letter("--..", "z","з"));
        letters.add(new Letter("..", "i","и"));
        letters.add(new Letter("-.-", "k","к"));
        letters.add(new Letter(".-..", "l","л"));
        letters.add(new Letter("--", "m","м"));
        letters.add(new Letter("-.", "n","н"));
        letters.add(new Letter("---", "o","о"));
        letters.add(new Letter(".--.", "p","п"));
        letters.add(new Letter(".-.", "r","р"));
        letters.add(new Letter("...", "s","с"));
        letters.add(new Letter("-", "t","т"));
        letters.add(new Letter("..-", "u","у"));
        letters.add(new Letter("..-.", "f","ф"));
        letters.add(new Letter("....", "h","х"));
        letters.add(new Letter("-.-.", "c","ц"));
        letters.add(new Letter("---.","", "ч"));
        letters.add(new Letter("----","", "ш"));
        letters.add(new Letter("--.-", "q","щ"));
        letters.add(new Letter("-.--", "y","ы"));
        letters.add(new Letter("..--", "","ю"));
        letters.add(new Letter(".-.-", "","я"));
        letters.add(new Letter(".---", "j","й"));
        letters.add(new Letter("-..-", "x","ь"));
        letters.add(new Letter("..-..", "","э"));
        letters.add(new Letter(".----", "1","1"));
        letters.add(new Letter("..--", "2","2"));
        letters.add(new Letter("...--", "3","3"));
        letters.add(new Letter("....-", "4","4"));
        letters.add(new Letter(".....", "5","5"));
        letters.add(new Letter("-....", "6","6"));
        letters.add(new Letter("--...", "7","7"));
        letters.add(new Letter("---..", "8","8"));
        letters.add(new Letter("----.", "9","9"));
        letters.add(new Letter("-----", "0","0"));
        letters.add(new Letter(".-.-.-", ",",","));
        letters.add(new Letter("......", ".","."));
        letters.add(new Letter("-.-.-", ";",";"));
        letters.add(new Letter("---...", ":",":"));
        letters.add(new Letter("..--..", "?","?"));
        letters.add(new Letter("-..--", "#","№"));
        letters.add(new Letter(".-..-.", "\"","\""));
        letters.add(new Letter(".----.", "\'","\'"));
        letters.add(new Letter("-.--.-", "(","("));
        letters.add(new Letter("--..--", "!","!"));
        letters.add(new Letter("-....-", "-","-"));
        letters.add(new Letter("-..-.", "/","/"));
        letters.add(new Letter(".----", "1","1"));
        letters.add(new Letter("\n", "\n","\n"));
    }

    public static String stringToMorseFromLatin(String text) {
        String newText = "";
        String selectedChar;
        String convertedChar;

        for (int i = 0; i < text.length(); i++) {
            selectedChar = text.charAt(i) + "";
            convertedChar = encodeFromLatin(selectedChar);

            if (convertedChar.equals(" ") || convertedChar.equals("\n")){
                newText = newText + "| ";
            } else {
                newText = newText + convertedChar;
                if (!convertedChar.equals(" ")) {
                    newText = newText + " ";
                }
            }
        }
        return newText;
    }

    public static String stringToMorseFromCyrillic(String text) {
        String newText = "";
        String selectedChar;
        String convertedChar;

        for (int i = 0; i < text.length(); i++) {
            selectedChar = text.charAt(i) + "";
            convertedChar = encodeFromCyrillic(selectedChar);

            if (convertedChar.equals(" ") || convertedChar.equals("\n")){
                newText = newText + "| ";
            } else {
                newText = newText + convertedChar;
                if (!convertedChar.equals(" ")) {
                    newText = newText + " ";
                }
            }
        }
        return newText;
    }

    public static String stringToLatin(String text) {
        String newLatin = "";
        String selectedLatin;
        String convertedLatin;
        String[] morseChars = text.split(" ");

        for (int i = 0; i < morseChars.length; i++) {
            selectedLatin = morseChars[i];
            boolean endsWithWordSeparator = selectedLatin.endsWith("|");

            if (endsWithWordSeparator){
                selectedLatin = selectedLatin.substring(0, selectedLatin.length() - 1);
            }

            convertedLatin = decodeToLatin(selectedLatin);
            newLatin = newLatin  + convertedLatin;

            if (endsWithWordSeparator) {
                newLatin = newLatin + " ";
            }
        }
        return newLatin;
    }

    public static String stringToCyrillic(String text) {
        String newCyrillic = "";
        String selectedCyrillic;
        String convertedCyrillic;
        String[] morseChars = text.split(" ");

        for (int i = 0; i < morseChars.length; i++) {
            selectedCyrillic = morseChars[i];
            boolean endsWithWordSeparator = selectedCyrillic.endsWith("|");

            if (endsWithWordSeparator){
                selectedCyrillic = selectedCyrillic.substring(0, selectedCyrillic.length() - 1);
            }

            convertedCyrillic = decodeToCyrillic(selectedCyrillic);
            newCyrillic = newCyrillic  + convertedCyrillic;

            if (endsWithWordSeparator) {
                newCyrillic = newCyrillic + " ";
            }
        }
        return newCyrillic;
    }

    public static String encodeFromLatin (String encode) {
        for (Letter letter: letters){
            if (letter.getLatin().equalsIgnoreCase(encode)){
                encode = letter.getMorse();
                break;
            }
        }
        return encode;
    }

    public static String encodeFromCyrillic (String encode) {
        for (Letter letter: letters){
            if (letter.getCyrillic().equalsIgnoreCase(encode)){
                encode = letter.getMorse();
                break;
            }
        }
        return encode;
    }

    public static String decodeToLatin (String decode) {
        for (Letter letter: letters){
            if (letter.getMorse().equalsIgnoreCase(decode)){
                decode = letter.getLatin();
                break;
            }
        }
        return decode;
    }

    public static String decodeToCyrillic (String decode) {
        for (Letter letter: letters){
            if (letter.getMorse().equalsIgnoreCase(decode)){
                decode = letter.getCyrillic();
                break;
            }
        }
        return decode;
    }
}
