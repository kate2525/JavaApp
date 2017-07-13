package data;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DowlondFromInternet extends Thread {

    private static DowlondFromInternet str = new DowlondFromInternet();

    private DowlondFromInternet() {
    }

    public static DowlondFromInternet getInstance() {
        System.out.println("создание паттерна синглтон");
        return str;
    }

    private static final String LINK1 = "http://kiparo.ru/t/student.xml";
    private static final String LINK2 = "http://kiparo.ru/t/student.json";

    @Override
    public void run() {
        DowlondFromInternet d = new DowlondFromInternet();
        System.out.println("новый поток!");
        d.dowloandInternetXML();
        d.dowloandInternetJSON();
    }

    public void dowloandInternetXML() {

        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            URL url = new URL(LINK1);
            HttpURLConnection httpURLConnection
                    = (HttpURLConnection) url.openConnection();
            //получаем код ответа или ошибки
            int responceCode = httpURLConnection.getResponseCode();

            if (responceCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();

                File file = new File("student.xml");
                outputStream = new FileOutputStream(file);

                byte[] buffer = new byte[1024]; //1 мб информации
                int bytesRead = -1;//количество прочитанных байт за одно чтение read

                while ((bytesRead = inputStream.read(buffer)) != -1) {

                    //записываем в файл скачинаю информацию
                    outputStream.write(buffer, 0, bytesRead);
                }

            } else {

            }

        } catch (Exception ex) {
            System.out.println("error " + ex.toString());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e) {
                System.out.println("ошибка при закрытии " + e.toString());
            }
        }

    }

    public void dowloandInternetJSON() {

        InputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            URL url = new URL(LINK2);
            HttpURLConnection httpURLConnection
                    = (HttpURLConnection) url.openConnection();
            //получаем код ответа или ошибки
            int responceCode = httpURLConnection.getResponseCode();

            if (responceCode == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();

                File file = new File("student.json");
                outputStream = new FileOutputStream(file);

                byte[] buffer = new byte[1024]; //1 мб информации
                int bytesRead = -1;//количество прочитанных байт за одно чтение read

                while ((bytesRead = inputStream.read(buffer)) != -1) {

                    //записываем в файл скачинаю информацию
                    outputStream.write(buffer, 0, bytesRead);
                }

            } else {

            }

        } catch (Exception ex) {
            System.out.println("error " + ex.toString());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e) {
                System.out.println("ошибка при закрытии " + e.toString());
            }
        }

    }


}
