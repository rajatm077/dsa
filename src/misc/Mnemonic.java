package misc;
import java.util.ArrayList;
import java.util.List;

public class Mnemonic {
    public static void main(String[] args) {
        List<String> mnemonics = getAllMnemonics("32");
        System.out.println(mnemonics);
    }

    private static List<String> getAllMnemonics(String input) {
        ArrayList<String> mnemonics = new ArrayList<>();
        char[] partialMnemonic = new char[input.length()];
        traverse(input, 0, partialMnemonic, mnemonics);
        return mnemonics;
    }

    private static final String[] MAPPING = {
        "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"
    };
    private static void traverse(String input, int index, char[] partialMnemonic, ArrayList<String> mnemonics) {
        if (index == input.length()) {
            mnemonics.add(String.valueOf(partialMnemonic));
        } else {
            String mapped = MAPPING[input.charAt(index) - '0'];
            for (int i = 0; i < mapped.length(); i++) {
                partialMnemonic[index] = mapped.charAt(i);
                traverse(input, index + 1, partialMnemonic, mnemonics);
            }
        }
    }
}
