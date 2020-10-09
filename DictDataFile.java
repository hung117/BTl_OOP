import java.io.File;
import java.io.IOException;
// handle exception

public class DictDataFile {
    public void CreatFile() throws IOException {
        try{
            File myFile = new File("resouces.txt");
            if(myFile.createNewFile() == true){
                System.out.println("Create new file successfully! " + "\n" + "File name: " + myFile.getName());

            }else {
                System.out.println("File is not exist.");
            }
        }catch (IOException error){
            System.out.println("An Error Occured!");
            error.printStackTrace();
        }
    }
}
