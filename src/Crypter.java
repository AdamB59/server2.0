/**
 * Created by Tastum on 17/10/2016.
 */
public class Crypter {


    private static String encryptDecryptXOR(String input) {

        char[] key = {'A', 'B', 'C'};

        // Opretter en StringBuilder således, at strengen kan modificeres
        StringBuilder output = new StringBuilder();

        // For loop der scrambler den indtastede streng
        for (int i = 0; i < input.length(); i++) {
            output.append((char) (input.charAt(i) ^ key[i % key.length]));
        }

        return output.toString();
    }

    public static String xor() {

        String communication = "test123";
        //Dette er bare et eksempel på en String, der bliver krypteret

        return Crypter.encryptDecryptXOR(communication) + "\n" + Crypter.encryptDecryptXOR(Crypter.encryptDecryptXOR(communication));
        //Returnerer den krypterede værdi.
    }

}
