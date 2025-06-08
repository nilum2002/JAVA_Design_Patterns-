
// interface strategy 
interface CompressStrategy {
    void compress(String Filename);
}
// compress strategies 

class ZipCompress implements CompressStrategy{
    @Override
    public void compress(String Filename){
        System.out.println("Compressing " + Filename + " using zip");

    }
}

class GzipCompress implements CompressStrategy{
    @Override
    public void compress(String Filename){
        System.out.println("Compressing " + Filename + " using Gzip");
    }
}
// the context 
class CompressingService {
    private CompressStrategy strategy;

    public void setStrategy(CompressStrategy strategy){
        this.strategy = strategy;
    }
    public void compressFile(String Filename){
        strategy.compress(Filename);
    }
}
public class StrategyEx {
    public static void main(String[] args) {
        CompressingService svr = new CompressingService();

        // select the strategy
        CompressStrategy strategy01 = new ZipCompress();
        CompressStrategy strategy02 = new GzipCompress();

        // set strategy 
        svr.setStrategy(strategy01);
        // compress file 
        svr.compressFile("Report.txt");
        // set new strategy
        svr.setStrategy(strategy02);
        // compress
        svr.compressFile("File.jason");

    }
}
