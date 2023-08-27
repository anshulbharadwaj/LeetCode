package com.practice.concepts.files;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class SyncVsNoSyncTimeDifference {
    private static String HOME = System.getProperty("user.home");

    public static void main(String[] args) {
        String separator = FileSystems.getDefault().getSeparator();
        Path syncFilePath = Paths.get(HOME + separator + "Documents","sync_file.txt");
        Path noSyncFilePath = Paths.get(HOME + separator + "Documents","no_sync_file.txt");
        long syncStartTime = System.nanoTime();
        writeDataToFile(syncFilePath,StandardOpenOption.SYNC);
        long syncEndTime = System.nanoTime();
        long noSyncStartTime = System.nanoTime();
        writeDataToFile(noSyncFilePath,StandardOpenOption.DSYNC);
        long noSyncEndTime = System.nanoTime();
        System.out.println("Time taken with SYNC option: " + (syncEndTime - syncStartTime) + " nanoseconds");
        System.out.println("Time taken without SYNC option: " + (noSyncEndTime - noSyncStartTime) + " nanoseconds");

    }

    public static void writeDataToFile(Path filePath, OpenOption...options){
        hasSyncOption(options);
        try(FileChannel channel = FileChannel.open(filePath, StandardOpenOption.WRITE, StandardOpenOption.CREATE,hasSyncOption(options)?StandardOpenOption.SYNC:StandardOpenOption.DSYNC)){
            String content = "Data using " + (hasSyncOption(options)?"SYNC":"NOSYNC") + "flag";
            channel.write(ByteBuffer.wrap(content.getBytes()));
        }catch (Exception exception){
            exception.getMessage();
        }
    }

    public static boolean hasSyncOption(OpenOption...options){
        return Arrays.stream(options).anyMatch(o->o.equals(StandardOpenOption.SYNC));
    }
}
