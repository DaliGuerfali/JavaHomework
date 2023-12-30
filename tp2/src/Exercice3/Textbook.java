package Exercice3;



public class Textbook extends Book {

    private final String topic;

    public Textbook(String title, String author, String topic, String year) {
        this.title = title;
        this.author = author;
        this.topic = topic;
        this.yearOfPublication = year;
    }

    public String getTopic() { return this.topic; }

    @Override
    public void displayInformation() {
        System.out.printf(
"------------------\nTextbook's Title: %s\nTextbook's Author: %s\nTextbook's Genre: %s\nTextbook's Year Of Publication: %s\n------------------\n",
                this.title,this.author,this.topic,this.yearOfPublication
        );
    }

}
