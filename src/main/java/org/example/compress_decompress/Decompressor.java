package org.example.compress_decompress;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Decompressor {
    public static void method(File file) throws IOException {
        String fileDirectory = file.getParent();
        FileInputStream fis = new FileInputStream((file));
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/DecompressedFile.gz");
        GZIPInputStream gzip = new GZIPInputStream(fis);

        byte[] buffer = new byte[1024];
        int len;
        while( (len=gzip.read(buffer)) != -1 ){
            fos.write(buffer, 0, len);
        }
        gzip.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args) throws IOException {
        File path = new File ("C:\\Users\\praka\\Downloads\\Compressor And Decompressor\\DecompressedFile.gz");
        method(path);
    }
}
