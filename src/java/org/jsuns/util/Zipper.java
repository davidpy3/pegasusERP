package org.jsuns.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zipper {

    private final List<File> fileList = new ArrayList();

    public Zipper() {
    }

    public static void main(String[] args) throws Exception {
        Zipper appZip = new Zipper();
        appZip.generateFileList(new File("G:\\nn"));
        String comprezedFile = "G:\\nn\\file.zip";
        String encriptedFile = "G:\\nn\\file.enc";
        appZip.zipIt(comprezedFile);
        AES.encrypt(128, "coyote".toCharArray(),
                new FileInputStream(comprezedFile),
                new FileOutputStream(encriptedFile));
        AES.decrypt("coyote".toCharArray(),
                new FileInputStream(encriptedFile),
                new FileOutputStream("G:\\nn\\file2.zip"));
    }

    public void zipIt(String outFile) {
        byte[] buffer = new byte[1024];
        try {
            FileOutputStream fos = new FileOutputStream(outFile);
            try (ZipOutputStream zos = new ZipOutputStream(fos)) {
                System.out.println("Output to Zip : " + outFile);
                for (File file : this.fileList) {
                    System.out.println("File Added : " + file);
                    ZipEntry ze = new ZipEntry(file.getName());
                    zos.putNextEntry(ze);
                    try (FileInputStream in = new FileInputStream(file)) {
                        int len;
                        while ((len = in.read(buffer)) > 0) {
                            zos.write(buffer, 0, len);
                        }
                    }
                }
                zos.closeEntry();
                //remember close it
            }
            System.out.println("Done");
        } catch (IOException ex) {
            throw new RuntimeException("Falla al comprimir.",ex);
        }
    }

    public void generateFileList(File node) {
        if (node.isFile()) {
            fileList.add(node);
        } else if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename : subNote) {
                generateFileList(new File(node, filename));
            }
        }
    }

}
