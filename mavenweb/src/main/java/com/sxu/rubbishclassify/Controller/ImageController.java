package com.sxu.rubbishclassify.Controller;

import com.sxu.rubbishclassify.Utils.FileUtil;
import com.sxu.rubbishclassify.Utils.FileUtilImpl;
import com.sxu.rubbishclassify.Utils.detectors.Classifier;
import com.sxu.rubbishclassify.Utils.detectors.TFObjectDetector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class ImageController{
    @Resource
    HttpServletRequest request;

    @Value("${web.upload-path}")
    private String uploadPath;
    @Value("${web.model-path}")
    private String MODEL_PATH;
    @Value("${web.label-path}")
    private String LABEL_PATH;
    Classifier classifier;
    @PostConstruct
    public void init() {
        try {
            classifier = TFObjectDetector.create(MODEL_PATH, LABEL_PATH);
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    //处理文件上传
    @RequestMapping(value="/uploadImg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file) {
        StringBuffer fileName = new StringBuffer().append(System.currentTimeMillis()).append(".jpg");
        System.out.println(file.getSize());
        try {

            //new FileUtilImpl().uploadFile(file.getBytes(), uploadPath, fileName.toString());
            ByteArrayInputStream in = new ByteArrayInputStream(file.getBytes());    //将b作为输入流；
            BufferedImage image = ImageIO.read(in);
            //获取结果列表
            List<Classifier.Recognition> recognitionList = classifier.recognizeImage(image);
            //保存结果图片
            saveAnnotatedImage(image, recognitionList, uploadPath+fileName);
            return "https://www.sxujinjin.top/image/"+fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
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
