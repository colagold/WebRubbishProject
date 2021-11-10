package com.sxu.rubbishclassify.Utils;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * 文件工具类
 */
public class FileUtilImpl implements FileUtil {
    @Override
    public void uploadFile(byte[] file, String filePath, String fileName) {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(file);    //将b作为输入流；
            BufferedImage image = ImageIO.read(in);
//            List<Classifier.Recognition> recognitionList = classifier.recognizeImage(image);
            //保存结果图片

            FileOutputStream out = new FileOutputStream(filePath+fileName);
            out.write(file);
            out.flush();
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public String getTargetInfo(List<Classifier.Recognition> recognitions) {
        return null;
    }

    public static boolean saveAnnotatedImage(BufferedImage image, List<Classifier.Recognition> recognitions, String outputImageFilePath) throws IOException {


        Graphics2D g2D = image.createGraphics();
        int x,y,width,heigth;
//        g2D.setColor (Color.getColor("#ff0000"));
        g2D.setStroke(new BasicStroke((image.getWidth() * 10) / 1000));
        g2D.setFont(new Font("DejaVuSans", Font.BOLD, 50));//Linux上的字体

        // 蓝色#00bfff
        // 红色#ff0000
        // 绿色#009900
        // 褐色#cc6600
        for (Classifier.Recognition recognition : recognitions) {
            x=(int)recognition.getLocation().getLeft();
            y=(int) recognition.getLocation().getTop();
            width=(int) (recognition.getLocation().getWidth() + 0.5);
            heigth=(int) (recognition.getLocation().getHeight() + 0.5);
            Rectangle rectangle = new Rectangle(
                    x,
                    y,
                    width,
                    heigth);
            String arr[]=recognition.getTitle().split("/");
            if(arr[1].equals("可回收物")) {
                g2D.setColor (Color.decode("#33ccff"));
            }else if(arr[1].equals("有害垃圾")) {
                g2D.setColor (Color.decode("#ff0000"));
            }else if(arr[1].equals("厨余垃圾")) {
                g2D.setColor (Color.decode("#009900"));
            }else {
                g2D.setColor (Color.decode("#cc6600"));
            }
            g2D.draw(rectangle);
            g2D.drawString(recognition.getTitle(),(int)recognition.getLocation().getLeft(), (int) recognition.getLocation().getTop()-5);

        }
        ImageIO.write(image, "jpg", new File(outputImageFilePath));
        return true;
    }

}