<<<<<<< HEAD
package com.project.code_manager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec("ping baidu.com");
            InputStreamReader reader = new InputStreamReader(p.getInputStream());
            LineNumberReader input = new LineNumberReader(reader);

            String line;
            while((line = input.readLine()) != null) System.out.println(line);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
=======
package com.project.code_manager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
        try {
            Process p = Runtime.getRuntime().exec("ping baidu.com");
            InputStreamReader reader = new InputStreamReader(p.getInputStream());
            LineNumberReader input = new LineNumberReader(reader);

            String line;
            while((line = input.readLine()) != null) System.out.println(line);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
>>>>>>> ac191af (update)
