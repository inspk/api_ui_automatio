package com.hhstechgroup.utility;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
* Little program that creates multiple files when needed in a given location
* Was created on behalf of Fiyaz based on Configuration
 */

public class fileCreator {
        public static void main(String[] args) throws IOException {
            int numFiles = 10000;
            String location = "D://HHS Tech Group//My SecuriSync//SD PECS TECH//Conversion//Random Files//";
            String fileExtension = ".txt";

            for(int i=0; i<numFiles; i++) {
                String s = "HHS Tech Group! This is a Test File number: " + i ;
                byte data[] = s.getBytes();
                Path path = Paths.get(location+i+fileExtension);
                try (OutputStream out = new BufferedOutputStream(
                        Files.newOutputStream(path, CREATE, APPEND))) {
                    out.write(data, 0, data.length);
                    System.out.println("File Number: " + i + "added in the given Location");
                } catch (IOException x) {
                    System.err.println(x);
                }
            }
        }
    }
