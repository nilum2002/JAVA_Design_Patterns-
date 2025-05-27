
class HTMLStringBuilder{
    private String htmlString = "";
    


    public HTMLStringBuilder appendBold(String text){
        htmlString += "<b>" + text + "</b>";
        // enable method chaining
        return this;
    }

    public HTMLStringBuilder appendItalic(String text){
        htmlString += "<i>" + text + "</i>";
        // enable method chaining
        return this;
    }
    public HTMLStringBuilder appendParagraph(String text){
        htmlString += "<p>" + text + "</p>";
        // enable method chaining
        return this;
    }
    public String build(){
        return htmlString;
    }
}

public class BuilderEx {
    public static void main(String[] args) {
        HTMLStringBuilder builder = new HTMLStringBuilder();
        String result = builder.appendBold("Bold Text")
                                .appendItalic("Italic Text")
                                .appendParagraph("Paragraph Text")
                                .build();
        System.out.println(result);
    }

}