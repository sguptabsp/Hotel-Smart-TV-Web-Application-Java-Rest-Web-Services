package de.vogella.jersey.first;

import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.onbarcode.barcode.QRCode;

@Path("/barcodeGenerator")
public class BarcodeGenerator {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String randomGenerator(
			@QueryParam("barcodeText") String barcodeText,
			@QueryParam("callback") String callback,
			@Context HttpServletResponse servletResponse) throws SQLException {
		String responseStr= null;
		try {
			//Creating QRcode barcode
			QRCode barcode = new QRCode();
			barcode.setData(barcodeText);
			barcode.setBarcodeHeight(500);
			barcode.setBarcodeWidth(500);
			barcode.setDataMode(0);
			barcode.setResolution(400);
						
			boolean b = barcode.drawBarcode("D://BarcodeImages/barcode.gif");
			System.out.println("Barcode val :- " + b);
			if(b == true){
				responseStr = "Success";
			}else{
				responseStr = "Failure";
			}
		} catch (Exception e) {
			System.out.println("Exception:-" + e);
			responseStr = "Failure";
		}
		return responseStr;
	}
}
