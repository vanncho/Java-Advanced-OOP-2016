package bg.softuni.contracts;

public interface Downloader extends AsynchDownloader {

    void download(String fileUrl);
}
