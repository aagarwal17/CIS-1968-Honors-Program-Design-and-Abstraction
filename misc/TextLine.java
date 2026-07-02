package lab5;
public class TextLine{
    public int lineNumber;
    public String text;
    public TextLine(int l, String t){
        this.lineNumber = l;
        this.text = t;
    }  
    public int compareTo(TextLine t){ //Compares line numbers for two textLines
        if (this.lineNumber > t.lineNumber){
            return 1; //Larger
        }else if(this.lineNumber < t.lineNumber){
            return -1; //Smaller
        }else return 0; //Else, line numbers are equal
    }
}
