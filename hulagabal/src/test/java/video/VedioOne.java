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

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

public class VedioOne {
	private static ScreenRecorder screenRecorder;
	
	public static  void start() throws Exception{
		
		GraphicsConfiguration gc = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
				// Create a instance of ScreenRecorder with the required configurations
				screenRecorder = new ScreenRecorder(gc, new Format(MediaTypeKey,MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,ENCODING_QUICKTIME_JPEG, CompressorNameKey,
				ENCODING_QUICKTIME_JPEG, DepthKey, (int) 24,FrameRateKey, Rational.valueOf(15), QualityKey, 1.0f,
				KeyFrameIntervalKey, (int) (15 * 60)),
				new Format(MediaTypeKey,MediaType.VIDEO, EncodingKey, "black", FrameRateKey,Rational.valueOf(30)),
				null);
				
				// Call the start method of ScreenRecorder to begin recording
				screenRecorder.start();
		
	
	}
	
	public static void stop() throws Exception{
		screenRecorder.stop();
	}

}
