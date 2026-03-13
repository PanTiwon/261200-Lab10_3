public class DocumentFileHandler implements Handler {
    private Handler nextHandler;
    private String handlerName;

    public DocumentFileHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    @Override
    public void setNext(Handler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void process(File file) {
        // เช็คว่าใช่ไฟล์ "document" ไหม
        if ("document".equalsIgnoreCase(file.getFileType())) {
            System.out.println(handlerName + " is processing the document file: " + file.getFileName());
        } else if (nextHandler != null) {
            System.out.println(handlerName + " forwards request to next handler");
            nextHandler.process(file);
        } else {
            System.out.println("End of chain. File type '" + file.getFileType() + "' is not supported.");
        }
    }
}