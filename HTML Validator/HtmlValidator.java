/*
   Cesar Escalona
   it-220 Programming 2
   6/3/2020
   This program will provide methods and bodies to be used with ValidatorMain
*/

import java.util.*;   // to use Queue

public class HtmlValidator {
   // fields
   private Queue<HtmlTag> tagQueue;
   
   // methods:
   public HtmlValidator() {
      // initialize the tagQueue field to be an empty queue
      // of HtmlTag objects
      tagQueue = new LinkedList<HtmlTag>();   // can also be new LinkedList<>;
   }
   public HtmlValidator(Queue<HtmlTag> tags) {
      if(tags == null) {
         throw new IllegalArgumentException("Tags are null");
      }      
      // Step 1: Make a new empty queue
      tagQueue = new LinkedList<HtmlTag>();
      
      // Step 2: copy all of the tags into tagQueue
      for(int i = 0; i < tags.size(); i++) {
         HtmlTag tag = tags.remove();  // remove the front and hold into variable
         tagQueue.add(tag); // add it to tagQueue (my copy)
         tags.add(tag);  // add it back to tags(Original Queue)
      }
   }
   
   public void addTag(HtmlTag tag) {
      // if empty throw an exception, if not add the tag to the back of the queue
      if(tag == null) {
         throw new IllegalArgumentException();
      }
      else {
         tagQueue.add(tag);
      }
   }
   
   public Queue<HtmlTag> getTags() {
      // return all of the tags
      return tagQueue;
   }
   
   public void removeAll(String element) {
      if(element.equals(null)) {
         throw new IllegalArgumentException("Element is null");
      }
      else {
         int originalSize = tagQueue.size();
         for(int i = 0; i < originalSize; i++) {
            HtmlTag temp = tagQueue.remove();
            if(!temp.getElement().equals(element)) {
               tagQueue.add(temp);  
            }
         }
      }
   }
   
   public void validate() {
      
      Stack<HtmlTag> s = new Stack<>();
      int indentSpaces = 0;
      
      int originalSize = tagQueue.size();
      for(int i = 0; i < originalSize; i++) {
         HtmlTag temp = tagQueue.remove();
         
         // if the tag self closes, add no spaces
         if(temp.isSelfClosing()) {
            for(int h = 0; h < indentSpaces; h++) {
               System.out.print(" ");
            }
         }
         // if the tag is an open tag add 4 spaces then print
         else if(temp.isOpenTag() == true) {
            s.push(temp);
            for(int j = 0; j < indentSpaces; j++) {
               System.out.print(" ");
            }
            // adds the spaces to the tag after it prints
            indentSpaces += 4;
         }
         // if the tag is not an opening tag, take 4 spaces away then print
         else if(!temp.isOpenTag() == true) {
            if(!temp.matches(s.peek())) {
               indentSpaces = 0;
               System.out.print("ERROR unexpected tag: ");
            }
            s.pop();
            indentSpaces -= 4;
            for(int k = 0; k < indentSpaces; k++) {
               System.out.print(" ");
            }
         }
         
         System.out.println(temp);
         tagQueue.add(temp);
      }
      // Error Handling
      if(!s.isEmpty()) {
         int ogSize = s.size();
         for(int a = 0; a <ogSize; a++) {
            System.out.println("ERROR unclosed tag: " + s.pop());
         }
      }
   }
} // end of class