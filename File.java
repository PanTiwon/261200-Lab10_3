public class File {
    private String fileName;
    private String fileType;
    private String filePath;
    // รับค่าตอนสร้าง Object
    public File(String fileName, String fileType, String filePath) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
    }
    // เอาไว้ดึงค่าไปใช้
    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public String getFilePath() {
        return filePath;
    }
}