
package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        Program program = new Program();
        ArrayList<String> byteCodes = new ArrayList<>();

        String currentCode = null;

        try {
            currentCode = byteSource.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(currentCode != null){
            StringTokenizer tokenizer = new StringTokenizer(currentCode);
            byteCodes.clear();

            while(tokenizer.hasMoreTokens()){
                byteCodes.add(tokenizer.nextToken());
            }
        }
        program.resolveAddrs();
        return program;
    }
}
