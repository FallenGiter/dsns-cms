package org.dsns.common.fileupload;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.fileupload.ProgressListener;
import org.dsns.common.utils.NumUtils;

public class ProgressWatcher implements ProgressListener {
	public static String UPLOADED_PERCENTAGE_PREFIX = "UPLOADED_PERCENTAGE_";
	
	private long megaBytes = -1L;
	
	private PrintWriter pw; 
	
	public ProgressWatcher(PrintWriter pw) throws IOException {
		this.pw = pw;
	}
	
	@Override
	public void update(long pBytesRead, long pContentLength, int pItems) {
		long mBytes = pBytesRead / 1000000L;
		if (megaBytes != mBytes) {
			megaBytes = mBytes;
			
			System.out.println("We are currently reading item " + pItems);
			
			if (pContentLength == -1) {
				System.out.println("So far, " + pBytesRead + " bytes have been read.");
			} else {
				System.out.println("So far, " + pBytesRead + " of " + pContentLength + " bytes have been read.");
				
				String pc = NumUtils.DF_00_DOT_00.format((double)(pBytesRead * 100) / (double)pContentLength) + "%";
				
				pw.println("<script type=\"text/javascript\">updateProgress('" + pc + "');</script>");
				pw.flush();
			}
		}
	}
}
