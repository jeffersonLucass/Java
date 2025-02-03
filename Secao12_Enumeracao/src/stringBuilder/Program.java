package stringBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import stringBuilder_entities.Comment;
import stringBuilder_entities.Post;

public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		Comment c1 = new Comment("Have a nice trip!");
        Comment c2 = new Comment("Wow that's awesome!");
        
        LocalDateTime dateTime = LocalDateTime.parse("21/06/2018 13:05:44", dtf);

        Post p1 = new Post(dateTime,"Traveling to New Zealand","I'm going to visit this wonderful country!",12);
	
        p1.addComment(c1);
        p1.addComment(c2);
        
        Comment c3 = new Comment("Good night guys");
        Comment c4 = new Comment("May the Force be with you");
        
        LocalDateTime dateTime2 = LocalDateTime.parse("28/07/2018 23:14:19",dtf);
        
        Post p2 = new Post(dateTime2,"Good night guys", "See you tomorrow", 5);
        
        p2.addComment(c3);
        p2.addComment(c4);
        
        System.out.println(p1);
        System.out.println(p2);
        
        
        
	}

}
