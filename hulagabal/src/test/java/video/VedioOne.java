package video;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_QUICKTIME;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_QUICKTIME_JPEG;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

public class VedioOne {
	private static ScreenRecorder screenRecorder;
	public static final String USER_DIR = "user.dir";
	public static final String DOWNLOADED_FILES_FOLDER = "videos";

public static  void start(String methodName) throws Exception{
	File file = new File(System.getProperty(USER_DIR) + File.separator + DOWNLOADED_FILES_FOLDER); 
	
	
		GraphicsConfiguration gc = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
		int width=(int) dimension.getWidth();
		int height=(int) dimension.getHeight();
		
				Rectangle captureSize=new Rectangle(0, 0, width, height);
				
		// Create a instance of ScreenRecorder with the required configurations
		screenRecorder = new Cusrome(gc,captureSize, new Format(MediaTypeKey,MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),  
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,ENCODING_QUICKTIME_JPEG, CompressorNameKey,  
                ENCODING_QUICKTIME_JPEG, DepthKey, (int) 24,FrameRateKey, Rational.valueOf(15), QualityKey, 1.0f,  
                KeyFrameIntervalKey, (int) (15 * 60)),  
                new Format(MediaTypeKey,MediaType.VIDEO, EncodingKey, "black", FrameRateKey,Rational.valueOf(30)),  
                null,file,methodName);  
				
				// Call the start method of ScreenRecorder to begin recording
				screenRecorder.start();
		
	
	}

	public static void stop() throws Exception {
		screenRecorder.stop();
	}

}
