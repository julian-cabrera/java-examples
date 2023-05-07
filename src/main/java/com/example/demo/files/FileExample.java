package com.example.demo.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

import com.example.demo.OneInterfaceToRunThemAll;

public class FileExample implements OneInterfaceToRunThemAll {
  private File dir = new File("directory");
  private File file = new File("directory", "test.txt");

  @Override
  public void runExample() {
    System.out.println("\n*** Files ***");
    createFiles();
    // writeFiles();
    // readFiles();
    writeFilesBufferedWriter();
    readFilesBufferedReader();
    deleteFiles();
  }

  private void createFiles() {
    dir.mkdir();

    try {
      System.out.println("Created new file { " + file.createNewFile() + " } in " + file.getAbsolutePath());
    } catch (IOException e) {
      System.out.println("IOExeption: " + e.getMessage());
    }
  }

  private void writeFiles() {
    try {
      FileOutputStream outputStream = new FileOutputStream(file);
      String str = "Hello World!\nThis is a test file.";
      byte[] strBytes = str.getBytes();
      outputStream.write(strBytes);
      outputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void writeFilesBufferedWriter() {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
      writer.write("Writing files with BufferedWriter!");
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void readFiles() {
    try {
      FileInputStream inputStream = new FileInputStream(file);
      int data = inputStream.read();
      while ((data = inputStream.read()) != -1) {
        System.out.print((char) data);
      }
      System.out.println();
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void readFilesBufferedReader() {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(file));
      StringBuilder content = new StringBuilder();
      String line;

      while ((line = reader.readLine()) != null) {
        content.append(line);
        content.append(System.lineSeparator());
      }
      System.out.println("Looping:\n" + content);

      // Other method:
      // String txt = readAllLinesWithStream(reader);
      // System.out.println("OneLiner:\n" + txt);

      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String readAllLinesWithStream(BufferedReader reader) {
    return reader.lines()
        .collect(Collectors.joining(System.lineSeparator()));
  }

  private void deleteFiles() {
    if (file.exists()) {
      System.out.println("Deleted file: " + file.delete());
    }
    if (dir.exists()) {
      System.out.println("Deleted directory: " + dir.delete());
    }
  }

}