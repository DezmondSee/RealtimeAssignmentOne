package my.dez;

import java.io.File;

public class FileCount
{
    // declare folder with private
    private final File folder;

    public FileCount(String path)
    {
        this.folder = new File(path);
    }

    //check the file is Valid or not
    public boolean ValidFol()
    {
        return folder.isDirectory() && folder.exists();
    }

    public File[] getFiles()
    {
        if(!ValidFol()){
            return null;
        }
        //lamba filter to select files with .java only
        return folder.listFiles((dir, name) -> name.endsWith(".java"));
    }

    //count number of java Files
    public int FileCount()
    {
        int numberCount = 0;
        File[] files = folder.listFiles();
        if(files != null)
        {
            for(File file : files)
            {
                if(file.getName().endsWith(".java") && file.isFile() )
                {
                    numberCount++;
                }
            }
        }
        return numberCount;
    }
}
