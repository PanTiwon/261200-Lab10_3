public class Main {
    public static void main(String[] args) {

        Handler textHandler = new TextFileHandler("TextHandler");
        Handler docHandler = new DocumentFileHandler("DocumentHandler");
        Handler imageHandler = new ImageFileHandler("ImageHandler");

        textHandler.setNext(docHandler);
        docHandler.setNext(imageHandler);

        File textFile = new File("README.txt", "text", "/home/docs");
        File docFile = new File("Document.doc", "document", "/home/docs");
        File imageFile = new File("Picture.jpg", "image", "/home/images");
        File audioFile = new File("Song.mp3", "audio", "/home/audio");

        // เทสโยนไฟล์เข้า Chain (เวลาส่ง ต้องเริ่มส่งที่ตัวแรกสุดของ Chain เสมอ)
        System.out.println("Processing text file:");
        // Text จัดการเองได้เลยจบ
        textHandler.process(textFile);

        System.out.println("\nProcessing document file:");
        // Text โยนให้ Doc จัดการ
        textHandler.process(docFile);

        System.out.println("\nProcessing image file:");
        // Text โยนให้ Doc -> Doc โยนให้ Image
        textHandler.process(imageFile);

        System.out.println("\nProcessing audio file:");
        // โยนไปจนสุดทาง แต่ไม่มีใครรับไฟล์ audio เลยตกขอบไป
        textHandler.process(audioFile);
    }
}