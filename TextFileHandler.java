public class TextFileHandler implements Handler {
    // เก็บตัวแปรของคนที่จะรับงานต่อ
    private Handler nextHandler;
    private String handlerName;

    public TextFileHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void process(File file) {
        //เช็คว่าใช่ไฟล์ "text" ไหท
        if ("text".equalsIgnoreCase(file.getFileType())) {
            System.out.println(handlerName + " is processing the text file: " + file.getFileName());
        } else if (nextHandler != null) {
            System.out.println(handlerName + " forwards request to next handler");
            nextHandler.process(file);
        } else {
            System.out.println("End of chain. File type '" + file.getFileType() + "' is not supported.");
        }
    }
}