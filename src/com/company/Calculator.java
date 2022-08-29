package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void stringCalculator() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String s = reader.readLine();
        if (s.contains("+")) {
            String[] numbers = s.split("\""+"\\+"+"\"");
            builder.append(numbers[0]).append(numbers[1]);
            if (numbers[0].length() > 0 & numbers[0].length() <= 10 & numbers[1].length() > 0 & numbers[1].length() <= 10) {
                System.out.println("Output: " + builder.toString());
            } else {
                throw new IOException("Строка не должна превышать 10 символов");
            }
        } else if (s.contains("-")) {
            String[] numbers = s.split("\""+"\\-"+"\"");
            for (int i = 0; i < numbers[1].length(); ) {
                char c = numbers[1].charAt(i);
                if (numbers[0].length() > 0 & numbers[0].length() <= 10 & numbers[1].length() > 0 & numbers[1].length() <= 10) {
                    numbers[0] = numbers[0].replaceFirst("" + c, "");
                    numbers[1] = numbers[1].replaceFirst("" + c, "");
                } else {
                    builder.append(c);
                    i++;
                }
            }if(numbers[0].length() < 0 | numbers[0].length() > 10 | numbers[1].length() < 0 | numbers[1].length() > 10){
                throw new IOException("Строка не должна превышать 10 символов");
            }
            numbers[0] += builder;
            System.out.println("Output: "+ "\""+numbers[0]+"\"");
        }
        else if (s.contains("*")) {
            String[] numbers = s.split("\"" + "\\*");
            int n = Integer.parseInt(numbers[1]);
            String x = numbers[0];
            if (numbers[0].length() > 0 & numbers[0].length() <= 10 & numbers[1].length() > 0 & numbers[1].length() <= 10 & n<=10) {
                for (int i = 0; i < n; i++) {
                    String z = x.replace("\"", "");
                    builder.append(z);
                }if(builder.toString().length()>40){
                    String substring = builder.substring(0, 40);
                    System.out.println("Output: " +"\""+substring+"..."+"\"");

                }else {
                    System.out.println("Output:" +"\"" + builder.toString() + "\"");
                }

            }
            if(numbers[0].length() <0 | numbers[0].length() > 10 | numbers[1].length() < 0 | numbers[1].length() > 10 | n>10){
                throw new IOException("Строка не должна превышать 10 символов");
            }


        }
        else if (s.contains("/")) {
            String[] numbers = s.split( "\""+"\\/");
            int count=numbers[0].length();;
            int value = Integer.parseInt(numbers[1]);
            String x = numbers[0];
            if (numbers[0].length() > 0 & numbers[0].length() <= 10 & numbers[1].length() > 0 & numbers[1].length() <= 10 & value<=10) {
                for (int i = 0; i < value; i++) {
                    String z = x.replace("\"", "");
                    builder.append(z);
                }

                String builderresult=builder.toString();
                int result;
                result= count/value;
                String subStr = builderresult.substring(0, result);
                System.out.println(subStr);
            }
            else {
                throw new IOException("Строка не должна превышать 10 символов");
            }

        }

    }
}
