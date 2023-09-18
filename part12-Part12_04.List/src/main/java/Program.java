public class Program {

    public static void main(String[] args) {
        // test your class here
        List<String> myList = new List<>();
        System.out.println(myList.contains("hello"));
        myList.add("hello");
        System.out.println(myList.contains("hello"));
        int index = myList.indexOfElement("hello");
        System.out.println(index);
        System.out.println(myList.get(index));
        myList.remove("hello");
        System.out.println(myList.contains("hello"));

        System.out.println("--------------------------------");

        List<String> myOtherList = new List<>();
        myOtherList.add("hello");
        myOtherList.add("world");
        for (int i = 0; i < myOtherList.size(); i++) {
            System.out.println(myOtherList.get(i));
        }
    }

}
