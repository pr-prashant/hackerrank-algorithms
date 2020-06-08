package org.hackerrank.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class FirstRepeastResult {

    /*
     * Complete the 'firstRepeatedWord' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING sentence as parameter.
     */

    public static String firstRepeatedWord(String sentence) {
        // Write your code here
        sentence = sentence.replaceAll("\\s+", " ");
        String[] strings = sentence.split(" |,|:|;|-|\\.");
        int index = 1000000000;
        String str = null;
        for(int i=0; i<strings.length; i++) {
            String s = strings[i].trim();
            if(!s.equals("")) {
                for(int j=i; j<strings.length; j++) {
                    if(strings[j].equals(s) && (j-i)>0 && (j-i) < index) {
                        index = (j-i);
                        str = s;
                    }
                }
                /*int currentIndex = sentence.indexOf(s);
                int tempIndex = sentence.indexOf(strings[i],currentIndex+1);
                if(tempIndex >= 0 && (tempIndex-currentIndex) > 0 && (tempIndex-currentIndex) <index) {
                    index = (tempIndex-currentIndex);
                    str = s;
                }*/
            }
        }
        System.out.println(str);
        return str;
    }

}

public class FirstRepeatedWord {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String sentence = bufferedReader.readLine();

        String result = FirstRepeastResult.firstRepeatedWord(sentence);

//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
        bufferedReader.close();
//        bufferedWriter.close();
    }
}
