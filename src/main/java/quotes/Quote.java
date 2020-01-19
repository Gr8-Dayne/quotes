package quotes;

public class Quote {

    int id;
    String starWarsQuote;
    String text;
    String author;

    public Quote(int id, String starWarsQuote, String author) {
        this.id = id;
        this.starWarsQuote = starWarsQuote;
        this.author = author;
    }
}

// Class demo code:

//public class Cat {
//    String name;
//    boolean sharpClaws;
//    String color;
//    String favoriteFood;
//    int hairLengthInCm;
//
//    public Cat(String name, boolean sharpClaws, String color, String favoriteFood, int hairLengthInCm) {
//        this.name = name;
//        this.sharpClaws = sharpClaws;
//        this.color = color;
//        this.favoriteFood = favoriteFood;
//        this.hairLengthInCm = hairLengthInCm;
//    }
//
//    public void sneak(){
//        if(this.sharpClaws == false){
//            System.out.println("sneak sneak sneak sneak");
//        } else {
//            System.out.println("click click click click");
//        }
//    }
//}


