package seedu.task.commons.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Writes and reads files
 */
public class FileUtil {

    private static final String CHARSET = "UTF-8";

    public static boolean isFileExists(File file) {
        return file.exists() && file.isFile();
    }

    public static void createIfMissing(File file) throws IOException {
        if (!isFileExists(file)) {
            createFile(file);
        }
    }

    /**
     * Creates a file if it does not exist along with its missing parent directories
     *
     * @return true if file is created, false if file already exists
     */
    public static boolean createFile(File file) throws IOException {
        if (file.exists()) {
            return false;
        }

        createParentDirsOfFile(file);

        return file.createNewFile();
    }

    /**
     * Creates the given directory along with its parent directories
     *
     * @param dir the directory to be created; assumed not null
     * @throws IOException if the directory or a parent directory cannot be created
     */
    public static void createDirs(File dir) throws IOException {
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("Failed to make directories of " + dir.getName());
        }
    }

    /**
     * Creates parent directories of file if it has a parent directory
     */
    public static void createParentDirsOfFile(File file) throws IOException {
        File parentDir = file.getParentFile();

        if (parentDir != null) {
            createDirs(parentDir);
        }
    }

    /**
     * Assumes file exists
     */
    public static String readFromFile(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), CHARSET);
    }

    /**
     * Writes given string to a file.
     * Will create the file if it does not exist yet.
     */
    public static void writeToFile(File file, String content) throws IOException {
        Files.write(file.toPath(), content.getBytes(CHARSET));
    }

    /**
     * Converts a string to a platform-specific file path
     * @param pathWithForwardSlash A String representing a file path but using '/' as the separator
     * @return {@code pathWithForwardSlash} but '/' replaced with {@code File.separator}
     */
    public static String getPath(String pathWithForwardSlash) {
        assert pathWithForwardSlash != null;
        assert pathWithForwardSlash.contains("/");
        return pathWithForwardSlash.replace("/", File.separator);
    }

    //@@author A0163559U
    /**
     * Compares the contents of two files.
     * @param f1 file 1
     * @param f2 file 2
     * @return true if file contents are identical
     * @throws IOException
     */
    public static boolean isFileContentSame(File f1, File f2) throws IOException {
        String fileAsString1 = readFromFile(f1);
        String fileAsString2 = readFromFile(f2);
        System.out.println(fileAsString1);
        System.out.println(fileAsString2);
        return fileAsString1.equals(fileAsString2);
    }
    //@@author

}
