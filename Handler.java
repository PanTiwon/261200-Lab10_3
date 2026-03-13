public interface Handler {
    void setNext(Handler handler);
    // เมธอดหลักสำหรับจัดการไฟล์
    void process(File file);
}