package com.szh.qrcode;

import com.dajie.common.file.enums.FileSavedType;
import com.dajie.common.file.model.UploadReturnModel;
import com.dajie.common.file.service.FileUploadService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class QRCodeUtil {

    public static InputStream createQRCode(String qrCodeData, int qrCodeheight, int qrCodewidth)
            throws WriterException, IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Map hintMap = new HashMap();
        hintMap.put(EncodeHintType.MARGIN, 1);
        String filePath = "qr.jpg";
        BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes("UTF-8"), "ISO-8859-1"),
                BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
        MatrixToImageWriter.writeToStream(matrix, "jpeg", outputStream);
        outputStream.flush();
        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    public static void main(String[] args) throws IOException, WriterException {
        InputStream inputStream = new FileInputStream(new File("/home/zhihaosong/workspace/com-szh-demo/src/main/java/com/szh/qrcode/wangjinrong.png"));
        // createQRCode("http://www.dajie.com?key=ksinak", 300, 300);
        System.out.println(inputStream);
        UploadReturnModel model = FileUploadService.uploadFromStream(inputStream, "test.jpg", FileSavedType.common_image);
        System.out.println();
    }
}
