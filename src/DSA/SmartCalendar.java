package DSA;
import java.util.*;
class Event {
   int id;
   String title;
   int time;
   int priority;
   public Event(int id, String title, int time, int priority) {
       this.id = id;
       this.title = title;
       this.time = time;
       this.priority = priority;
   }
   @Override
   public String toString() {
       return "Event{id=" + id + ", title='" + title + "', time=" + time + ", priority=" + priority + "}";
   }
}
public class SmartCalendar {
   public static void main(String[] args) {
       List<Event> events = new ArrayList<>();
       Map<Integer, Event> eventRecords = new HashMap<>();
       Scanner scanner = new Scanner(System.in);
       boolean running = true;
       while (running) {
           System.out.println("1. Add Event");
           System.out.println("2. Sort Events by Time");
           System.out.println("3. Sort Events by Priority");
           System.out.println("4. Search Event by Title");
           System.out.println("5. Exit");
           System.out.print("\nWhich Operation You Want To Perform: ");
           int choice = scanner.nextInt();
           scanner.nextLine();
           switch (choice) {
               case 1:
                   System.out.print("Enter event ID: ");
                   int id = scanner.nextInt();
                   scanner.nextLine();
                   if (eventRecords.containsKey(id)) {
                       System.out.println("Event with this ID already exists.");
                       break;
                   }
                   System.out.print("Enter event title: ");
                   String title = scanner.nextLine();
                   System.out.print("Enter event time (0-23): ");
                   int time = scanner.nextInt();
                   System.out.print("Enter event priority: ");
                   int priority = scanner.nextInt();
                   Event event = new Event(id, title, time, priority);
                   eventRecords.put(id, event);
                   events.add(event);
                   break;
               case 2:
                   bubbleSortByTime(events);
                   System.out.println("Sorted Events by Time: " + events);
                   break;
               case 3:
                   bubbleSortByPriority(events);
                   System.out.println("Sorted Events by Priority: " + events);
                   break;
               case 4:
                   System.out.print("Enter event title to search: ");
                   String searchTitle = scanner.nextLine();
                   Event foundEvent = linearSearchByTitle(events, searchTitle);
                   if (foundEvent != null) {
                       System.out.println("Event found: " + foundEvent);
                   } else {
                       System.out.println("Event not found.");
                   }
                   break;
               case 5:
                   running = false;
                   break;
               default:
                   System.out.println("Invalid option. Please try again.");
                   break;
           }
       }
       scanner.close();
   }
   public static void bubbleSortByTime(List<Event> events) {
       for (int i = 0; i < events.size() - 1; i++) {
           for (int j = 0; j < events.size() - i - 1; j++) {
               if (events.get(j).time > events.get(j + 1).time) {
                   Event temp = events.get(j);
                   events.set(j, events.get(j + 1));
                   events.set(j + 1, temp);
               }
           }
       }
   }
   public static void bubbleSortByPriority(List<Event> events) {
       for (int i = 0; i < events.size() - 1; i++) {
           for (int j = 0; j < events.size() - i - 1; j++) {
               if (events.get(j).priority < events.get(j + 1).priority) {
                   Event temp = events.get(j);
                   events.set(j, events.get(j + 1));
                   events.set(j + 1, temp);
               }
           }
       }
   }
   public static Event linearSearchByTitle(List<Event> events, String title) {
       for (Event event : events) {
           if (event.title.equals(title)) {
               return event;
           }
       }
       return null;
   }
}
