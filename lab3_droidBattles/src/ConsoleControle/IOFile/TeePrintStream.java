package ConsoleControle.IOFile;
import java.io.*;

public class TeePrintStream extends PrintStream {

    private final PrintStream file;

    public TeePrintStream(OutputStream out, PrintStream file) {
        super(out);
        this.file = file;
    }

    @Override
    public void close() {
        super.close();
        file.close();
    }

    @Override
    public void flush() {
        super.flush();
        file.flush();
    }

    @Override
    public void write(int b) {
        super.write(b);
        file.write(b);
    }

    @Override
    public void write(byte[] buf, int off, int len) {
        super.write(buf, off, len);
        file.write(buf, off, len);
    }
}
