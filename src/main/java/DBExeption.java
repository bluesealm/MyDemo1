public class DBExeption extends RuntimeException{

    private String msg;
    public DBExeption(){

    }
    public DBExeption(String msg){
       this.msg=msg;
    }
    public String getMsg(){
        return msg;
    }
}

class TestExceptions {

    public static void main(String[] args)

    {
      try
        {
          throw new DBExeption("No row found for id : x");
        }

        catch(Exception e) {
            e.printStackTrace();
        }
    }
}