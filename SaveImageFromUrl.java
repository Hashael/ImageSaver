import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class SaveImageFromUrl {

	public static void main(String[] args) throws Exception {
		for(int i = 1; i < 10; i++) {
			String imageUrl = "http://localhost/images/"+i+".jpg";
			String destinationFile = "image"+i+".jpg";

			/* Save the image retrieved to a file */
			saveImage(imageUrl, destinationFile);
		}
	}

	/* Function to save the image to a file */
	public static void saveImage(String imageUrl, String destinationFile) throws IOException {
		URL url = new URL(imageUrl);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(destinationFile);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}

		is.close();
		os.close();
	}

}