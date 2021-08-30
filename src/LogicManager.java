import java.util.concurrent.ArrayBlockingQueue;

public class LogicManager {
    private final FileManager fileManager;
    private ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(5);

    public LogicManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void produceText(String text) {
        blockingQueue.offer(text);
    }

    public void consumeText() {
        String text = (String)blockingQueue.poll();
        if (text != null) {
            fileManager.writeToFile(text);
        }
    }
}
