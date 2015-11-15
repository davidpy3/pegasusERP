package edu.uns.sgsi.ejb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ejb.Stateless;

//import org.apache.commons.net.ftp.FTP;
//import org.apache.commons.net.ftp.FTPClient;

@Stateless
public class FTPService /*extends FTPClient*/ implements FTPServiceLocal {

    @Override
    public void move(File origin) {
//        String serverFTP = "192.168.150.11";
//        int portFTP = 21;
//        String userFTP = "cobian";
//        String passFTP = "123456";
//        try {
//            connect(serverFTP, portFTP);
//            login(userFTP, passFTP);
//            enterLocalPassiveMode();
//            setFileType(FTP.BINARY_FILE_TYPE);
//            // APPROACH #2: uploads second file using an OutputStream
//            //File origin = new File("D:/backup.rar");
//            String secondRemoteFile = "udemsi/respaldo/backup.rar";
//            OutputStream outputStream;
//            try (InputStream inputStream = new FileInputStream(origin)) {
//                System.out.println("Start uploading second file");
//                outputStream = storeFileStream(secondRemoteFile);
//                byte[] bytesIn = new byte[4096];
//                int read;
//                while ((read = inputStream.read(bytesIn)) != -1) {
//                    outputStream.write(bytesIn, 0, read);
//                }
//            }
//            outputStream.close();
//            boolean completed = completePendingCommand();
//            if (completed) {
//                System.out.println("The second file is uploaded successfully.");
//            }
//        } catch (IOException ex) {
//            throw new RuntimeException("FTP Exception.", ex);
//        } finally {
//            try {
//                if (isConnected()) {
//                    logout();
//                    disconnect();
//                }
//            } catch (IOException ex) {
//                throw new RuntimeException("FTP Exception.", ex);
//            }
//        }
    }

}