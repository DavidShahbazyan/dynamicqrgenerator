package arm.davsoft.dynamicqrgenerator.helpers.util;

import arm.davsoft.dynamicqrgenerator.model.api.QRType;
import arm.davsoft.dynamicqrgenerator.model.impl.QRTypeWiFiNetwork;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Hashtable;

/**
 * @author David Shahbazyan
 * @since Apr 07, 2017
 */
public class QRGenerator {
    public static BufferedImage generateImage(QRType data) throws WriterException {
        int qrCodeSize = 100;

        String content = data.getData();
//        String content = new QRTypeWiFiNetwork()
//                .setSsid("DavSoft-WiFi-2")
//                .setPass("eYn4$dyRKMN*GJK")
//                .setType("WPA")
//                .getData();
//        content.append("eYn4$dyRKMN*GJK");

        Hashtable<EncodeHintType, Object> hintMap = new Hashtable<>();

        // H = ~30% correction
        // L = ~7%  correction
        // M = ~15% correction
        // Q = ~25% correction
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");
//        hintMap.put(EncodeHintType.MARGIN, 0); /* default = 4 */

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, qrCodeSize, qrCodeSize, hintMap);

        int matrixWidth = bitMatrix.getWidth();
//        BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
        BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_ARGB);
        image.createGraphics();
        Graphics2D graphics = (Graphics2D) image.getGraphics();

//        graphics.setComposite(AlphaComposite.Clear);
        graphics.setColor(new Color(255, 255, 255, 0));
        graphics.fillRect(0, 0, matrixWidth, matrixWidth);

        Color mainColor = new Color(0, 0, 0);
        graphics.setColor(mainColor);

        //Write Bit Matrix as image
        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                if (bitMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }

        return image;
    }

    public static String generateImageAsBase64(QRType data) throws WriterException, IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        ImageIO.write(generateImage(data), "png", stream);
        return Base64.getEncoder().encodeToString(stream.toByteArray());
    }
}
