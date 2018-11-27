package silesiandictionary;

/**
 *
 * @author Mateusz Chmielewski
 */
public class FileClassRunnable implements Runnable
{
    private FileClass f;
    public FileClassRunnable(FileClass f)
    {
        this.f = f;
    }
    
    @Override
    public void run() 
    {
        f.fillMap(new FindWordClass().getTreeOfWords());
    }
    
    
}
