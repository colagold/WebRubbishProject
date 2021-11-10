package com.sxu.rubbishclassify.Utils;

import java.util.List;

public interface FileUtil {
    public void uploadFile(byte[] file, String filePath, String fileName);
    public String getTargetInfo(List<Classifier.Recognition> recognitions);
}
