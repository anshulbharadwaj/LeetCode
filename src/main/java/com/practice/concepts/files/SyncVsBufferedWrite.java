package com.practice.concepts.files;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SyncVsBufferedWrite {
    private static String HOME = System.getProperty("user.home");

    public static void main(String[] args) {
        String separator = FileSystems.getDefault().getSeparator();
        Path syncFilePath = Paths.get(HOME + separator + "Documents","synchronized_file.txt");
        Path bufferFilePath = Paths.get(HOME + separator + "Documents","buffered_file.txt");
        writeDataWithBuffered(syncFilePath);
        writeDataWithSync(bufferFilePath);
    }


    public static void writeDataWithBuffered(Path filePath) {
        try {
            FileChannel channel = FileChannel.open(filePath, StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            String content = "Sample data for buffered write\n";
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());

            // Write larger data
            int numberOfWrites = 1000; // Number of times to write the content

            for (int i = 0; i < numberOfWrites; i++) {
                channel.write(buffer);
                buffer.rewind(); // Rewind the buffer to write the same content again

                // Introduce a longer delay to simulate buffered behavior
                Thread.sleep(500);
            }

            channel.close(); // Close the channel

            System.out.println("Data written to file (Buffered): " + filePath);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void writeDataWithSync(Path filePath) {
        try {
            FileChannel channel = FileChannel.open(filePath, StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.SYNC);
            String content = "Sample data for SYNC write\n";
            ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());


            channel.write(buffer);
            channel.close(); // Close the channel
            System.out.println("Data written to file (SYNC): " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
