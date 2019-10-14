package com.alfazid.siasd.utilities;


import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayOutputStream;
import com.google.zxing.client.j2se.MatrixToImageWriter;

/**
 * Created by cigist on 08/07/19.
 */
public class QrCode {
    public static byte[] getQRCodeImage(String text, int width, int height) {
        try {
            final Map<EncodeHintType, Object> encodingOption = new HashMap<>();
            encodingOption.put(EncodeHintType.MARGIN,1);
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height,encodingOption);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "png", byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            return null;
        }
    }
}
