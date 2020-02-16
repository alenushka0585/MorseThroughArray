import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Converter {
    public static void copy (BufferedReader readerLanguage, BufferedWriter writerLanguage) throws IOException {
        String sourceRead= readerLanguage.readLine();
        StringBuilder sourceAdd = new StringBuilder();

        while (sourceRead!= null){
            sourceAdd.append(sourceRead).append("\n");
            sourceRead=readerLanguage.readLine();
        }

        String sourceResult = new String(sourceAdd);
        writerLanguage.write(sourceResult);
    }

    public static void convertToMorseFromLatin(BufferedReader readerLanguage, BufferedWriter writerMorseLanguage) throws IOException {
        String sourceRead= readerLanguage.readLine();
        StringBuilder sourceAdd = new StringBuilder();

        while (sourceRead!= null){
            sourceAdd.append(sourceRead).append("\n");
            sourceRead=readerLanguage.readLine();
        }

        String sourceResult = new String(sourceAdd);
        writerMorseLanguage.write(Translator.stringToMorseFromLatin(sourceResult));
    }

    public static void convertToMorseFromCyrillic(BufferedReader readerLanguage, BufferedWriter writerMorseLanguage) throws IOException {
        String sourceRead= readerLanguage.readLine();
        StringBuilder sourceAdd = new StringBuilder();

        while (sourceRead!= null){
            sourceAdd.append(sourceRead).append("\n");
            sourceRead=readerLanguage.readLine();
        }

        String sourceResult = new String(sourceAdd);
        writerMorseLanguage.write(Translator.stringToMorseFromCyrillic(sourceResult));
    }

    public static void convertFromMorseToCyrillic(BufferedReader readerMorseLanguage, BufferedWriter writerLanguageFromMorse) throws IOException {
        String sourceReadMorse= readerMorseLanguage.readLine();
        StringBuilder sourceAddFromMorse = new StringBuilder();

        while (sourceReadMorse!= null){
            sourceAddFromMorse.append(sourceReadMorse).append("\n");
            sourceReadMorse=readerMorseLanguage.readLine();
        }

        String sourceResultFromMorse = new String(sourceAddFromMorse);
        writerLanguageFromMorse.write(Translator.stringToCyrillic(sourceResultFromMorse));
    }
    
    public static void convertFromMorseToLatin(BufferedReader readerMorseLanguage, BufferedWriter writerLanguageFromMorse) throws IOException {
        String sourceReadMorse= readerMorseLanguage.readLine();
        StringBuilder sourceAddFromMorse = new StringBuilder();

        while (sourceReadMorse!= null){
            sourceAddFromMorse.append(sourceReadMorse).append("\n");
            sourceReadMorse=readerMorseLanguage.readLine();
        }

        String sourceResultFromMorse = new String(sourceAddFromMorse);
        writerLanguageFromMorse.write(Translator.stringToLatin(sourceResultFromMorse));
    }
}
