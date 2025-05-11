package my.dez;

import java.io.*;
import javax.tools.*;

//check file
public class issueCount
{
    public int countIss(File[] files)
    {
        //declare for number of file count
        int count=0;

        //check files
        if(files != null){
            for (File file : files){
                if(file.isFile() && file.getName().endsWith(".java")){
                    //count if compile success
                    if(compile(file)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //method to compile java and get compile results
    private boolean compile(File file)
    {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if(compiler == null)
        {
            System.out.println("Compiler Not Found, Please Use JDK");
            return false;
        }

        // hide error message
        OutputStream dummy = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
             //no error message
            }
        };

        //compile java file
        int result = compiler.run(null,new PrintStream(dummy), new PrintStream(dummy),file.getPath());

        return result == 0;
        //0 means successful compile, non means error found
    }
}
