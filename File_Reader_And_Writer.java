import java.util.*;
import java.io.*;
class File_Reader_And_Writer {
    private static void write_file(File file, boolean append){
        Scanner get_user_input = new Scanner(System.in);
        try(FileWriter writer = new FileWriter(file,append)){
            System.out.print("Enter your sentence to Add :");
            String add_to_file = get_user_input.nextLine();
            writer.write(add_to_file+"\n");
            System.out.println("Successfully Added to the File");
        }catch(Exception e){System.out.println("Error..!");}
    }
    private static void read_file(File file){
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            for(String sentences : reader.lines().toList()) System.out.println(sentences);
        }catch(Exception e){System.out.println("Error..!");}
    }
    public static void main(String[] args) {
        try{
            System.out.print("Enter the Location : ");
            Scanner get_user_input = new Scanner(System.in);
            final String user_file_path = get_user_input.next();
            File file = new File(user_file_path);
            if(!file.exists()) file.createNewFile();
            boolean run = true;
            while(run){
                System.out.print("1.Read 2.Write 3.Exit ");
                int choice = get_user_input.nextInt();
                switch(choice){
                    case 1-> {
                        read_file(file);
                        break;
                    }
                    case 2-> {
                        System.out.print("write or append : ");
                        char user_input = get_user_input.next().charAt(0);
                        write_file(file,user_input == 'a');
                        // user_input == a - Adds sentence from the end
                        // user_input != a - Adds Sentence from the start
                        break;
                    }
                    case 3-> {
                        run = false;
                        System.out.println("Exitting...");
                        break;
                    }
                    default-> System.out.println("Invalid Input Press 1 or 2 ..!");
                }
            }
        }catch(Exception e){System.out.println("An Error Occurred ..!");}
    }
}
