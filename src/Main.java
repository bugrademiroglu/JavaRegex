// imported all the libraries that we will use

import org.jetbrains.annotations.Contract;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    @Contract(pure = true)
    public static String GetRomanText(Matcher m) {
        String[] roman = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "IX"};
        String result = "";
        //Get the ASCII value of the first character in the match,
        char c = 48;
        //It should be a number, test for safety:
        if (c >= 48 && c <= 57) {
            int index = c - 48;
            result = roman[index];
        }

        return result;
    }

    public static void main(String[] argv) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter here your output txt file source");
        String input = scan.nextLine();
        String filename = input;
        BufferedReader rd = new BufferedReader(new FileReader(input));


        String REGEX = "\\bor\\b";
        String REGEX2 = "\\band\\b";
        String REGEX3 = "(.+|(s))$";
        String REGEX4 = "((t|c|e|g|k|r))$"; // sonu ... ile biten kelimeler
        String REGEX5 = "((us|ss|hs|sh|ch|ax|tz))$";  // sonu ... ile biten kelimeler
        String REGEX6 = "(.+|(es))$";
        String REGEX7 = "[A-Z].*(said)+(?=\\\\\\\\h+\\\\\\\\S+$)|[.].*(said)+(?=\\\\\\\\h+\\\\\\\\S+$)";
        String REGEX8 = "";
        String REGEX9 = "\\p{P}+$";
        String REGEX10 = "[a-zA-Z](([0-9]){2,})[a-zA-Z]";
        String REGEX11 = "\\d?=()";
        String REGEX12 = "(.+|(ed))$";
        String REGEX13 = "((lk|ch))$"; // sonu ... ile biten kelimeler
        String REGEX14 = "((eg|ag))$";  // sonu ... ile biten kelimeler
        String REGEX15 = "(.+|(ged))$";
        String REGEX16 = "(.*)([’])([s])\\s([a-zA-Z]*)";
        String REGEX17 = "(.*)(said)(\\s[a-zA-Z]*)[.]";
        String REGEX18 = "(())*-?(\\d+)-?(\\d+)\\D*?(\\d*)+";
        String REGEX19 = "(?![@',&])\\p{Punct}[^']";


        String REPLACE = "/";
        String REPLACE2 = "&";
        String REPLACE3 = "$1s";
        String REPLACE4 = "";
        String REPLACE5 = "/";
        String REPLACE6 = "$1es";
        String REPLACE7 = "";
        String REPLACE8 = "/";
        String REPLACE9 = ".";
        String REPLACE10 = "$1";
        String REPLACE11 = "/";
        String REPLACE12 = "$1ed";
        String REPLACE13 = "/";
        String REPLACE14 = "/";
        String REPLACE15 = "$1ged";


        Pattern p = Pattern.compile(REGEX);
        Pattern p2 = Pattern.compile(REGEX2);
        Pattern p3 = Pattern.compile(REGEX3);
        Pattern p4 = Pattern.compile(REGEX4);
        Pattern p5 = Pattern.compile(REGEX5);
        Pattern p6 = Pattern.compile(REGEX6);
        Pattern p7 = Pattern.compile(REGEX7);
        Pattern p8 = Pattern.compile(REGEX8);
        Pattern p9 = Pattern.compile(REGEX9);
        Pattern p10 = Pattern.compile(REGEX10);
        Pattern p11 = Pattern.compile(REGEX11);
        Pattern p12 = Pattern.compile(REGEX12);
        Pattern p13 = Pattern.compile(REGEX13);
        Pattern p14 = Pattern.compile(REGEX14);
        Pattern p15 = Pattern.compile(REGEX15);
        Pattern p16 = Pattern.compile(REGEX16);
        Pattern p17 = Pattern.compile(REGEX17);
        Pattern p18 = Pattern.compile(REGEX18);
        Pattern p19 = Pattern.compile(REGEX19);


        String line;
        try (FileWriter writer = new FileWriter("outputnew.txt");
             BufferedWriter bw = new BufferedWriter(writer)) {
        while ((line = rd.readLine()) != null) {

                Matcher m = p.matcher(line);
                Matcher m2 = p2.matcher(line);
                Matcher m3 = p3.matcher(line);
                Matcher m4 = p4.matcher(line);
                Matcher m5 = p5.matcher(line);
                Matcher m6 = p6.matcher(line);
                Matcher m7 = p7.matcher(line);
                Matcher m8 = p8.matcher(line);
                Matcher m9 = p9.matcher(line);
                Matcher m10 = p10.matcher(line);
                Matcher m11 = p11.matcher(line);
                Matcher m12 = p12.matcher(line);
                Matcher m13 = p13.matcher(line);
                Matcher m14 = p14.matcher(line);
                Matcher m15 = p15.matcher(line);
                Matcher m16 = p16.matcher(line);
                Matcher m17 = p17.matcher(line);
                Matcher m18 = p18.matcher(line);
                Matcher m19 = p19.matcher(line);
            bw.write(line.substring(0, 1).toUpperCase() + line.substring(1).toLowerCase());

                // [\S]+(|t|c|e|g|k|r|cat|\b) ile biten cümlelere m3 teki regexi kullanarak s takýsý ekle
                if (m4.find()) {
                    line = m3.replaceAll(REPLACE3);
                    bw.write(line);
                    bw.newLine();
                }
                //  and içeren cümleleri & ile deðiþtir.
                if (m2.find()) {
                    line = m2.replaceAll(REPLACE2);
                    bw.write(line);
                    bw.newLine();
                }
                //
                if (m5.find()) {
                    line = m6.replaceAll(REPLACE6);
                    bw.write(line);
                    bw.newLine();
                }
                if (m.find()) {
                    line = m.replaceAll(REPLACE);
                    bw.write(line);
                    bw.newLine();
                }

                if (m7.find()) {

                }

                if (m9.find()) {
                    line = m9.replaceAll(REPLACE9);
                    bw.write(line);
                    bw.newLine();
                }

                if (m10.find()) {
                    //line = m10.replaceAll(GetRomanText(m10));
                    if (Integer.parseInt(m10.group(2).trim()) == 1) {
                        line = line.replaceAll((m10.group(2)), "I");
                        bw.write(line);
                        bw.newLine();
                    }
                    if (Integer.parseInt(m10.group(2)) == 2) {
                        line = line.replaceAll((m10.group(2)), "II");
                        bw.write(line);
                        bw.newLine();
                    }
                    if (Integer.parseInt(m10.group(2)) == 3) {
                        line = line.replaceAll((m10.group(2)), "III");
                        bw.write(line);
                        bw.newLine();
                    }
                    if (Integer.parseInt(m10.group(2)) == 4) {
                        line = line.replaceAll((m10.group(2)), "IV");
                        bw.write(line);
                        bw.newLine();
                    }
                    if (Integer.parseInt(m10.group(2)) == 5) {
                        line = line.replaceAll((m10.group(2)), "V");
                        bw.write(line);
                        bw.newLine();
                    }
                    if (Integer.parseInt(m10.group(2)) == 6) {
                        line = line.replaceAll((m10.group(2)), "VI");
                        bw.write(line);
                        bw.newLine();
                    }
                    if (Integer.parseInt(m10.group(2)) == 7) {
                        line = line.replaceAll((m10.group(2)), "VII");
                        bw.write(line);
                        bw.newLine();
                    }
                    if (Integer.parseInt(m10.group(2)) == 8) {
                        line = line.replaceAll((m10.group(2)), "VII");
                        bw.write(line);
                        bw.newLine();
                    }
                    if (Integer.parseInt(m10.group(2)) == 9) {
                        line = line.replaceAll((m10.group(2)), "IX");
                        bw.write(line);
                        bw.newLine();
                    }

                }

                if (m13.find()) {
                    line = m12.replaceAll(REPLACE12);
                    bw.write(line);
                    bw.newLine();
                }

                if (m14.find()) {
                    line = m15.replaceAll(REPLACE15);
                    bw.write(line);
                    bw.newLine();
                }

                if (m16.find()) {
                    line = line.replaceAll(m16.group(), "the " + m16.group(4) + " of " + m16.group(1));
                    bw.write(line);
                    bw.newLine();
                }

                if (m17.find()) {
                    line = line.replaceAll(m17.group(), '"' + m17.group(1) + m17.group(2) + '"' + m17.group(3) + ".");
                    bw.write(line);
                    bw.newLine();
                }

                if (m18.find()) {
                    line = line.replaceAll("\\p{Punct}", "");
                    line = line.replaceAll("\\s", "");
                    line = line.replaceAll(m18.group(), "Phone:" + m18.group(0) + "-");
                    bw.write(line);
                    bw.newLine();
                }

                if (m19.find()) {
                    line = line.replaceAll("(^\\p{P}+)(.+)(\\p{P}+$)", "$2$1$3");
                    bw.write(line);
                    bw.newLine();
                }


                // Mary's swimsuit --> The swimsuit of Mary
                // Bugra's Car     --> The car of Bugra
                // The + last word + of + ilk word
                // Kemal's world.
                //The world of Kemal

                // Eðer 's takýlý bir cümle görürse find et
                // O cümleye üstteki regexi yapýcak regexi uygula.





            /* Matcher m2 = p2.matcher(line2);
            Matcher m3 = p3.matcher(line3);
            Matcher m4 = p4.matcher(line4);
            Matcher m5 = p5.matcher(line5);
            Matcher m6 = p6.matcher(line6);
            Matcher m7 = p7.matcher(line7);
            Matcher m8 = p8.matcher(line8);
            Matcher m9 = p9.matcher(line9);
            Matcher m10 = p10.matcher(line10);*/



            /* .replace(" and ","&")
                    .replaceAll("(.+|(s).+(|x|sh|ch))$","$1s|$1es")
                    .replaceAll("said*","")
            .replaceAll("(?<!^0| )A$J+^", "").toLowerCase();
            //.replaceAll("[\\p{Punct}&&[^_-]]", ""); */


                System.out.println(line.substring(0, 1).toUpperCase() + line.substring(1).toLowerCase());


            }

        }


    }
}