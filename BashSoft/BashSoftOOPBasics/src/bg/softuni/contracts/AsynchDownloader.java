package bg.softuni.contracts;

public interface AsynchDownloader {

    void downloadOnNewThread(String fileUrl);
}
